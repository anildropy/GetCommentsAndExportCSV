package com.main.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.main.Model.Message;
import com.main.Service.MessageFetchService;
import com.main.Service.MessageWriteService;

@RestController
public class MessageController {

	@Autowired
	private MessageFetchService messageFetchService;

	@Autowired
	private MessageWriteService messageWriteService;

	private final RestTemplate restTemplate;

	private static final String fileUrl = "./output.csv";

	String url = "https://my-json-server.typicode.com/typicode/demo/comments";

	public MessageController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@RequestMapping(value = "/getComments", produces = "text/csv", method = RequestMethod.GET)
	public void getComments() throws IOException {

		List<Message> messageList = messageFetchService.fetch(url, restTemplate);
		messageWriteService.write(fileUrl, messageList);

	}

}
