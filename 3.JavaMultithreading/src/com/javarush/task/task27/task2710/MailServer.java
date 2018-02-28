package com.javarush.task.task27.task2710;

public class MailServer implements Runnable {
    private final Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        long beforeTime = System.currentTimeMillis();
        String name = Thread.currentThread().getName();
        synchronized (mail) {
            try {
                mail.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long afterTime = System.currentTimeMillis();
            System.out.format("%s MailServer has got: [%s] in %d ms after start", name, mail.getText(), (afterTime - beforeTime));
        }
    }
}
