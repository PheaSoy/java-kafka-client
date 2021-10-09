import org.apache.kafka.common.serialization.StringSerializer;

import java.net.InetAddress;
import java.util.Properties;

public class KafkaProperties {

    static Properties initProperties() {
        Properties config = new Properties();
        try {
            config.put("client.id", InetAddress.getLocalHost().getHostName());
            config.put("bootstrap.servers", "localhost:9092");
            config.put("key.serializer", StringSerializer.class);
            config.put("acks", "all");
            config.put("value.serializer",StringSerializer.class);
        } catch (Exception exception) {

        }
        return config;
    }

}
