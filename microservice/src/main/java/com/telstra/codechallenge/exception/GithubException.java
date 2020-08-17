package com.telstra.codechallenge.exception;

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
