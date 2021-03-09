package fr.data.engineer.tp1;

import com.github.javafaker.Faker;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Producer {

    public  void send(){
        try {
            ToJSON toJSON=new ToJSON();
            ObjectMapper mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, JsonAutoDetect.Visibility.ANY);
            Properties props = new Properties();
            props.put("bootstrap.servers","localhost:9092");
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
            KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

            Faker faker = new Faker();
            List<Person> list= new ArrayList<>();
            for(int i=0; i<100 ; i++ ){
                Person person=new Person();
                String jsonPerson = mapper.writeValueAsString(person);
                System.out.println(jsonPerson);
                ProducerRecord<String, String> record = new ProducerRecord<String, String>("test" , jsonPerson);
                list.add(person);
                producer.send(record);
            }
            producer.close();
            mapper.writeValue(new File("person.json"), list);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Fin");
    }
    }


