package com.doing.parse.asParse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class main {

	static String messegeString=new String("success");
	static String tmpmessegeString=new String("null");
	@SuppressWarnings("finally")
	public String specParser(String fileName,String userID)
	{
	  	String parentFilePath;
	  	String subSpecID;
	  	String specID;	
	  	String rString;
	  	//tmpmessegeString="null";
		try {
			messegeString="success";
			tmpmessegeString="null";
			File file = new File(fileName);
			FileInputStream inFile=null;		
			parentFilePath = file.getParent();
			int index=fileName.lastIndexOf("/");
		  	subSpecID=fileName.substring(index+1);
		  	System.out.println("subSpecID:"+subSpecID);

			index=parentFilePath.lastIndexOf("\\");
			specID=parentFilePath.substring(index+1);
			System.out.println("specID:"+specID);
			try {	
				System.out.println("33");
				inFile=new FileInputStream(file);
				System.out.println("35");
				Grammar parse=new Grammar(inFile);
				System.out.println("37");
				parse.specification(specID,subSpecID,userID);
				System.out.println("39");
				
			} catch (ParseException e1) {
				String tsString=e1.toString();
				System.out.println("31e1"+tsString);	
				this.tmpmessegeString=e1.toString();
			}catch(IOException ioe){
					System.out.println(ioe.toString());
					this.messegeString=ioe.toString();
			}
		}
		finally {
			if(messegeString.equals("success")&&(!tmpmessegeString.equals("null")))
				return tmpmessegeString;
			else 
				return messegeString;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String fileName = "E:\\2015\\myeclipse workplace\\Test\\test.asoc";
		//String fileName = "E:\\2015\\myeclipse workplace\\SofiaParser\\src\\cn\\njust\\dao\\Stack.as";
		//String fileName = "E:\\2015\\GoGrid\\Common Requests and Response .as";		
		//String fileName = "E:\\2015\\GoGrid\\HTTP Framework.as";
		//String fileName = "E:\\2015\\GoGrid\\Objects and Collections.as";
		//String fileName = "E:\\2015\\GoGrid\\Server.as";
//		String fileName = "C:\\Users\\TEL13218888686\\Desktop\\GoGrid2.as";
		//String fileName = "E:\\2015\\GoGrid.as";
		//String fileName = "E:\\2015\\GoGrid-v2\\HTTPFramework.as";
		//String fileName = "E:\\GogridTest\\GoGrid.asoc";   //ok
		//String fileName = "E:/GogridTest/gg.as";   //ok
		String fileName = "D:/1NJUST/Project/algspec/specification/oppo/Medical/Doctor";   //ok
		//String fileName = "E:\\2015\\GoGrid-v2\\Common Requests and Responses of GoGrid.as";//ok
		//String fileName = "E:\\2015\\GoGrid-v2\\Option.as";//ok
		//String fileName = "E:\\2015\\GoGrid-v2\\Server.as";
		//String fileName = "E:\\2015\\Weather\\WeatherWS10.23.txt";
		//String fileName = "E:\\2015\\CWS\\WeatherService.as";
		//String fileName = "E:\\2015\\CWS\\city.as";
		//String fileName = "E:\\2015\\WeatherAS2OWL-V1\\CurrWeather\\weather-v2.as";
		String userID="chan";
		System.out.println(fileName);
		//String fileName = "E:\\2015\\WeatherAS2OWL-V1\\GlobleWeather\\globalweather.as";
		//String fileName = "E:\\2015\\WeatherAS2OWL-V1\\ChinaWeather\\WeatherWS10.26.as";
		main ma=new main();
		String pm;
		pm=ma.specParser(fileName,userID);
		System.out.println("screempm"+pm);
	}
}