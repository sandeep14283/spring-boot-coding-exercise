package com.telstra.codechallenge.service;

import java.util.List;

import com.telstra.codechallenge.models.RepoItems;
import com.telstra.codechallenge.models.UserFollowerItems;

public interface GithubService {

	public List<RepoItems> getStarredRepos() throws Exception;

	public List<UserFollowerItems> getOldestUsersWithZeroFollowers() throws Exception;

}
