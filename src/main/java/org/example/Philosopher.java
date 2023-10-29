package org.example;

import java.util.Random;

public class Philosopher extends Thread {
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private Random random;
    private long thinkingTime;
    private int mealTimes;
    private final int COUNTS = 3;

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.mealTimes = 0;
        this.random = new Random();
        this.thinkingTime = random.nextInt(1, 8) * 1000L;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while (mealTimes < COUNTS) {
            if (leftFork.isOnTable()) {
                leftFork.takeFork();
                if (rightFork.isOnTable()) {
                    rightFork.takeFork();
                    haveAMeal();
                    leftFork.putForkDown();
                    rightFork.putForkDown();
                } else {
                    leftFork.putForkDown();
                }
            }
            if (mealTimes < COUNTS) {
                try {
                    think();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void think() throws InterruptedException {
        System.out.println(name + " : time to think. I will do it " + thinkingTime + " sec.");
        sleep(thinkingTime);
    }

    public void haveAMeal() {
        mealTimes++;
        System.out.println(name + " : time to eat. It is my " + mealTimes + " meal.");
    }

}
