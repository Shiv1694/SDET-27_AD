package com.crm.autodesk.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImp implements IRetryAnalyzer
{

	public boolean retry(ITestResult result)
	{
		int count=0;
		int retryCount=5;
		
		while (count<retryCount)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
