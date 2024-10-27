package data_structures.week_4;

import java.util.Scanner;
import java.util.Stack;

class Node {
    public int key;
    public Integer left;
    public Integer right;

    public Node(int key, Integer left, Integer right){
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

public class tree_orders {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numberOfNodes = scanner.nextInt();

        Node[] nodeArray = new Node[numberOfNodes];

        for(int i = 0;i<numberOfNodes;i++){
            int key = scanner.nextInt();
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            Node node = new Node(key, left != -1 ? left:null, right != -1 ? right: null);
            nodeArray[i] = node;
        }

        System.out.println(inOrderTraversal(nodeArray[0], new StringBuilder(), nodeArray));
        System.out.println(preOrderTraversal(nodeArray[0], new StringBuilder(), nodeArray));
        System.out.println(postOrderTraversal(nodeArray[0], new StringBuilder(), nodeArray));
    }

    static String inOrderTraversal(Node root, StringBuilder stringBuilder, Node[] nodeArray){
        Node current = root;
        Stack<Node> nodeStack = new Stack<>();
        while(current != null || !nodeStack.isEmpty()){
            while(current != null){
                nodeStack.add(current);
                current = (current.left != null) ? nodeArray[current.left] : null;
            }

            current = nodeStack.pop();
            stringBuilder.append(current.key).append(" ");
            current = (current.right != null) ? nodeArray[current.right] : null;
        }


        return stringBuilder.toString().trim();
    }

    static String preOrderTraversal(Node root, StringBuilder stringBuilder, Node[] nodeArray){
        Node current = root;
        Stack<Node> nodeStack = new Stack<>();
        while(current != null || !nodeStack.isEmpty()){
            while(current != null){
                nodeStack.add(current);
                stringBuilder.append(current.key).append(" ");
                current = (current.left != null) ? nodeArray[current.left] : null;
            }
            current = nodeStack.pop();
            current = (current.right != null) ? nodeArray[current.right] : null;
        }

        return stringBuilder.toString().trim();
    }

    static String postOrderTraversal(Node root, StringBuilder stringBuilder, Node[] nodeArray){
        Node current = root;
        Stack<Node> nodeStack = new Stack<>();
        while (current != null || !nodeStack.isEmpty()){
            while(current != null){
                if(current.right != null){
                    nodeStack.add(nodeArray[current.right]);
                }
                nodeStack.add(current);
                current = (current.left != null) ? nodeArray[current.left] : null;
            }
            current = nodeStack.pop();
            if(current.right != null && !nodeStack.isEmpty() &&nodeArray[current.right] == nodeStack.peek()){
                nodeStack.pop();
                nodeStack.add(current);
                current = nodeArray[current.right];
            } else {
                stringBuilder.append(current.key).append(" ");
                current = null;
            }
        }

        return stringBuilder.toString().trim();
    }
}
