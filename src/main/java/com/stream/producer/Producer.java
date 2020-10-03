
package com.stream.producer;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import com.stream.model.entity.TempEntity;


@EnableBinding(Source.class)
public class Producer {
	
	private Source source;
	
	@Autowired
	public Producer(Source source) {
		this.source = source;
	}
	
	public Boolean sendMessage(String message) {
		MessageChannel messageChannel = source.output();
		return messageChannel.send(MessageBuilder.withPayload(TempEntity.builder()
															.message(message)
															.regDate(LocalDateTime.now())
															.build())
									.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
									.build());
	}
}
