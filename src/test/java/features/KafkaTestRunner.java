package features;

import com.intuit.karate.junit5.Karate;

public class KafkaTestRunner {

    @Karate.Test
    Karate testKafkaFeature() {
        return Karate.run("kafka-test").relativeTo(getClass());
    }
}
