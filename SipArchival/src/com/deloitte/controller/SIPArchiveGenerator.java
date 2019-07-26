package com.deloitte.controller;

import com.deloitte.util.SipArchivalUtility;

public class SIPArchiveGenerator {

	public static void main(String[] args) {
		
		int numberOfXmls = 0;
		int numberOfBatches = 0;
		
		SipArchivalUtility sipArchivalUtilityObj = new SipArchivalUtility();
		
		numberOfXmls = sipArchivalUtilityObj.countOfXmls();
		
		numberOfBatches = getBatchCount(numberOfXmls);
		
		for(int counter=0;counter < numberOfBatches;counter++)
		{
			//sipArchivalUtilityObj.createBatchSubdirectory(sourceFileLocation,batchesDirectoryLocation);
		}
		
		sipArchivalUtilityObj.createSIPDescriptor();
		
	}

	private static int getBatchCount(int numberOfXmls) 
	{
		int numberOfBatches;
		if(numberOfXmls%10 == 0)
		{
			numberOfBatches = numberOfXmls/10;
		}
		else
		{
			numberOfBatches = numberOfXmls/10 + 1;
		}
		return numberOfBatches;
	}

}
