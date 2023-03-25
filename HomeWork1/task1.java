package HomeWork1;
import java.util.Scanner;

public class task1 {

    public static void triangularNumber() {
        System.out.println("Введите число:");
        int n = new Scanner(System.in).nextInt();

        System.out.printf("\nТреугольное число %d = ", n);
        System.out.println(n * (n + 1) / 2 + "\n");
        System.out.printf("Нарисовать треугольник с основанием %d?:\n 1 - Да\n", n);

        

        if (new Scanner(System.in).next().equals("1")) {
            for (int i = 1; i <= n; i++) {
                System.out.print(new String(new char[n - i]).replace('\0', ' '));
                System.out.print(new String(new char[i]).replace("\0", "* "));
                System.out.println();
            } 
        }
        System.out.println("\nДо скорой встречи!");
    }
}
