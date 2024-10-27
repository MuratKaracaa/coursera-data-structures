import java.util.Scanner;

public class substr {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        int queryCount = scanner.nextInt();

        for(int i = 0;i<queryCount;i++){
            int firstIndex = scanner.nextInt();
            int secondIndex = scanner.nextInt();
            int sliceLength = scanner.nextInt();
            if(text.substring(firstIndex, firstIndex + sliceLength).equals(text.substring(secondIndex, secondIndex + sliceLength))){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
