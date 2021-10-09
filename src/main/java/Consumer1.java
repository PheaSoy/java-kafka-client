import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer1 {
    public static void main(String[] args) {
       KafkaConsumer kafkaConsumer =  new KafkaConsumer(KafkaProperties.initProperties());
        while (true) {
            System.out.println("Received!");
            ConsumerRecords records = kafkaConsumer.poll(Long.MAX_VALUE);
            System.out.println(records); // application-specific processing
            kafkaConsumer.commitSync();
        }
    }
}
