package com.telstra.codechallenge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.codechallenge.models.GithubException;
import com.telstra.codechallenge.models.RepoItems;
import com.telstra.codechallenge.models.UserFollowerItems;
import com.telstra.codechallenge.service.GithubService;

@RestController
public class GithubController {

	@Autowired
	private GithubService githubService;

	@RequestMapping(path = "/github/repos/starred/{size}", method = RequestMethod.GET)
	public List<RepoItems> getStarredRepos(@PathVariable final int size) throws Exception {

		List<RepoItems> itemList = new ArrayList<RepoItems>();
		try {

			githubService.getStarredRepos().stream().limit(size).forEach((a) -> {
				itemList.add(a);
			});
			return itemList;
		} catch (Exception ex) {
			GithubException exp = new GithubException("The following exception occured /n  " + ex.getMessage());
			throw exp;
		}
	}

	@RequestMapping(path = "github/oldusers/nofollowers/{size}", method = RequestMethod.GET)
	public List<UserFollowerItems> getOldestUsersWithZeroFollowers(@PathVariable final int size) throws Exception {

		List<UserFollowerItems> itemList = new ArrayList<UserFollowerItems>();
		try {

			githubService.getOldestUsersWithZeroFollowers().stream().limit(size).forEach((a) -> {
				itemList.add(a);
			});
			return itemList;
		} catch (Exception ex) {
			GithubException exp = new GithubException("The following exception occured /n  " + ex.getMessage());
			throw exp;
		}
	}

}
