import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("How many IDs?");
        Scanner s = new Scanner(System.in);
        int numUsers = s.nextInt();
        for (int i = 0; i < numUsers; i++) {
            new email();
        }
    }
}