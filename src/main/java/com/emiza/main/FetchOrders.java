package com.emiza.main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ini4j.InvalidFileFormatException;

import com.emiza.constant.Constant;
import com.emiza.dao.DatabaseUtility;
import com.emiza.dto.Status;

public class FetchOrders {

	DatabaseUtility dbUtility = new DatabaseUtility();
	
	public ResultSet fetchAllOrder() throws InvalidFileFormatException, SQLException, IOException {
			
			Object result = null;
			String query = Constant.EMIZA_FETCH_EASYECOM_ORDERSFROMDATABASE;
			//System.out.println(query);
			
			ResultSet resultSet = dbUtility.executeSqlStringTransaction(query);
			//System.out.println(resultSet);
		
			return resultSet;
		}
	
	public ResultSet checkInvoiceAndLabelAndPicked(String orderId) throws InvalidFileFormatException, SQLException, IOException {
		
		Object result = null;
		String query = Constant.EMIZA_GET_EASYECOM_ORDERS.replace(Constant.REPLACE_ORDERID, orderId);
		System.out.println(query);
		
		ResultSet resultSet = dbUtility.executeSqlStringTransaction(query);
		System.out.println(resultSet);
	
		return resultSet;
	}
public void deleteOrderIDFromtable(String orderId) throws InvalidFileFormatException, SQLException, IOException {
		 
		
		String query = Constant.EMIZA_DELETE_EASYECOM_ORDER
														.replace(Constant.REPLACE_ORDERID, orderId);
		System.out.println(query);
		
		ResultSet resultSet = dbUtility.executeSqlStringTransaction(query);
		
		//System.out.println(resultSet);
		while(resultSet.next())
		{
			String status=resultSet.getString("STATUS");
			System.out.println(status);
		}
		
	}

}
