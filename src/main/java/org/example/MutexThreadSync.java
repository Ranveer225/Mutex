package org.example;
class MutexData {
    int data;

    synchronized void write() {
        data = 42;
        System.out.println("Write " + data);
    }

    synchronized void read() {
        System.out.println("Read " + data);
    }
}

public class MutexThreadSync {
    public static void main(String[] args) throws InterruptedException {
        MutexData shared = new MutexData();

        Thread writer = new Thread(shared::write);

        Thread reader = new Thread(shared::read);

        writer.start();
        writer.join();

        reader.start();
        reader.join();
    }
}


