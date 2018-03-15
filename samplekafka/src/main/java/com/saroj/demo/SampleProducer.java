/**
 * 
 */
package com.saroj.demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author sarojkumarrout
 *
 */
public class SampleProducer {
	
	private static final String topicName="demo-topic1";
	static String key="sample key";
	static String value="sample value3";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Properties props=new Properties();
		props.put("bootstrap.servers", "localhost:9092,localhost:9093");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		KafkaProducer<String,String> sampleProducer= new KafkaProducer<String,String>(props);
		
//		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, value);		
//		sampleProducer.send(record);
		for (int i = 0; i < 10; i++)
			sampleProducer.send(new ProducerRecord<String, String>("demo-topic1","Data:"+ Integer.toString(i)));
		sampleProducer.close();
	} 

}
