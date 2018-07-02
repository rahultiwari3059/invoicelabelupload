package com.emiza.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.ini4j.Ini;

import com.emiza.constant.Constant;

public class UploadUtility {

	Utility util = new Utility();

	public String uploadFile(char type, InputStream inputStream, String orderId) throws IOException {
		Logger log = util.getLogger(this.getClass());
		StringBuilder urlStringBuilder = new StringBuilder();

		// String savePath = Constant.SAVE_PATH + fileName;
		Ini ini = util.getIni(Constant.DATA_INI);

		if (type == 'L') {
			urlStringBuilder = urlStringBuilder.append(ini.get(Constant.SERVER, Constant.UPLOAD_API_INITIAL))
					.append(ini.get(Constant.SERVER, Constant.LABEL_UPLOAD_API_URL));
		} else if (type == 'I') {
			urlStringBuilder = urlStringBuilder.append(ini.get(Constant.SERVER, Constant.UPLOAD_API_INITIAL))
					.append(ini.get(Constant.SERVER, Constant.INVOICE_UPLOAD_API_URL));
		}

		// System.out.println("Uploading Label...");
		log.debug("Uploading Label...");

		String urlString = urlStringBuilder.toString();
		urlString = urlString.replace(Constant.REPLACE_ORDER_ID, orderId);
		System.out.println(urlString);

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(urlString);
		postRequest.addHeader(Constant.TOKEN_HEADER, ini.get(Constant.SERVER, Constant.GET_TOKEN));
		postRequest.addHeader(Constant.OWNER_ID_HEADER, ini.get(Constant.SERVER, Constant.GET_OWNER));
		System.out.println(ini.get(Constant.SERVER, Constant.GET_TOKEN) + " , "
				+ ini.get(Constant.SERVER, Constant.GET_OWNER));

		/*
		 * File file = new File(savePath); FileBody fileBody = new
		 * FileBody(file);
		 */
		MultipartEntityBuilder multiPartEntity = MultipartEntityBuilder.create();
		multiPartEntity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		if (type == 'L') {
			// multiPartEntity.addBinaryBody("labelFile", inputStream);
			multiPartEntity.addPart("labelFile", new InputStreamBody(inputStream, "Label.pdf"));
			// , ContentType.APPLICATION_OCTET_STREAM, null);
			// .addPart("labelFile", fileBody);
			/*
			 * multiPartEntity.addBinaryBody("Label", new FileInputStream(file),
			 * ContentType.APPLICATION_OCTET_STREAM, file.getName());
			 */
			System.out.println("Label :: ");
		} else if (type == 'I') {
			// multiPartEntity.addBinaryBody("invoiceFile", inputStream);
			multiPartEntity.addPart("invoiceFile", new InputStreamBody(inputStream, "Invoice.pdf"));
			// , ContentType.APPLICATION_OCTET_STREAM, null);
			// multiPartEntity.addPart("invoiceFile", fileBody);
			/*
			 * multiPartEntity.addBinaryBody("Invoice", new
			 * FileInputStream(file), ContentType.APPLICATION_OCTET_STREAM,
			 * file.getName());
			 */
			System.out.println("Invoice :: ");
		}

		// Prepare payload

		// Set to request body
		postRequest.setEntity(multiPartEntity.build());

		// Send request
		HttpResponse response;

		response = client.execute(postRequest);
		// reading response
		if (response != null) {
			InputStream ips = response.getEntity().getContent();
			System.out.println(
					response.getStatusLine().getStatusCode() + " , " + response.getStatusLine().getReasonPhrase());

			BufferedReader buf = new BufferedReader(new InputStreamReader(ips, "UTF-8"));
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				System.out.println(response.getStatusLine().getReasonPhrase());
				return (response.getStatusLine().getReasonPhrase());
			}
			StringBuilder sb = new StringBuilder();
			String s;
			while (true) {
				s = buf.readLine();
				if (s == null || s.length() == 0)
					break;
				sb.append(s);

			}
			buf.close();
			ips.close();
			// System.out.println(sb.toString());
			return (sb.toString());

		}

		if (type == 'L') {
			return Constant.LABEL_UPLOAD_FAIL_MESSAGE;
		} else {
			return Constant.INVOICE_UPLOAD_FAIL_MESSAGE;
		}

	}

}
