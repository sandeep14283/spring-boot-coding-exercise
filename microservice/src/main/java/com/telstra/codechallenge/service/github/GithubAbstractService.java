package com.telstra.codechallenge.service.github;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.telstra.codechallenge.util.DateUtil;

public abstract class GithubAbstractService implements GithubService {

	@Autowired
	protected DateUtil dateUtil;

	@Value("${github.repo.url}")
	protected String githubRepoUrl;

	@Value("${github.oldusers.followers}")
	protected String githubFollowersUrl;

	@Autowired
	protected RestTemplate restTemplate;

}
