/**
 * 
 */
package com.example.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.example.springcouchbase.entity.Student;

/**
 * @author sarojkumarrout
 *
 */
@Component
public class KafkaEventProducer {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(KafkaEventProducer.class);
	@Autowired
	private KafkaTemplate<String, Student> kafkaTemplate;

	@Autowired
	Environment env;
	
	public void sendMessage(Student student) {

		ListenableFuture<SendResult<String, Student>> future = kafkaTemplate
				.send(env.getProperty("kafka.topics"), student);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Student>>() {

			@Override
			public void onFailure(Throwable ex) {
				LOGGER.error("Inside Exception");

			}

			@Override
			public void onSuccess(SendResult<String, Student> result) {
				LOGGER.info("Inside Success");

			}
		});

	}	

}
