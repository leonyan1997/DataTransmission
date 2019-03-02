package sink;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import static config.Config.*;
import static org.apache.kafka.clients.consumer.ConsumerConfig.*;

/**
 * @author leonyan
 * */
public class DataSink {
    public static void main(String[] args) {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getProperties());
        consumer.subscribe(Collections.singletonList(TOPIC));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ZERO);
            for (ConsumerRecord record : records) {
                System.out.println(record);
            }
        }
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        properties.put(BOOTSTRAP_SERVERS_CONFIG,BROKER_LIST);
        properties.put(GROUP_ID_CONFIG,"0");
        properties.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ENABLE_AUTO_COMMIT_CONFIG, "true");
        properties.setProperty(AUTO_OFFSET_RESET_CONFIG, "earliest");

        return properties;
    }
}
