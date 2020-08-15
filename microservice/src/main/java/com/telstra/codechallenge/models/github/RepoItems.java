package com.telstra.codechallenge.models.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RepoItems {

	String name;
	String html_url;
	String watchers_count;
	String language;
	String description;

}
