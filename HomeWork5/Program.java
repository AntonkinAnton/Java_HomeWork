package HomeWork5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.add("Виктор", "+795461346");
        book.add("Виктор", "+7987444113");
        book.add("Сергей", "+7413154684");
        book.add("Наталья", "86464889444");
        book.add("Андрей Викторович", "+7451535555");
        book.add("Виктор", "+788844445555");
        book.add("Сергей", "+7711111335");
        book.add("Анастасия", "+72223445547");

        System.out.println(book.getNumByName("Сергей"));
        System.out.println();

        System.out.println(book.toString());
        System.out.println("------next task-------\n");

        String names = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, "+
        "Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, "+
        "Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, "+
        "Иван Мечников, Петр Петин, Иван Ежов, Виктор Стрельников";

        String[] arrNames = names.split(", ");
        
        Map<Integer, List<String>> map = new TreeMap<>(Comparator.reverseOrder());
        
        for (int i = 0; i < arrNames.length; i++) {
            String name = arrNames[i].split("\s")[0];
            
            if (!mapContains(map, name))
            {
                int count = 1;
                for (int j = i + 1; j < arrNames.length; j++) {
                    if (name.equals(arrNames[j].split("\s")[0]))
                        count++;
                }
                if (map.containsKey(count))
                {
                    map.get(count).add(name);
                }
                else {
                    List<String> list = new ArrayList<>();
                    list.add(name);
                    map.put(count, list);
                }
            }
        }

        for (Integer key : map.keySet()) {
            System.out.println(key + ": " + String.join(", ", map.get(key))+"\n");
        }

    }

    private static boolean mapContains(Map <Integer, List<String>> map, String name)
    {
            for (List<String> list : map.values()) {
                if (list.contains(name)) 
                    return true;
            }
            return false;
    }

}
