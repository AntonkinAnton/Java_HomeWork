package HomeWork1;

import java.util.Scanner;

public class myMethods {

    public static int chooseOption(int startOption, int endOption, String message) {
        var scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println(message);
            try {
                choice = Integer.parseInt(scanner.next());
            } catch(Exception ex) {
                continue;
            }
        } while (!(choice >= startOption && choice <= endOption));
        return choice;
    }

    public static int getNum(String message) {
        var scanner = new Scanner(System.in);
        int num = 0;
        boolean flag = false;

        while (!flag) {
            System.out.println(message);
            try {
                num = Integer.parseInt(scanner.next());
                flag = true;
            } catch(Exception ex) {
                continue;
            }         
        }
        return num;
    }
}
