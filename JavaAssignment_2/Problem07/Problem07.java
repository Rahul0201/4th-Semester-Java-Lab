/*
Implement a multithreaded program in Java to solve the producer-consumer problem. Producer and Consumer are the 
two entities here who share the same buffer.The producer can either go to sleep or discard data if the buffer is full. 
The next time the consumer removes an item from the buffer, it notifies the producer, who starts to fill the buffer again. 
In the same way, the consumer can go to sleep if it finds the buffer to be empty. The next time the producer puts data 
into the buffer, it wakes up the sleeping consumer.
An inadequate solution could result in a deadlock where both processes are waiting to be awakened.
*/


import java.util.LinkedList;


class Buffer{
    private LinkedList<Integer> list ;
    private static final int size = 15;

    Buffer(){list = new LinkedList<>();}
    private boolean isFull(){return list.size() == size;}
    private boolean isEmpty(){return list.size() == 0;}
    synchronized void get(){
        while(isEmpty())
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("InterruptedException caught");
            }

        int value = list.removeFirst();
        System.out.println("Consumed : "+value+"\tList : "+list);
        notify();       //Wakes up sleeping producer
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println("InterruptedException caught");
        }
        

    }
    synchronized void put(int num){
        while(isFull())
            try{
                wait();
            }catch(InterruptedException e){
                System.out.println("InterruptedException caught");
            }
        list.add(num);
        System.out.println("Produced : "+num+"\tList : "+list);
        notify();       //Wakes up sleeping consumer
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println("InterruptedException caught");
        }
    }
}

class Producer implements Runnable{
    Buffer buff;
    Thread t;
    Producer(Buffer b){
        buff = b;
        t = new Thread(this, "Producer" );
    }
    public void run(){
        int i=0;
        while(true){
            buff.put(++i);
        }
    }
}
class Consumer implements Runnable{
    Buffer buff;
    Thread t;
    Consumer(Buffer b){
        buff = b;
        t = new Thread(this, "Consumer" );
    }
    public void run(){
        while(true){
            buff.get();
        }
    }
}

public class Problem07 {
    public static void main(String args[]){
        Buffer B = new Buffer();
        Producer P = new Producer(B);
        Consumer C = new Consumer(B);

        P.t.start();
        C.t.start();
    }
}
