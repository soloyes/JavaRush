package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BlockingQueue<E> {
    private List<E> queue;

    private int limit = 10;

    public BlockingQueue(int limit){
        this.limit = limit;
        queue = new LinkedList<>();
    }

    public synchronized void put(E item) throws InterruptedException{
        System.out.println("[BlockingQueue] try to put: " + item);
        while (this.queue.size() == this.limit){
            System.out.println("[BlockingQueue] is full, waiting until space is free");
            wait();
        }

        if (this.queue.size() == 0){
            System.out.println("[BlockingQueue] is empty, notify");
            notifyAll();
        }

        this.queue.add(item);
        System.out.println("[BlockingQueue] put ok: " + item);
    }

    public synchronized E take() throws InterruptedException{
        System.out.println("[BlockingQueue] try to take");
        while (this.queue.size() == 0){
            System.out.println("[BlockingQueue] is empty, waiting until put");
            wait();
        }

        if (this.queue.size() == this.limit){
            System.out.println("[BlockingQueue] is full, notify");
            notifyAll();
        }

        E item = this.queue.remove(0);
        System.out.println("[BlockingQueue] take ok: " + item);

        return item;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new BlockingQueue<>(5);
        new Thread(new Producer(queue)).start();
        Thread.sleep(1000);
        new Thread(new Consumer(queue)).start();
    }

    static class Producer implements Runnable {
        private final BlockingQueue<Integer> queue;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println("[Producer] run");
            while (true) {
                try {
                    queue.put(produce());
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private Integer produce() {
            Integer i = new Random().nextInt(100);
            System.out.println("[Producer] produce: " + i);
            return i;
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println("[Consumer] run");
            while (true) {
                try {
                    consume();
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void consume() throws InterruptedException {
            Integer i = queue.take();
            System.out.println("[Consumer] consumed: " + i);
        }
    }
}
