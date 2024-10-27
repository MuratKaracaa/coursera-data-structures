package data_structures.week_2;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Thread {
    private long index;
    private long freeWhen;

    public Thread(long index){
        this.index = index;
    }

    public long getIndex(){
        return this.index;
    }


    public long getFreeWhen(){
        return this.freeWhen;
    }

    public void setIndex(long index){
        this.index = index;
    }

    public void setFreeWhen(long freeWhen){
        this.freeWhen = freeWhen;
    }

}

public class parallel_processing {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        long threadCount = scanner.nextLong();
        long jobCount = scanner.nextLong();

        PriorityQueue<Thread> threadPriorityQueue = new PriorityQueue<>(new Comparator<Thread>() {
            @Override
            public int compare(Thread o1, Thread o2) {
                if (o1.getFreeWhen() != o2.getFreeWhen()) {
                    return Long.compare(o1.getFreeWhen(), o2.getFreeWhen());
                } else {
                    return Long.compare(o1.getIndex(), o2.getIndex());
                }
            }
        });


        for(long i = 0; i<threadCount;i++){
            Thread thread = new Thread(i);
            threadPriorityQueue.add(thread);
        }

        for(long i = 0; i<jobCount;i++){
            long jobDuration = scanner.nextLong();
            Thread nextThread = threadPriorityQueue.poll();
            System.out.println(nextThread.getIndex() + " " + nextThread.getFreeWhen());
            nextThread.setFreeWhen(nextThread.getFreeWhen() + jobDuration);
            threadPriorityQueue.add(nextThread);
        }
    }
}
