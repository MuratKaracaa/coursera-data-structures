import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class phone_book {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> phoneBook = new HashMap<>();

        int operationCount = scanner.nextInt();
        for(int i = 0;i<operationCount;i++){
            String operation = scanner.next();
            if(operation.equals("add")){
                int number = scanner.nextInt();
                String name = scanner.next();
                phoneBook.put(number, name);
            } else if(operation.equals("find")){
                int searchedNumber = scanner.nextInt();
                Optional<String> name = Optional.ofNullable(phoneBook.get(searchedNumber));
                if(name.isEmpty()){
                    System.out.println("not found");
                } else {
                    System.out.println(name.get());
                }
            } else if(operation.equals("del")){
                int deletedNumber = scanner.nextInt();
                phoneBook.remove(deletedNumber);
            }
        }
    }
}
