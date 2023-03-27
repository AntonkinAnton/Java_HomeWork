package HomeWork1;

import java.util.Arrays;
import java.util.Scanner;

public class task5 {
    public static void starTask() {

        var scanner = new Scanner(System.in);
        System.out.println("Введите числа, заменив некоторые цифры на любые символы\n" +
        "Пример: d7 + f5f = 487 \nВывод: 37 + 450 = 487\n");
        System.out.println("Введите первое число:");
        String firstNum = scanner.nextLine();
        System.out.println("Введите второе число:");
        String secondNum = scanner.nextLine();
        System.out.println("Введите сумму этих чисел:");
        String sum = scanner.nextLine();
        System.out.printf("Ваше выражение: %s + %s = %s\n", firstNum, secondNum, sum);

        while (firstNum.length() > secondNum.length())
            secondNum = "0" + secondNum;
        while (firstNum.length() < secondNum.length())
            firstNum = "0" + firstNum;

        var firstNumArray = firstNum.split("");
        var secondNumArray = secondNum.split("");
        var sumArray = sum.split("");
        boolean noSolves = false;
        boolean sameSymbol = false;

        for (int i = 0, j = 0; i < sumArray.length; i++, j++) {

            if (i == 0 && (sumArray.length > firstNumArray.length || sumArray.length > secondNumArray.length)) {
                j--;
                continue;
            }
            sameSymbol = false;
            try {
                if (Integer.parseInt(sumArray[i]) < Integer.parseInt(firstNumArray[j])) {
                    sumArray[i] = String.valueOf(Integer.parseInt(sumArray[i]) + 10);
                    sumArray[i - 1] = String.valueOf(Integer.parseInt(sumArray[i - 1]) - 1);
                }
            } catch (Exception ex) {
            }

            try {
                if (Integer.parseInt(sumArray[i]) < Integer.parseInt(secondNumArray[j])) {
                    sumArray[i] = String.valueOf(Integer.parseInt(sumArray[i]) + 10);
                    sumArray[i - 1] = String.valueOf(Integer.parseInt(sumArray[i - 1]) - 1);
                }
            } catch (Exception ex) {
            }

            try {
                sumArray[i] = String.valueOf(Integer.parseInt(sumArray[i]) - Integer.parseInt(firstNumArray[j]));
            } catch (Exception e) {
                sameSymbol = true;
            }
            try {
                sumArray[i] = String.valueOf(Integer.parseInt(sumArray[i]) - Integer.parseInt(secondNumArray[j]));
            } catch (Exception e) {
                if (sameSymbol && i == sumArray.length-1)
                sumArray[i] = String.valueOf((Integer.parseInt(sumArray[i]) + 10) / 2);
            }
            try {
                if (Integer.parseInt(sumArray[i]) < 0) {
                    sumArray[i - 1] = String.valueOf(Integer.parseInt(sumArray[i - 1]) - 1);
                    sumArray[i] = String.valueOf(Integer.parseInt(sumArray[i]) * (-1));
                }
            } catch (Exception ex) {
                noSolves = true;
                break;
            }
            if (Integer.parseInt(sumArray[i]) >= 10)
                sumArray[i] = String.valueOf(Integer.parseInt(sumArray[i]) - 10);
        }
        System.out.println(Arrays.toString(sumArray));
        if (Integer.parseInt(sumArray[0]) < 0)
            noSolves = true;

        else if (sumArray.length < firstNumArray.length || sumArray.length < secondNumArray.length)
            noSolves = true;

        else if ((sumArray.length - firstNumArray.length) >= 2 || (sumArray.length - secondNumArray.length) >= 2)
            noSolves = true;

        if (noSolves) {
            System.out.println("Нет решений");
            return;
        }
        boolean next = false;

        for (int i = 0, j = 0; i < sumArray.length; i++, j++) {
            next = false;

            if ((i == 0 && (sumArray.length > firstNumArray.length || sumArray.length > secondNumArray.length)) && 
                ((!firstNumArray[i].equals("0")) || (!secondNumArray[i].equals("0")))) {
                j--;
                continue;
            }
            try {
                Integer.parseInt(firstNumArray[j]);
            } catch (Exception ex) {
                firstNumArray[j] = sumArray[i];
                next = true;
            }
            try {
                Integer.parseInt(secondNumArray[j]);
            } catch (Exception ex) {
                // if (next) {
                //     try {
                //         secondNumArray[j] = sumArray[i + 1];
                //     } catch (Exception exeption) {
                //         secondNumArray[j] = sumArray[i - 1];
                //     }
                // } else
                    secondNumArray[j] = sumArray[i];
            }
        }
        int firstResult = Integer.parseInt((String.join("", firstNumArray)));
        int secondResult = Integer.parseInt((String.join("", secondNumArray)));

        // if ((firstResult + secondResult) != (Integer.parseInt(sum))) {
        // System.out.println("Нет решений!");
        // return;
        // }

        System.out.println("\n"+ "Возможное решение:\n" + firstResult + " + " + secondResult + " = " + sum);
    }
}
