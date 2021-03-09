package fr.data.engineer.tp1;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.*;

public class Consumer implements Runnable {
    private final KafkaConsumer<String, String> consumer;
    Properties props;

    public Consumer(String topic) {
        props = new Properties();
        props.put("bootstrap.servers","localhost:9092");
        props.put("group.id", "mygroup");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Collections.singletonList(topic));
    }
    @Override
    public void run() {
        try{

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Long.MAX_VALUE);
                for (ConsumerRecord<String, String> record : records) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("partition", record.partition());
                    data.put("offset", record.offset());
                    data.put("value", record.value());
                }
            }
        }catch (Exception e){

        }finally {
            consumer.close();
        }

    }
    public static void main(String[] args) {
        Consumer consumerThread = new Consumer("test");
        consumerThread.run();
    }
}
