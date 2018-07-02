package com.emiza.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ini4j.InvalidFileFormatException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.emiza.Connection.Connection;
import com.emiza.constant.Constant;
import com.emiza.util.UploadUtility;




public class InvoiceLabelfetch {

	public static void main(String[] args) throws Exception{
		
		Connection connectionObject= new Connection();
		
	FetchOrders fetchordersObject= new FetchOrders();
	ResultSet rs=fetchordersObject.fetchAllOrder();
	UploadUtility uploadUtilityObject= new UploadUtility();
	
	while(rs.next())
	{
		Long orderid=((Long)rs.getLong(Constant.ORDERID));
		System.out.println(orderid);
		
		String documentResponseJson=connectionObject.getConnectionForEasyEcomDocument(orderid);
		System.out.println(documentResponseJson);
		
		JSONParser parser = new JSONParser();

		try {
			
			 // Object documentObject = parser.parse(new FileReader("C:\\rahul_work\\DocumentResponseFromEasyEcom.json"));
			Object documentObject = parser.parse(documentResponseJson);
			 JSONObject documentResponsejsonobject = (JSONObject) documentObject;
			 
			 JSONObject dataresponsejsonobject=(JSONObject)documentResponsejsonobject.get(Constant.DATA);
			 
			 Long successcode=(Long)documentResponsejsonobject.get(Constant.CODE);
			 if(successcode!=200)
			 {
				 break;
			 }
			 else{
				 fetchordersObject.deleteOrderIDFromtable(Long.toString(orderid));
				 
			 JSONObject documentresponsejsonobject=(JSONObject)dataresponsejsonobject.get(Constant.DOCUMENTS);
			 
			 System.out.println(documentresponsejsonobject);
			 
			 String easyecominvoicelink=(String) documentresponsejsonobject.get(Constant.EASYECOMINVOICE);
			 
			 InputStream invoiceFile = new URL(easyecominvoicelink).openStream();
			// File invoiceFile = new File(easyecominvoicelink);
			 //   InputStream invoicestream = new FileInputStream(invoiceFile);
			    uploadUtilityObject.uploadFile('I', invoiceFile, Long.toString(orderid));
			
			    System.out.println(easyecominvoicelink);
			 
			 String easyecomlabellink=(String) documentresponsejsonobject.get(Constant.EASYECOMLABEL);
			 System.out.println(easyecomlabellink);
			
			 InputStream labelFile = new URL(easyecomlabellink).openStream();
			// File labelfile = new File(easyecomlabellink);
			 //   InputStream labelfilestream = new FileInputStream(labelfile);
			    uploadUtilityObject.uploadFile('L', labelFile, Long.toString(orderid));
			    
		}
		}
		catch(Exception e)
		{
			System.out.println("unable to open file");
			e.printStackTrace();
		}
		
	}
		
		
	
		}

}
