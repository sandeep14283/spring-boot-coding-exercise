package com.telstra.codechallenge.models.github;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GithubRepo {
	
	
	private int total_count;

    private boolean incomplete_results;

    private List<RepoItems> items;

}
