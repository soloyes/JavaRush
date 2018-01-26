package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public class BotSocketThread extends Client.SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Hi, im bot. Accepted commands: date, day, month, year, time, hour, minutes, seconds.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] data = message.split(": ");
            SimpleDateFormat dateFormat = null;
            if (data.length == 2) {
                String userQuestion = data[1];
                switch (userQuestion) {
                    case "date":
                        dateFormat = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "day":
                        dateFormat = new SimpleDateFormat("d");
                        break;
                    case "month":
                        dateFormat = new SimpleDateFormat("MMMM");
                        break;
                    case "year":
                        dateFormat = new SimpleDateFormat("YYYY");
                        break;
                    case "time":
                        dateFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "hour":
                        dateFormat = new SimpleDateFormat("H");
                        break;
                    case "minutes":
                        dateFormat = new SimpleDateFormat("m");
                        break;
                    case "seconds":
                        dateFormat = new SimpleDateFormat("s");
                        break;
                }
            }
            if (dateFormat != null) {
                String dateString = dateFormat.format(Calendar.getInstance().getTime());
                String botAnswer = String.format("Info to %s: %s", data[0], dateString);
                sendTextMessage(botAnswer);
            }
        }
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}
