package com.telstra.codechallenge;

import com.intuit.karate.junit5.Karate;

public class FunctionalIT {

	@Karate.Test
	Karate testGitHub() {
		return Karate.run("github").relativeTo(getClass());
	}

}