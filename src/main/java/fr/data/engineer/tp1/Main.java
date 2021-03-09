package fr.data.engineer.tp1;

public class Main {
    public Main(){
        execute();
    }

    void  execute(){
        ToJSON toJSON=new ToJSON();
        Producer kafkaProducer=new Producer();
        //toJSON.mapper();
        kafkaProducer.send();
    }
    public static void main(String[] args) {
        new Main();
    }
}
