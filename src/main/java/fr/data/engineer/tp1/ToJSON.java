package fr.data.engineer.tp1;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToJSON {
    ObjectMapper objectMapper =new ObjectMapper();
    public  List<Person> mapper(){
        List<Person> list=new ArrayList<>();
        for (int i=0;i<100;i++){
            list.add(new Person());
        }
        try {
            objectMapper.writeValue(new File("out.json"),list);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


}
