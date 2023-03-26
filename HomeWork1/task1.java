package HomeWork1;

public class task1 {

    public static void triangularNumber() {

        int n = myMethods.getNum("Введите число:");

        System.out.printf("\nТреугольное число %d = %d\n", n, n * (n + 1) / 2);
        int choice = myMethods.chooseOption(1, 2, String.format("\nНарисовать треугольник с основанием %d?:" + 
        "\n 1 - Да\n 2 - Нет (Выход)", n));

        

        if (choice == 1) {
            for (int i = 1; i <= n; i++) {
                System.out.print(new String(new char[n - i]).replace('\0', ' '));
                System.out.print(new String(new char[i]).replace("\0", "* "));
                System.out.println();
            }
        }
        System.out.println("\nДо скорой встречи!");
    }
}
