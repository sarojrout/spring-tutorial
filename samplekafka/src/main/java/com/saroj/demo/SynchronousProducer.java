/**
 * 
 */
package com.saroj.demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sarojkumarrout
 *
 */
public class SynchronousProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(SynchronousProducer.class);
	private static final String topicName = "demo-topic1";
	static String key = "sample key1";
	static String value = "sample value6";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092,localhost:9093");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		KafkaProducer<String, String> sampleProducer = new KafkaProducer<String, String>(props);
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName,key, value);

		try {

			RecordMetadata metaData = sampleProducer.send(record).get();
			System.out.printf("Message sent to Partition No. %d and offset %d", metaData.partition(), metaData.offset());
		} catch (Exception e) {
			LOGGER.error("exception occured while sending message to broker", e);
		} finally {
			sampleProducer.close();

		}
	}

}
