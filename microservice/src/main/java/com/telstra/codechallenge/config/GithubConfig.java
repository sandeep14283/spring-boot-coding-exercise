package com.telstra.codechallenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class GithubConfig {

	@Bean
	@Primary
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public RestTemplate getCustomRestTemplate() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		ObjectMapper objMapper = new ObjectMapper();
		objMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		objMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		converter.setObjectMapper(objMapper);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(converter);
		return restTemplate;
	}

}
