package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {

    protected Connection connection;

    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Input server address:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Input server port:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Input name:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            Message send = new Message(MessageType.TEXT, text);
            connection.send(send);
        } catch (IOException e) {
            clientConnected = false;
            ConsoleHelper.writeMessage("Error with message sent");
        }
    }

    public void run(){
        Thread thread = getSocketThread();
        thread.setDaemon(true);
        thread.start();

        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Interrupted");
            }
        }

        if (clientConnected)
            ConsoleHelper.writeMessage("Connected. Type 'exit' to exit.");
        else {
            ConsoleHelper.writeMessage("Client working error.");
            return;
        }

        for(;clientConnected;){
            String s = ConsoleHelper.readString();
            if (s.equals("exit")) return;
            if (shouldSendTextFromConsole()){
                sendTextMessage(s);
            }
        }
    }

    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " joined to chat");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " leave chat");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            for (;;){
                Message receive = connection.receive();
                if (receive.getType() == MessageType.NAME_REQUEST){
                    String userName = getUserName();
                    Message send = new Message(MessageType.USER_NAME, userName);
                    connection.send(send);
                }
                else if (receive.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    return;
                }
                else throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            for (;;){
                Message receive = connection.receive();
                if (receive.getType() == MessageType.TEXT){
                    processIncomingMessage(receive.getData());
                }
                else if (receive.getType() == MessageType.USER_ADDED){
                    informAboutAddingNewUser(receive.getData());
                }
                else if (receive.getType() == MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(receive.getData());
                }
                else throw new IOException("Unexpected MessageType");
            }
        }

        @Override
        public void run() {
            String address = getServerAddress();
            int port = getServerPort();
            try {
                Socket socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }

        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
