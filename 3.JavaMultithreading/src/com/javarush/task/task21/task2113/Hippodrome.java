package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome {
    static Hippodrome game;

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>(Arrays.asList(
                new Horse("One", 3, 0),
                new Horse("Two", 3, 0),
                new Horse("Three", 3, 0)
        )));
        game.run();
        game.printWinner();
    }

    public Horse getWinner(){
        Collections.sort(horses, new Comparator<Horse>() {
            @Override
            public int compare(Horse horse, Horse t1) {
                double res = t1.getDistance() - horse.getDistance();
                return  res == 0 ? 0 : res > 0 ? 1 : -1;
            }
        });
        return horses.get(0);
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public void run(){
        for (int i = 0; i < 80; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void print(){
        for (Horse h:this.horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void move(){
        for (Horse h: this.horses) {
            h.move();
        }
    }
}
