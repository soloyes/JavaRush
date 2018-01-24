package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int port = ConsoleHelper.readInt();
        try {
            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Server started");
            for (;;){
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendBroadcastMessage(Message message){
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

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection)
                throws IOException, ClassNotFoundException {

            String data = null;
            for (;;) {

                connection.send(new Message(MessageType.NAME_REQUEST));
                Message receive = connection.receive();
                MessageType messageType = receive.getType();
                data = receive.getData();

                if (messageType != MessageType.USER_NAME) continue;
                if (data.isEmpty()) continue;
                if (connectionMap.get(data) != null) continue;

                connectionMap.put(data, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                break;
            }
            return data;
        }

        private void sendListOfUsers(Connection connection, String userName){
            for (Map.Entry<String, Connection> entry:connectionMap.entrySet()){
                if (!entry.getKey().equals(userName))
                    try {
                        connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }

        private void serverMainLoop(Connection connection, String userName)
                throws IOException, ClassNotFoundException {

            for (;;){
                Message receive = connection.receive();
                MessageType messageType = receive.getType();

                if (messageType != MessageType.TEXT) {
                    ConsoleHelper.writeMessage("Error with message send");
                    continue;
                }

                Message send = new Message(MessageType.TEXT, userName + ": " + receive.getData());
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
