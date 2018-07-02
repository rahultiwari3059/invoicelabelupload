package com.emiza.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ProtocolException;
import java.net.URLConnection;

import com.emiza.Connection.Connection;

public class Util {

		// after confirmation of order
				public String responseFromEasyEcomforDocuments(Long orderid)
				{
					Long order_id=orderid;
					String resultdata=null;
					try{
						Connection conn = new Connection();
						resultdata = conn.getConnectionForEasyEcomDocument(order_id);
					}
					catch (ProtocolException e) {
						return e.getMessage();

					} catch (IOException e) {
						return e.getMessage();
					} catch (Exception e) {
						return e.getMessage();
					}		
					return resultdata;
				}
}