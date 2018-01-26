package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Input server port:");
        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Server started");
            for (;;){
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error with server start");
            e.printStackTrace();
        }
    }

    static void sendBroadcastMessage(Message message){
        for (Map.Entry<String, Connection> entry:connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Unable to send message");
            }
        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection)
                throws IOException, ClassNotFoundException {

            String userName;
            for (;;) {

                connection.send(new Message(MessageType.NAME_REQUEST));
                Message receive = connection.receive();
                userName = receive.getData();

                if (receive.getType() != MessageType.USER_NAME) continue;
                if (userName.isEmpty()) continue;
                if (connectionMap.get(userName) != null) continue;

                connectionMap.put(userName, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                break;
            }
            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName){
            for (Map.Entry<String, Connection> entry:connectionMap.entrySet()){
                if (!entry.getKey().equals(userName)) {
                    try {
                        connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                    } catch (IOException e) {
                        ConsoleHelper.writeMessage("Error with message send");
                        e.printStackTrace();
                    }
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName)
                throws IOException, ClassNotFoundException {

            for (;;){
                Message receive = connection.receive();
                String msg = receive.getData();

                if (receive.getType() != MessageType.TEXT) {
                    ConsoleHelper.writeMessage("Error with message type");
                    continue;
                }

                Message send = new Message(MessageType.TEXT, userName + ": " + msg);
                sendBroadcastMessage(send);
            }
        }

        @Override
        public void run() {
            String name = null;
            ConsoleHelper.writeMessage("Connection established with " + socket.getRemoteSocketAddress());

            try (Connection connection = new Connection(socket)){
                name = serverHandshake(connection);
                sendListOfUsers(connection, name);
                Message send = new Message(MessageType.USER_ADDED, name);
                sendBroadcastMessage(send);

                serverMainLoop(connection, name);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            finally {
                if(name != null) connectionMap.remove(name);
                Message send = new Message(MessageType.USER_REMOVED, name);
                sendBroadcastMessage(send);
            }

        }
    }
}
