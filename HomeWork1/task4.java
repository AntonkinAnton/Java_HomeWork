package HomeWork1;

import java.util.Scanner;

public class task4 {
    public static void calculator() {

        var scanner = new Scanner(System.in);
        var expression = new String[3];
        boolean done = false;
        String input;
        int a = 0;
        int b = 0;

        while (!done) {

            System.out.println("\nВведите выражение вида a + b (либо Enter для справки):");
            input = scanner.nextLine();

            if (input.equals(""))
                printHelp();
            else {
                expression = input.split("\\s+");

                try {
                    a = Integer.parseInt(expression[0]);
                    b = Integer.parseInt(expression[2]);
                    done = true;
                } catch (Exception e) {
                    System.out.println("Вы ввели хрень, товарисчь!");
                }
            }
        }
        input = expression[1];
        done = false;
        while (!done) {

            switch (input) {

                case "+":
                    System.out.printf("\n%d + %d = %d", a, b, a + b);
                    done = true;
                    break;

                case "-":
                    System.out.printf("\n%d - %d = %d", a, b, a - b);
                    done = true;
                    break;

                case "*":
                    System.out.printf("\n%d * %d = %d", a, b, a * b);
                    done = true;
                    break;

                case ":":
                case "/":
                    System.out.printf("\n%d / %d = %.2f", a, b, (double) a / (double) b);
                    done = true;
                    break;

                case "**":
                    System.out.printf("\n%d^%d = %d", a, b, (int) Math.pow(a, b));
                    done = true;
                    break;

                case "//":
                    System.out.printf("\n%d\u221A%d = %d", b, a, Math.round(Math.pow((double) a, 1.0 / (double) b)));
                    done = true;
                    break;

                case "%":
                    System.out.printf("\n%d / %d = %d ост.%d", a, b, a / b, a % b);
                    done = true;
                    break;

                default:
                    System.out.printf("\nОператор %s не найден!\n", input);
                    System.out.println("\nВведите оператор:");
                    input = scanner.next();

            }
        }
        System.out.println("\n\nBye!");
        scanner.close();

    }

    private static void printHelp() {

        System.out.println("Программа принимает только простые математические выражения с одним действием.\n" +
                "Выражение должно иметь вид: (целое число)(пробел)(оператор)(пробел)(целое число)\n" +
                "Пример: 25 * 20\n");
        System.out.println("Операторы:\n + - сложение a и b\n - - вычитание b из a\n * - умножение a и b\n" +
                " / или : - деление a на b (точность 2 знака)\n ** - возведение a в степень b\n // - корень b степени из a\n"
                +
                " % - целочисленное деление a на b с выводом остатка");
    }
}
