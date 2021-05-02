package com.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.main.Model.Message;
import com.main.Service.MessageFetchService;
import com.main.Service.MessageWriteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnilOdevApplicationTests {

	private final RestTemplate restTemplate = new RestTemplate();

	String url = "https://my-json-server.typicode.com/typicode/demo/comments";
	static final String fileUrl = "./output.csv";

	@Autowired
	private MessageFetchService messageFetchService;

	@Autowired
	private MessageWriteService messageWriteService;

	@Test
	public void fetchTest() {
		assertTrue(messageFetchService.fetch(url, restTemplate).size() > 0);

	}

	@Test
	public void writeTest() {
		List<Message> messageList = messageFetchService.fetch(url, restTemplate);
		assertEquals(2, messageWriteService.write(fileUrl, messageList));

	}

}
