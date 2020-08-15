package com.telstra.codechallenge.service.github;

import java.util.List;

import com.telstra.codechallenge.models.github.RepoItems;
import com.telstra.codechallenge.models.github.UserFollowerItems;

public interface GithubService {

	public List<RepoItems> getStarredRepos() throws Exception;

	public List<UserFollowerItems> getOldestUsersWithZeroFollowers() throws Exception;

}
