package HomeWork1;
import MyMethods.myMethods;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        System.out.println("\nВыберите задачу:\n" + 
        " 1 - Нахождение треугольного числа\n" + 
        " 2 - Нахождение факториала числа\n" +
        " 3 - Вывод всех простых чисел до 1000\n" + 
        " 4 - Калькулятор\n" + 
        " 5 - Нахождение неизвестных в выражении");

        int choice = myMethods.chooseOption(1, 5, "");

        switch(choice){
            case 1:
            task1.triangularNumber();
            break;
            case 2:
            task2.factorial();
            break;
            case 3:
            task3.primeNumbers();
            break;
            case 4:
            task4.calculator();
            break;
            case 5:
            task5.starTask();
            break;
        }

        
    }
}