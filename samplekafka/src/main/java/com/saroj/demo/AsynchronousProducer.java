/**
 * 
 */
package com.saroj.demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sarojkumarrout
 *
 */
public class AsynchronousProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(AsynchronousProducer.class);
	private static final String topicName = "demo-topic1";
	static String key = "sample key";
	static String value = "sample value5";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092,localhost:9093");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		KafkaProducer<String, String> sampleProducer = new KafkaProducer<String, String>(props);
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, key, value);

		try {

			sampleProducer.send(record, new MyCallBack());
		} catch (Exception e) {
			LOGGER.error("exception occured while sending message to broker", e);
		} finally {
			sampleProducer.close();

		}
	}

}

class MyCallBack implements Callback {
	private static final Logger LOGGER = LoggerFactory.getLogger(MyCallBack.class);

	public void onCompletion(RecordMetadata metadata, Exception exception) {
		if (exception != null) {
			LOGGER.error("Producer failed with an exception", exception);
		} else {
			LOGGER.info("Producer call successfully sent the message to broker");
		}
	}

}
