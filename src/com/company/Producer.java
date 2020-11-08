package com.company;

import java.util.List;

public class Producer  extends Thread {
    Quewe queue;
    List<Integer> list1,list2;
    public Producer(Quewe queue,List<Integer> list1,List<Integer> list2){
        this.list1=list1;
        this.list2=list2;
        this.queue=queue;
    }
    public void run(){
        for(int i=0;i<list1.size();i++){
            queue.add(list1.get(i) * list2.get(i));
        }
    }
}