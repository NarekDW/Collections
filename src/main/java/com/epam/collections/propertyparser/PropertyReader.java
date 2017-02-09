package com.epam.collections.propertyparser;
import java.io.*;
import java.util.HashMap;

/**
 * Date: 09.02.2017
 *
 * @author Karapetyan N.K
 */
public class PropertyReader {
    private HashMap<String, String> hashMap = new HashMap<>();

    public PropertyReader(File file){
        loading(file);
    }
    // Перегруженный конструктор
    public PropertyReader(String file){
        this(new File(file));
    }

    public String getValue(String key){
        String value = hashMap.get(key);
        return value;
    }

    /*
    * При создании объекта данного класса, происходит загрузка данных
    * из файла в HashMap.
    */
    private HashMap loading(File file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str;
            while((str = br.readLine())!=null){
                String[] temp = str.split("=");
               if(temp.length>1){
                   hashMap.put(temp[0].trim(), temp[1].trim());
               }else hashMap.put(temp[0].trim(), null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
