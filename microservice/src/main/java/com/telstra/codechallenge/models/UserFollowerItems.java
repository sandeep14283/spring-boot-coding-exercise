package com.telstra.codechallenge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserFollowerItems {

	String id;
	String login;
	String html_url;

}
