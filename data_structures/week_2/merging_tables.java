package data_structures.week_2;

import java.util.Scanner;

public class merging_tables {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int tableCount = scanner.nextInt();
        int queryCount = scanner.nextInt();

        int[] rowCounts = new int[tableCount+1];
        int[] parents = new int[tableCount+1];

        int maxRowCount = Integer.MIN_VALUE;

        for(int i = 1;i<=tableCount;i++){
            int rowCount = scanner.nextInt();
            maxRowCount = Integer.max(maxRowCount, rowCount);
            rowCounts[i] = rowCount;
            parents[i] = i;
        }

        for(int i = 0; i<queryCount;i++){
            int newParent = scanner.nextInt();
            int merged = scanner.nextInt();

            newParent = find(parents, newParent);
            merged = find(parents, merged);

            if(newParent == merged){
                System.out.println(maxRowCount);
                continue;
            }

            parents[merged] = newParent;
            rowCounts[newParent] += rowCounts[merged];
            maxRowCount = Integer.max(rowCounts[newParent], maxRowCount);
            System.out.println(maxRowCount);
        }
    }

    static int find(int[] parents, int n){
        int root = n;
        while (root != parents[root]) {
            root = parents[root];
        }

        while (n != root) {
            int next = parents[n];
            parents[n] = root;
            n = next;
        }

        return parents[n];
    }
}
