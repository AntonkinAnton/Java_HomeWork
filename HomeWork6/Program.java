package HomeWork6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import HomeWork6.Laptop.OperatingSystem;
import MyMethods.myMethods;

public class Program {
    public static void main(String[] args) {

        Set<Laptop> notebooks = new HashSet<>();
        notebooks.add(new Laptop("Asus", 52000, OperatingSystem.Windows11, 512, 16, "Grey"));
        notebooks.add(new Laptop("Acer", 45000, OperatingSystem.Windows11, 256, 8, "Black"));
        notebooks.add(new Laptop("Huawei", 43000, OperatingSystem.Windows11, 256, 8, "Grey"));
        notebooks.add(new Laptop("HP", 30000, OperatingSystem.Linux, 256, 8, "Grey"));
        notebooks.add(new Laptop("Dell", 35000, OperatingSystem.Windows10, 256, 8, "Black"));
        notebooks.add(new Laptop("MSI", 60000, OperatingSystem.Windows11, 512, 16, "Black"));
        notebooks.add(new Laptop("Apple", 80000, OperatingSystem.MacOS, 512, 16, "White"));
        notebooks.add(new Laptop("Samsung", 25000, OperatingSystem.Windows10, 128, 4, "Black"));
        notebooks.add(new Laptop("Honor", 43000, OperatingSystem.Windows11, 256, 8, "Grey"));
        notebooks.add(new Laptop("Xiaomi", 40000, OperatingSystem.Windows10, 256, 8, "Grey"));
        notebooks.add(new Laptop("Lenovo", 45000, OperatingSystem.Linux, 256, 8, "Grey"));
        notebooks.add(new Laptop("LG", 25000, OperatingSystem.Windows10, 128, 4, "Red"));
        notebooks.add(new Laptop("Toshiba", 40000, OperatingSystem.Windows10, 256, 8, "Grey"));
        notebooks.add(new Laptop("Sony", 40000, OperatingSystem.Windows11, 512, 8, "Grey"));
        notebooks.add(new Laptop("Microsoft", 41000, OperatingSystem.Windows11, 256, 8, "Grey"));

        Scanner scanner = new Scanner(System.in);

        Map<String, Object> criteria = new HashMap<>();
        boolean continueFiltering = true;

        while (continueFiltering) {
            System.out.println("\nВыберите критерий фильтрации:\n");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем жесткого диска");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("5 - Завершить выбор критериев");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    int ramSize = myMethods.getNum("\nВведите минимальный объем ОЗУ:");
                    criteria.put("ramSize", ramSize);
                    break;
                case "2":
                    int hardDiskSize = myMethods.getNum("\nВведите минимальный объем жесткого диска:");
                    criteria.put("hardDiskSize", hardDiskSize);
                    break;
                case "3":
                    String message = "\nВведите номер операционной системы из списка:\n" +  myMethods.PrintOS();
                    int operatingSystem = myMethods.chooseOption(0, OperatingSystem.values().length, message);
                    criteria.put("operatingSystem", operatingSystem);
                    break;
                case "4":
                    System.out.println("Введите цвет:");
                    String color = scanner.nextLine();
                    criteria.put("color", color);
                    break;
                case "5":
                    continueFiltering = false;
                    System.out.println();
                    continue;
                default:
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
                    continue;
            }
            System.out.println("\nФильтр добавлен!");
        }

        myMethods.filterLaptops(notebooks, criteria);
    }

}