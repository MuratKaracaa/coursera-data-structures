package data_structures.week_3;

import java.util.LinkedList;
import java.util.Scanner;

public class hash_chain {
    static int x = 263;
    static int p = 1000000007;
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int operationCount = scanner.nextInt();

        LinkedList<String>[] map = (LinkedList<String>[]) new LinkedList[m];

        for(int i = 0;i<operationCount;i++){
            String operation = scanner.next();
            if(operation.equals("add")){
                String text = scanner.next();
                int hash = hashingFunction(text, x, p, m);
                LinkedList<String> list = map[hash];
                if(list == null){
                    list = new LinkedList<>();
                    if(!list.contains(text)){
                        list.addFirst(text);
                    }
                    map[hash] = list;
                } else {
                    if(!list.contains(text)){
                        list.addFirst(text);
                    }
                }
            } else if(operation.equals("find")){
                String text = scanner.next();
                int hash = hashingFunction(text, x, p, m);
                LinkedList<String> list = map[hash];
                if(list == null){
                    System.out.println("no");
                    list = new LinkedList<>();
                    map[hash] = list;
                } else {
                    if(list.contains(text)){
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }
                }
            } else if(operation.equals("check")){
                int hash = scanner.nextInt();
                LinkedList<String> list = map[hash];
                if(list == null){
                    System.out.println();
                    list = new LinkedList<>();
                    map[hash] = list;
                } else {
                    System.out.println(String.join(" ", list));
                }
            } else if(operation.equals("del")){
                String text = scanner.next();
                int hash = hashingFunction(text, x, p, m);
                LinkedList<String> list = map[hash];
                if(list == null){

                } else {
                    list.remove(text);
                }
            }
        }

    }

    static int hashingFunction(String text, int x, int p, int m){
        double modularSum = 0;
        long xPower = 1;

        for(int i =0;i<text.length();i++){
            int asciCode = (int) text.charAt(i);
            modularSum = (modularSum + asciCode * xPower) % p;
            xPower = (xPower * x) % p;
        }
        return (int) (modularSum % p) % m;
    }
}
