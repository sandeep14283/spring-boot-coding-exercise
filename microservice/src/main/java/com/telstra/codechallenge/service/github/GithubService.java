package com.telstra.codechallenge.service.github;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telstra.codechallenge.models.github.GitHubUsersFollowers;
import com.telstra.codechallenge.models.github.GithubException;
import com.telstra.codechallenge.models.github.GithubRepo;
import com.telstra.codechallenge.models.github.RepoItems;
import com.telstra.codechallenge.models.github.UserFollowerItems;
import com.telstra.codechallenge.quotes.Quote;

@Service
public class GithubService {
	
	
	@Value("${github.repo.url}")
	 private String githubRepoUrl;
	
	@Value("${github.oldusers.followers}")
	 private String githubFollowersUrl;

	@Autowired
	  private RestTemplate restTemplate;

	  
	public List<RepoItems> getStarredRepos() throws Exception{


		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", "application/vnd.github.v3+json");
			
			 return restTemplate.getForObject(githubRepoUrl , GithubRepo.class).getItems();
		} catch (Exception ex) {
			
			GithubException exp = new GithubException("The following exception occured ::::   "+ex.getMessage());
			throw exp;
		}
	  }
	
	public List<UserFollowerItems> getOldestUsersWithZeroFollowers() throws Exception{

		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", "application/vnd.github.v3+json");
			
			 return restTemplate.getForObject(githubFollowersUrl , GitHubUsersFollowers.class).getItems();
		} catch (Exception ex) {
			
			GithubException exp = new GithubException("The following exception occured ::::   "+ex.getMessage());
			throw exp;
		}
	  }
	
	
	
	  

}
