package MyMethods;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import HomeWork6.Laptop;

public class myMethods {

    public static int chooseOption(int startOption, int endOption, String message) {
        var scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println(message);
            try {
                choice = Integer.parseInt(scanner.next());
            } catch(Exception ex) {
                continue;
            }
        } while (!(choice >= startOption && choice <= endOption));
        return choice;
    }

    public static int getNum(String message) {
        var scanner = new Scanner(System.in);
        int num = 0;
        boolean flag = false;

        while (!flag) {
            System.out.println(message);
            try {
                num = Integer.parseInt(scanner.next());
                flag = true;
            } catch(Exception ex) {
                continue;
            }         
        }
        return num;
    }

    public static void filterLaptops(Set<Laptop> laptops, Map<String, Object> criteria) {
        boolean foundMatch = false;
        StringBuilder foundResults = new StringBuilder("Ноутбуки, соответствующие фильтру:\n");
        for (Laptop laptop : laptops) {
            boolean match = true;

            if (criteria.containsKey("ramSize")) {
                int minRamSize = (int)criteria.get("ramSize");
                if (laptop.getRAMSize() < minRamSize) {
                    match = false;
                }
            }

            if (criteria.containsKey("hardDiskSize")) {
                int minHardDiskSize = (int)criteria.get("hardDiskSize");
                if (laptop.getHardDiskSize() < minHardDiskSize) {
                    match = false;
                }
            }

            if (criteria.containsKey("operatingSystem")) {
                int requiredOperatingSystem = (int)criteria.get("operatingSystem") - 1;
                if (laptop.getOperatingSystem().ordinal() != requiredOperatingSystem) {
                    match = false;
                }
            }

            if (criteria.containsKey("color")) {
                String requiredColor = (String)criteria.get("color");
                if (!laptop.getColor().equalsIgnoreCase(requiredColor)) {
                    match = false;
                }
            }

            if (match) {
                foundResults.append(laptop + "\n");
                foundMatch = true;
            }
        }
        if (!foundMatch) {
            System.out.println("Нет ноутбуков, подходящих условиям поиска");
        }
        else{
            System.out.println(foundResults.toString());
        }
    }

    public static String PrintOS()
    {
        StringBuilder sb = new StringBuilder();
        for (Laptop.OperatingSystem os : Laptop.OperatingSystem.values()) {
            sb.append((os.ordinal()+1) + ". " + os + "\n");
        }
        return sb.toString();
    }
}
