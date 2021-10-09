import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Producer1 {
    public static void main(String[] args) throws Exception {
        String topic = "sample_topic";
        String msg = "Hello World from Java Client";

        // Init
        KafkaProducer kafkaProducer = new KafkaProducer(KafkaProperties.initProperties());
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, msg);
        Future<RecordMetadata> future = kafkaProducer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                System.out.println("Sent complete in callback!"+recordMetadata.partition());
            }
        });

        Thread.sleep(5000);
        System.out.println("Done!");
    }
}
