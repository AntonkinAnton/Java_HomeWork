package HomeWork1;
import java.util.Scanner;

public class task2 {
    public static void factorial()
    {
        System.out.println("Введите число:");
        int n = new Scanner(System.in).nextInt();
        System.out.printf("\nФакториал числа %d = ", n);
        int res = 1;

        for (; n > 0; n--) {
            res *= n;
        }
        System.out.println(res);
    }
}
