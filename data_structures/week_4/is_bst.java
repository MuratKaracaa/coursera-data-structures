package data_structures.week_4;

import java.util.*;

class TreeNode {
    public int key;
    public Integer left;
    public Integer right;

    public TreeNode(int key, Integer left, Integer right){
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

public class is_bst {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numberOfNodes = scanner.nextInt();

        if(numberOfNodes == 0){
            System.out.println("CORRECT");
            System.exit(0);
        }

        TreeNode[] nodeArray = new TreeNode[numberOfNodes];
        SortedSet<String> sortedSet = new TreeSet<>(Comparator.comparing(Integer::parseInt));

        for(int i = 0;i<numberOfNodes;i++){
            int key = scanner.nextInt();
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            TreeNode node = new TreeNode(key, left != -1 ? left:null, right != -1 ? right: null);
            nodeArray[i] = node;
        }
        System.out.println(inOrderTraversal(nodeArray[0], new StringBuilder(), sortedSet, nodeArray));
    }

    static String inOrderTraversal(TreeNode root, StringBuilder stringBuilder, SortedSet<String> sortedSet,TreeNode[] nodeArray){
        TreeNode current = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        while(current != null || !nodeStack.isEmpty()){
            while(current != null){
                nodeStack.add(current);
                current = (current.left != null) ? nodeArray[current.left] : null;
            }

            current = nodeStack.pop();
            stringBuilder.append(current.key).append(" ");
            sortedSet.add(String.valueOf(current.key));
            current = (current.right != null) ? nodeArray[current.right] : null;
        }


        return stringBuilder.toString().trim().equals(String.join(" ", sortedSet)) ? "CORRECT" : "INCORRECT";
    }
}
