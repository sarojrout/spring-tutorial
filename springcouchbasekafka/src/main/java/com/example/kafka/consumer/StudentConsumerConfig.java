/**
 * 
 */
package com.example.kafka.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.springcouchbase.entity.Student;

/**
 * @author sarojkumarrout
 *
 */
@Configuration
@EnableKafka
public class StudentConsumerConfig {
	
	@Autowired
	Environment env;

	/**
	 * Listener creates Consumer Factory 
	 * The ConcurrentMessageListenerContainer required to provide multi-threaded consumption.
	 * ConcurrentMessageListenerContainer delegates the request to 1 or more KafkaMessageListenerContainers to provide
	 * multi-threaded consumption.
	 */
	@Bean
	KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Student>> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Student> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.getContainerProperties().setPollTimeout(3000);
		factory.getContainerProperties().setAckMode(
				AbstractMessageListenerContainer.AckMode.MANUAL);
		return factory;
	}

	/**
	 * Create the consumers by loading the config
	 * 
	 * @return
	 */
	@Bean
	public ConsumerFactory<String, Student> consumerFactory() {

		return new DefaultKafkaConsumerFactory<>(consumerConfigs(),
				new StringDeserializer(), new JsonDeserializer<>(
						Student.class));
	}

	/**
	 * reads the config info from yml file
	 * 
	 * @return
	 */
	@Bean
	public Map<String, Object> consumerConfigs() {
		Map<String, Object> propsMap = new HashMap<>();
		propsMap.put("bootstrap.servers",
				env.getProperty("kafka.broker"));
		propsMap.put("enable.auto.commit",
				env.getProperty("enable.auto.commit"));
		propsMap.put("auto.commit.interval.ms",
				env.getProperty("auto.commit.interval.ms"));
		propsMap.put("key.deserializer",
				StringDeserializer.class);
		propsMap.put("value.deserializer",
				JsonDeserializer.class);
		propsMap.put("group.id",
				env.getProperty("group.id"));
		propsMap.put("auto.offset.reset",
				env.getProperty("kafka.auto.offset.reset"));
		return propsMap;

	}
	/**
	 * 
	 * @return WsEventConsumer instance which starts consuming the message
	 */
	@Bean
	public KafkaEventConsumer consume() {
		return new KafkaEventConsumer();
	}


}
