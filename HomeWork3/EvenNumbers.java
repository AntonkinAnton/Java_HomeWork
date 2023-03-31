package HomeWork3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class EvenNumbers {

    public static void main(String[] args) {

        List<Integer> listNumbers = new ArrayList<>();
        ListRandomizer(listNumbers, 5);

        System.out.println("\nВаш массив: " + listNumbers + "\n");

        System.out.println("Максимальное значение: " + Collections.max(listNumbers) + 
        "\nМинимальное значение: " + Collections.min(listNumbers) + "\nСреднее арифметическое: " + avarageList(listNumbers));

        for (int i = 0; i < listNumbers.size(); i++) {

            if (listNumbers.get(i) % 2 == 0)
            {
               listNumbers.remove(listNumbers.get(i));
               i--; 
            }
        }

        System.out.println("\nВаш массив без четных чисел: " + listNumbers + "\n");

    }
    private static String avarageList(List<Integer> list)
    {
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
        }
        return String.valueOf((double)result/list.size());
    }

    private static void ListRandomizer (List<Integer> list, int resultLength)
    {
        Random rnd = new Random();

        for (int i = 0; i < resultLength; i++) {
            list.add(rnd.nextInt(15));
        }
    }
}