package com.employee.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String empName()
	{
		String generateString = RandomStringUtils.randomAlphabetic(2);
		return ("John"+generateString);
	}
	public static String empSal()
	{
		String generateString = RandomStringUtils.randomNumeric(5);
		return (generateString);
	}
	public static String empAge()
	{
		String generateString = RandomStringUtils.randomNumeric(2);
		return (generateString);
	}
	public static String empJob()
	{
		String generateString = RandomStringUtils.randomAlphabetic(2);
		return ("Loan "+generateString);
	}
}
