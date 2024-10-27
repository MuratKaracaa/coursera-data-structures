package data_structures.week_3;

import java.util.Scanner;

public class hash_substring {
    static int b = 256;
    static int p = 1000000007;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String P = scanner.next();
        String T = scanner.next();

        long patternHash = hashingFunction(P);

        long highOrderMultiplier = modExp(b, P.length() - 1, p);

        String firstSubStr = T.substring(0, P.length());
        long textHash = hashingFunction(firstSubStr);

        StringBuilder positions = new StringBuilder();

        for(int i = 0; i <= T.length() - P.length(); i++){
            if(patternHash == textHash){
                if (T.substring(i, i + P.length()).equals(P)) {
                    positions.append(i).append(" ");
                }
            }

            if(i < T.length() - P.length()){
                int outgoingChar = T.charAt(i);
                int incomingChar = T.charAt(i + P.length());

                textHash = getMod(getMod(textHash - getMod(outgoingChar * highOrderMultiplier, p), p) * b + incomingChar, p);
            }
        }

        System.out.println(positions.toString().trim());
    }

    static long getMod(long n, long p){
        return ((n % p) + p) % p;
    }

    static long modExp(int base, int exp, int p) {
        long result = 1;
        long b = base % p;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * b) % p;
            }
            exp = exp >> 1;
            b = (b * b) % p;
        }

        return result;
    }

    static long hashingFunction(String text ){
        int m = text.length();

        long sum =0;

        for(int i = 0;i<m;i++){
            int charAsNumber = text.charAt(i);
            sum = getMod(sum + (charAsNumber * modExp(b, m - i - 1, p)), p);
        }

        return getMod(sum, p);
    }
}
