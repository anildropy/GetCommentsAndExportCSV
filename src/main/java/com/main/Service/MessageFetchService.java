package com.main.Service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.main.Model.Message;

@Service
public class MessageFetchService {

	public List<Message> fetch(String url, RestTemplate restTemplate) {

		ResponseEntity<List<Message>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Message>>() {
				});

		return responseEntity.getBody();

	}

}
