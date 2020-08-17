package com.telstra.codechallenge.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.telstra.codechallenge.MicroServiceMain;
import com.telstra.codechallenge.models.GitHubUsersFollowers;
import com.telstra.codechallenge.exception.GithubException;
import com.telstra.codechallenge.models.GithubStarredRepository;
import com.telstra.codechallenge.models.RepoItems;
import com.telstra.codechallenge.models.UserFollowerItems;
import com.telstra.codechallenge.service.GithubAbstractService;

@Service("githubService")
public class GithubServiceImpl extends GithubAbstractService {

	static final Logger log = LoggerFactory.getLogger(GithubServiceImpl.class);
	
	public List<RepoItems> getStarredRepos() throws Exception {

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", "application/vnd.github.v3+json");
			log.info(" Trigerring api for starred repos");
			return restTemplate
					.getForObject(githubRepoUrl + ">" + dateUtil.getDatePerPatternAWeekAgo(), GithubStarredRepository.class)
					.getItems();
		} catch (Exception ex) {

			GithubException exp = new GithubException(ex.getMessage());
			throw exp;
		}
	}

	public List<UserFollowerItems> getOldestUsersWithZeroFollowers() throws Exception {

		try {

			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", "application/vnd.github.v3+json");
			log.info(" Trigerring api for older users with no followers");
			return restTemplate.getForObject(githubFollowersUrl, GitHubUsersFollowers.class).getItems();
		} catch (Exception ex) {

			GithubException exp = new GithubException(ex.getMessage());
			throw exp;
		}
	}

}
