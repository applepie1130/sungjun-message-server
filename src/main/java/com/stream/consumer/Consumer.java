package com.stream.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

import com.stream.model.entity.TempEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableBinding(Sink.class)
public class Consumer {

	@StreamListener(target = Sink.INPUT)
	public void consume(@Payload TempEntity tempEntity) {
		log.info("receive message : {}", tempEntity);
	}
	
}