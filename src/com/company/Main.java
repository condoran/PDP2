package com.company;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private final static Integer VECTOR_SIZE = 10000;

    public static void main(String[] args) {
        List<Integer> list1=createRandomVector(VECTOR_SIZE);
        List<Integer> list2=createRandomVector(VECTOR_SIZE);
        Quewe queue= new Quewe();
        Thread producer= new Producer(queue,list1,list2);
        Thread consumer= new Consumer(queue);
        Long start =  System.currentTimeMillis();

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        verification(list1,list2);

        Long end = System.currentTimeMillis();
        System.out.println("Time for verification: " + (end - start) + "ms");
    }
    private static void verification(List<Integer> list1,List<Integer> list2){
        int sum=0;
        for(int i=0;i<list1.size();i++){
            sum+=(list1.get(i) * list2.get(i));
        }
        System.out.println("Verification returned: "+sum);
    }
    private static List<Integer> createRandomVector(int size){
        List<Integer> list1=new ArrayList();
        Random r=new Random();
        for(int i=0;i<size;i++){
            list1.add(r.nextInt());
        }
        return list1;
    }
}