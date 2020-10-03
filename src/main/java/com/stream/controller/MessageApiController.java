package com.stream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stream.model.entity.MessageResponseEntity;
import com.stream.producer.Producer;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(path = "/v1/message/", produces = "application/json")
public class MessageApiController {
	
private final Producer producer;
	
	@Autowired
	public MessageApiController(final Producer producer) {
		this.producer = producer;
	}
	
	/**
	 * {@link }http://localhost:8081/v1/message/string-send?msg=hello
	 * @param message
	 * @return
	 */
	@GetMapping(path="string-send")
	public ResponseEntity<MessageResponseEntity> send(@RequestParam("msg") String message) {
		// send data
		Boolean sendMessage = producer.sendMessage(message);
		
		return new ResponseEntity<>(MessageResponseEntity.builder()
				.result(sendMessage)
				.status(HttpStatus.CREATED)
				.message("처리되었습니다.")
				.build()
				, HttpStatus.OK);
	}
}