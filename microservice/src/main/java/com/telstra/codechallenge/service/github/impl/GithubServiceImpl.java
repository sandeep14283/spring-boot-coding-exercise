package com.telstra.codechallenge.service.github.impl;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.telstra.codechallenge.models.github.GitHubUsersFollowers;
import com.telstra.codechallenge.models.github.GithubException;
import com.telstra.codechallenge.models.github.GithubRepo;
import com.telstra.codechallenge.models.github.RepoItems;
import com.telstra.codechallenge.models.github.UserFollowerItems;
import com.telstra.codechallenge.service.github.GithubAbstractService;

@Service("githubService")
public class GithubServiceImpl extends GithubAbstractService {

	public List<RepoItems> getStarredRepos() throws Exception {

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", "application/vnd.github.v3+json");

			return restTemplate
					.getForObject(githubRepoUrl + ">" + dateUtil.getDatePerPatternAWeekAgo(), GithubRepo.class)
					.getItems();
		} catch (Exception ex) {

			GithubException exp = new GithubException("The following exception occured ::::   " + ex.getMessage());
			throw exp;
		}
	}

	public List<UserFollowerItems> getOldestUsersWithZeroFollowers() throws Exception {

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", "application/vnd.github.v3+json");

			return restTemplate.getForObject(githubFollowersUrl, GitHubUsersFollowers.class).getItems();
		} catch (Exception ex) {

			GithubException exp = new GithubException("The following exception occured ::::   " + ex.getMessage());
			throw exp;
		}
	}

}
