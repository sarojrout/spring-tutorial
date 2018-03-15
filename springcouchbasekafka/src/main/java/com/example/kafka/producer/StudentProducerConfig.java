/**
 * 
 */
package com.example.kafka.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

/**
 * @author sarojkumarrout
 *
 */

@Configuration
public class StudentProducerConfig {

	@Autowired
	Environment env;

	@Bean
	public Map producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put("bootstrap.servers",
				env.getProperty("kafka.broker"));
		props.put("key.serializer",
				StringSerializer.class);
		props.put("value.serializer",
				JsonSerializer.class);
		props.put("linger.ms", 1);

		return props;
	}
	/**
	 * 
	 * 
	 * @return producer instance(s)
	 */

	@SuppressWarnings("rawtypes")
	@Bean
	public ProducerFactory producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	/**
	 * KafkaTemplate is used to wrap the producer instance and provides
	 * convenience methods to send data to kafka topics
	 * 
	 * @return
	 */
	@Bean
	public KafkaTemplate kafkaTemplate() {
		return new KafkaTemplate(producerFactory());
	}



}
