package com.telstra.codechallenge.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("dateUtil")
public class DateUtil {

	public String getDatePerPatternAWeekAgo() {

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000));

		return date;
	}

}
