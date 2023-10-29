package org.example;

import java.util.ArrayList;
import java.util.List;

/*
    Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
    Вилки лежат на столе между каждой парой ближайших философов.
    Каждый философ может либо есть, либо размышлять.
    Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
    Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
    Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
    Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
 */

public class Main {
    public static void main(String[] args) {

        List<Fork> forkList = new ArrayList<>(5);

        List<Philosopher> philosopherList = new ArrayList<>(5);

        for (int i = 0 ; i < 5; i++) {
            forkList.add(new Fork());
        }

        philosopherList.add(new Philosopher("Immanuel Kant", forkList.get(0),forkList.get(1)));
        philosopherList.add(new Philosopher("Arthur Schopenhauer", forkList.get(1),forkList.get(2)));
        philosopherList.add(new Philosopher("Socrates", forkList.get(2),forkList.get(3)));
        philosopherList.add(new Philosopher("Friedrich Nietzsche", forkList.get(3),forkList.get(4)));
        philosopherList.add(new Philosopher("Aristotle", forkList.get(4),forkList.get(0)));

        for (int i = 0; i < 5; i++) {
            philosopherList.get(i).start();
        }

    }
}