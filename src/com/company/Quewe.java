package com.company;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Quewe {
    Lock lock = new ReentrantLock();
    Condition cond = lock.newCondition();
    Queue<Integer> queue = new LinkedList<>();

    public void add(int x){
        lock.lock();
        queue.add(x);
        cond.signal();
        lock.unlock();;
    }

    public int take(){
        lock.lock();
        try{
            if (queue.size() == 0)
                cond.await();
            return queue.remove();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally{
            lock.unlock();
        }
        return queue.remove();
    }
}
