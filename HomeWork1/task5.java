package HomeWork1;

import java.util.Arrays;
import java.util.Scanner;

/*Задача выполнена для возможности нахождения как можно большего количества неизвестных в числах с более двумя знаками.
    Тем не менее, в ней все еще много багов с разными вариациями неизвестных (чем меньше неизвестных, тем надежней). 
    Код написан просто ужасно и дико неоптимально с огромным кол-м try/catch, но упора на читабельность кода (и вообще, что его 
    кто-то будет читать  ヽ(ー_ー )ノ) не было. При всех огромных недостатках, остается надеятся, что она работает быстре, чем
    оная на циклах, для перебора всхе значений (особенно, если будет более двух знаков)...
  */

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
        var sumArrayCopy = Arrays.copyOf(sumArray, sumArray.length);
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
                try{
                if (sameSymbol && i == sumArray.length-1 && (sumArrayCopy[i-1]
                .equals(String.valueOf(Integer.parseInt(firstNumArray[j-1]) + Integer.parseInt(secondNumArray[j-1]))))){
                // sumArray[i] = String.valueOf((Integer.parseInt(sumArray[i]) + 10) / 2);
                firstNumArray[j] = String.valueOf((int)Math.ceil((Double.parseDouble(sumArray[i]) ) / 2));
                secondNumArray[j] = String.valueOf((Integer.parseInt(sumArray[i]) ) / 2);
                }
                else if (sameSymbol && i == sumArray.length-1 && (!sumArrayCopy[i-1]
                .equals(String.valueOf(Integer.parseInt(firstNumArray[j-1]) + Integer.parseInt(secondNumArray[j-1]))))){
                // sumArray[i] = String.valueOf((Integer.parseInt(sumArray[i]) + 10) / 2);
                firstNumArray[j] = String.valueOf((int)Math.ceil((Double.parseDouble(sumArray[i]) + 10) / 2));
                secondNumArray[j] = String.valueOf((Integer.parseInt(sumArray[i]) + 10) / 2);
                }}catch(Exception ec){firstNumArray[j] = String.valueOf(0);}
                
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

        // System.out.println(Arrays.toString(sumArray));

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
                if (next) {
                    try {
                        secondNumArray[j] = sumArray[i + 1];
                    } catch (Exception exeption) {
                        secondNumArray[j] = sumArray[i - 1];
                    }
                } else
                    secondNumArray[j] = sumArray[i];
            }
        }
        int firstResult = Integer.parseInt((String.join("", firstNumArray)));
        int secondResult = Integer.parseInt((String.join("", secondNumArray)));

        if ((firstResult + secondResult) != (Integer.parseInt(sum))) { 
        System.out.println("Решение не найдено");
        return;
        }

        System.out.println("\n"+ "Возможное решение:\n" + firstResult + " + " + secondResult + " = " + sum);
        System.out.println("\n До встречи!");
    }
}
