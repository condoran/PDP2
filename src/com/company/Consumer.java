package com.company;

public class Consumer extends Thread {
    Quewe queue;
    public Consumer(Quewe queue){
        this.queue=queue;
    }
    public void run(){
        int sum=0;
        for(int i=0;i<10000;i++){
            sum+=queue.take();
        }
        System.out.println(sum);
    }
}