import java.util.*;
import java.util.stream.Collectors;

class TreeNodeAdvanced {
    public int index;
    public int key;
    public Integer left;
    public Integer right;

    public TreeNodeAdvanced(int key, Integer left, Integer right, int index){
        this.key = key;
        this.left = left;
        this.right = right;
        this.index = index;
    }
}

public class is_bst_hard {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numberOfNodes = scanner.nextInt();

        if(numberOfNodes == 0){
            System.out.println("CORRECT");
            System.exit(0);
        }

        TreeNodeAdvanced[] nodeArray = new TreeNodeAdvanced[numberOfNodes];
        SortedSet<int[]> sortedSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int cmp = Integer.compare(o1[1], o2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int i = 0;i<numberOfNodes;i++){
            int key = scanner.nextInt();
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            TreeNodeAdvanced node = new TreeNodeAdvanced(key, left != -1 ? left:null, right != -1 ? right: null, i);
            nodeArray[i] = node;
        }
        System.out.println(inOrderTraversal(nodeArray[0], new StringBuilder(), sortedSet, nodeArray));
    }

    static String inOrderTraversal(TreeNodeAdvanced root, StringBuilder stringBuilder, SortedSet<int[]> sortedSet,TreeNodeAdvanced[] nodeArray){
        TreeNodeAdvanced current = root;
        Stack<TreeNodeAdvanced> nodeStack = new Stack<>();
        while(current != null || !nodeStack.isEmpty()){
            while(current != null){
                if(current.left != null && !(nodeArray[current.left].key < current.key)){
                    return "INCORRECT";
                }
                nodeStack.add(current);
                current = (current.left != null) ? nodeArray[current.left] : null;
            }

            current = nodeStack.pop();
            stringBuilder.append(current.key).append(" ");
            sortedSet.add(new int[]{current.index, current.key});
            current = (current.right != null) ? nodeArray[current.right] : null;
        }

        String sortedString = sortedSet.stream().map(item -> String.valueOf(item[1])).collect(Collectors.joining(" "));

        return stringBuilder.toString().trim().equals(sortedString) ? "CORRECT" : "INCORRECT";
    }
}
