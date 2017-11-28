package com.saroj.demo;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author sarojkumarrout
 *
 */
public class SampleConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleConsumer.class);
	public static void main(String[] args) {
		Properties props = new Properties();
	     props.put("bootstrap.servers", "localhost:9092");
	     props.put("group.id", "test");
	     props.put("enable.auto.commit", "true");
	     props.put("auto.commit.interval.ms", "1000");
	     props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
	     consumer.subscribe(Arrays.asList("demo-topic1"));
	     try {
	    	 while (true) {
		         ConsumerRecords<String, String> records = consumer.poll(100);
		         for (ConsumerRecord<String, String> record : records)
		         System.out.println(record.toString());
		     }
		
	     } catch(Exception e) {
	    	 LOGGER.error("Exception occured while consuing messages",e);
	     }finally {
	    	 consumer.close();
	     }
	     
	}
}
