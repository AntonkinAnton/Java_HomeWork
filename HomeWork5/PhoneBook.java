package HomeWork5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PhoneBook {
    
    Map<String, List<String>> map = new HashMap<>();

    void add(String name, String phone){
        if (map.containsKey(name))
        {
            map.get(name).add(phone);
        }
        else{
            List<String> list = new ArrayList<>();
            list.add(phone);
            map.put(name, list);
        }
    }

    public List<String> getNumByName(String name){
        if (map.containsKey(name))
        {
            return map.get(name);
        }
        else return null;
    }

    @Override
    public String toString() {
        StringBuilder strbldr = new StringBuilder();
        for (String key: map.keySet()) {
            strbldr.append(key + ": " + map.get(key) + "\n");
        }
        return strbldr.toString();
    }

    
    
}
