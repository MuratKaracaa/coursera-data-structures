package data_structures.week_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class make_heap {
    static List<String> swaps = new ArrayList<>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int maxSize = scanner.nextInt();
        int size = 0;

        int[] heap = new int[maxSize];

        for(int i = 0;i<maxSize;i++){
            int number = scanner.nextInt();
            heap[i] = number;
            size++;
        }

        makeHeap(heap, maxSize);

        System.out.println(swaps.size());
        for(String swap: swaps){
            System.out.println(swap);
        }
    }

    static void siftUp(int[] heap, int i){
        while(i>0 && heap[getParent(i)] < heap[i]){
            swap(heap, getParent(i), i);
            i = getParent(i);
        }
    }

    static void siftDown(int[] heap, int i, int size){
        int currentIndex = i;
        int left = getLeftChild(i);
        if(left < size && heap[left] < heap[currentIndex]){
            currentIndex = left;
        }
        int right = getRightChild(i);
        if(right < size && heap[right] < heap[currentIndex]){
            currentIndex = right;
        }

        if(i != currentIndex){
            String swapped = i + " " + currentIndex;
            swaps.add(swapped);
            swap(heap, i, currentIndex);
            siftDown(heap, currentIndex, size);
        }

    }

    static void swap(int[] heap, int n1, int n2){
        int tempFirst = heap[n1];
        heap[n1] = heap[n2];
        heap[n2] = tempFirst;
    }

    static int getParent(int i){
        return (int)Math.floor((i-1) / 2);
    }


    static int getLeftChild(int i){
        return 2*i + 1;
    }

    static int getRightChild(int i){
        return 2*i + 2;
    }

    static int extractMax(int[] heap, int size){
        int result = heap[0];
        heap[0] = heap[size-1];
        size--;
        siftDown(heap,0, size);
        return result;
    }

    static void makeHeap(int[] arr, int size){
        int limit =(int) Math.floor(size / 2) - 1;
        for(int i = limit; i>= 0; i--){
            siftDown(arr,i, size);
        }
    }
}
