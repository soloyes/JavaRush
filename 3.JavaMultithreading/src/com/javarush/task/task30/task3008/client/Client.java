package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {

    protected Connection connection;

    private volatile boolean clientConnected = false;

    protected String getServerAddress(){
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
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
            ConsoleHelper.writeMessage("Error with sendTextMessage");
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
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else
        {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            return;
        }
        for(;clientConnected;){
            String s = ConsoleHelper.readString();
            if (s.equals("exit")) break;
            if (shouldSendTextFromConsole()){
                sendTextMessage(s);
            }
        }
    }

    public class SocketThread extends Thread{

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
