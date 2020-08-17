package com.telstra.codechallenge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GithubException extends Exception {

	public GithubException() {

	}

	public GithubException(String exceptionName) {
		super(exceptionName);
	}

}
