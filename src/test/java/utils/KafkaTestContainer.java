package utils;

import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

public class KafkaTestContainer {
    private static KafkaContainer kafka;

    public static void start() {
        if (kafka == null) {
            kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));
            kafka.start();
        }
    }

    public static String getBootstrapServers() {
        return kafka.getBootstrapServers();
    }

    public static void stop() {
        if (kafka != null) {
            kafka.stop();
        }
    }
}
