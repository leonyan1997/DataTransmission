package source;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

import static config.Config.*;
import static org.apache.kafka.clients.producer.ProducerConfig.*;


/**
 * @author leonyan
 * */
public class DataSource {
    public static void main(String[] args) {
        KafkaProducer<String, String> producer = new KafkaProducer<>(getProperties());

        int recordNum = 1000;
        ProducerRecord<String, String> record = null;
        for (int i = 0; i < recordNum; i++) {
            record = new ProducerRecord<>(TOPIC, "value" + (int) (10 * (Math.random())));
            producer.send(record, (RecordMetadata recordMetadata, Exception e) -> {
                if (null != e) {
                    e.printStackTrace();
                }
                else {
                    System.out.println(String.format("offset:%s,partition:%s", recordMetadata.offset(), recordMetadata.partition()));
                }
            });
        }

        producer.close();
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put(BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        properties.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return properties;
    }
}
