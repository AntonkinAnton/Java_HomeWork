package HomeWork1;

public class task3 {
    public static void primeNumbers()
    {
        System.out.println("Все простые числа от 1 до 1000:");
        boolean flag;
        for (int i = 1; i <= 1000; i++) {
            flag = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0)
                {
                    flag = false;
                    break;
                }
            }
            if (flag == true) System.out.printf("%-4d", i);
        }
    }
}
