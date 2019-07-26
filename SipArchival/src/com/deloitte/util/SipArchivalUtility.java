package com.deloitte.util;

import java.io.*;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.deloitte.model.Dss;
import com.deloitte.model.Sip;

public class SipArchivalUtility {
	
	/*public void createBatchSubdirectory(String sourceFileLocation,String batchFoldersLocation)
	{
		
		//Create the batchSubdirectory
		try
		{
			String strDirectoy ="test";
			
			// Create one directory
			boolean success = (new File(strDirectoy)).mkdir();
			if (success)
			{
				System.out.println("Directory: " + strDirectoy + " created");
			}  
		}
		catch (Exception e)
		{
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
		//Read the sourceFileLocation
		
		//Paste the xmls in the newly created batchsubdirectory
		
		
	}*/
	
	public int createSIPDescriptor()
	{
       //create the xml file
		Sip sipObj = new Sip();
		
		sipObj.setAiu_count("10");
		sipObj.setIs_last("true");
		sipObj.setPage_count("0");
		sipObj.setSeqno("1");
		
		Dss dssObj = new Dss();
		
		dssObj.setHolding("PhoneCallsGranular");
		dssObj.setId("1000001");
		dssObj.setPdi_schema("urn:eas-samples:en:xsd:phonecalls.1.0");
		dssObj.setProduction_date("2002-12-01T00:00:00.000+01:00");
		dssObj.setBase_retention_date("2002-12-01T00:00:00.000+01:00");
		dssObj.setProducer("CC");
		dssObj.setEntity("Platform");
		dssObj.setPriority("0");
		dssObj.setApplication("UA");
		
		sipObj.setDss(dssObj);
        
        try {
        	JAXBContext jc = JAXBContext.newInstance(Sip.class);
        	Marshaller marshaller = jc.createMarshaller();
        	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(sipObj, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sipObj);
		
		return 0;
		//save the file with name "eas_sip.xml".
	}
/*	
	public int createConsolidatedPdiXmlFile()
	{
		//Insert root tag before starting the consolidation
		
		//save the file with name "eas_pdi.xml".
	}
	
	public int createSipArchive()
	{
		
	}*/
	
	public int countOfXmls()
	{
		int count=0;
		
		FileReader fileReaderObj = new FileReader("config.properties");
		Properties propObj = new Properties();
		File xmlFileLocation = null;
		
		try {
			propObj.load(fileReaderObj);
			
			xmlFileLocation = new File(propObj.getProperty("SOURCE_FILE_LOCATION"));
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		return count;
	}

}
