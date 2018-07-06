package com.emiza.constant;

public class Constant {
	
	public static final String WAREHOUSEID="DL01";
	public static final String OWNERID="SM";
		
	
	
	
	public static final String TOKENSM="EmizaToken";
	public static final String EMIZATOKENSM="47E714F095944F6F40C42A42D8E99DC8";
	
	
	
	public static final String METHODSTRING = "method";
	public static final String METHOD = "POST";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String CONTENT_TYPE_VALUE = "application/json";
	public static final String ACCEPT = "Accept";
	public static final String TOKEN = "EmizaToken";
	public static final String SALES_ORDER_START = "SalesOrder_"; 
	public static final String SELLER_CODE = "111111";
	
	public static final String PROCESS_ORDER = "processurl";
	public static final String SO_URL = "soapi";
	public static final String PO_URL = "poapi";
	public static final String EMIZATOKEN = "emizatoken";
	public static final String PROCESSSOATEMIZA="https://uat.emizainc.in/emizawms/ProcessSOAtEmiza";
	public static final String EASYECOMURL="https://api.easyecom.io/orders/new";
	//public static final String EASYECOMTOKEN ="5be0f2a20a8a8082a0e2d9ed9a8a6a3cfe0eb3b9773dff016fec937e93b2b7a6";
	public static final String EASYECOMTOKEN ="54bcc0bf3318b117868029ead0924ac73db178e36142a0a629dc3ae07f6bf158";
	
	public static final String METHODSTRING1 = "method";
	public static final String METHODFORGET = "GET";
	public static final String CONTENT_TYPE1 = "Content-Type";
	public static final String CONTENT_TYPE_VALUE1 = "application/json";
	public static final String ACCEPT1 = "Accept";
	public static final String EASYECOMTOKEN1 = "api_token";
	
	// after successfully creation of salesorder 
	 public static final String EASYECOMORDERCONFIRMURL="https://api.easyecom.io/orders/confirm_order";
	 public static final String order_id = "order_id";
	
	 //to get the order details 
	 public static final String EASYECOMDOCUMENTS="https://api.easyecom.io/orders/documents" ;
	 
	 /* AWS Connections */
		public static final String AWS = "aws";
		public static final String ACCESS_KEY_ID = "access_key_id";
		public static final String SECRET_ACCESS_KEY = "secret_access_key";
		public static final String REGION = "region";
		public static final String DEV_BUCKET = "dev_bucket";

		public static final String AUGMENTED_WMS_ERRORS = "augmented-wms-errors";

		/*
		 * Connection Strings
		 */
		public static final String DATABASE = "database";
		public static final String DATABASELOG = "databaselog";
		public static final String DATABASEAUDIT = "databaseAudit";
		public static final String USER = "user";
		public static final String SERVER = "server";
		public static final String SERVERLOG = "serverlog";
		public static final String PORT = "port";
		public static final String NAME = "name";
		public static final String PASSWORD = "password";
		public static final String JDBCSQL = "jdbc:sqlserver://";
		public static final String CONFIG = "config.ini";
		public static final String LOCALHOST = "localhost";

		public static final String ENVIRONMENT = "env";
		public static final String ENVIRONMENT_NAME = "name";
		
		public static final String SUSER = ";user=";
		public static final String SPASSWORD = ";password=";
		public static final String SDATABASE = ";databaseName=";
		
		/*
		 * Log Strings
		 */
		public static final String LOGSECTION = "loglevel";
		public static final String LOGDEBUG = "debug";
		public static final String LOGINFO = "info";
		
		public static final String EMIZA_TOKEN_PROPERTIES_FILE = "emizatoken.properties";
		
		public static final String EMIZA_INSERT_EASYECOM_ORDER = "EXEC [dbo].[SP_EMIZA_INSERT_EASYECOM_ORDER] '<WAREHOUSE>','<OWNER>','<ORDERID>'";
		public static final String EMIZA_FETCH_EASYECOM_ORDERSFROMDATABASE="EXEC [dbo].[SP_EMIZA_GET_SALES_ORDER_FOR_DOCUMENT]";
		public static final String EMIZA_DELETE_EASYECOM_ORDER = "EXEC [dbo].[SP_EMIZA_DELETE_EASYECOM_ORDERID] '<ORDERID>'";
		public static final String EMIZA_GET_EASYECOM_ORDERS="EXEC [dbo].[SP_EMIZA_GET_EASYECOM_ORDERS] '<ORDERID>'";
		
		
		public static final String REPLACE_WAREHOUSE ="<WAREHOUSE>";
		public static final String REPLACE_OWNER ="<OWNER>";
		public static final String REPLACE_ORDERID ="<ORDERID>";
		
		public static final String SP_EMIZA_GET_INVENTORY_FOR_SM_ORDER = "EXEC [dbo].[SP_EMIZA_GET_INVENTORY_FOR_SM_ORDER] '<WAREHOUSE>','<OWNER>','<SKUCODE>'";
		public static final String REPLACE_SKUCODE ="<SKUCODE>";
		public static final String REPLACE_ORDER_ID = "<ORDER-ID>";
//response key from easyecom
		public static final String MESSAGE="message";
		public static final String SUCCESSFUL="Successful";
		public static final String 	DATA="data";
		public static final String REFERENCE_CODE ="reference_code";
		public static final String ORDER_DATE="order_date";
		public static final String SUB_ORDER="sub_orders";
		public static final String  SKU="sku";
		public static final String  QUANTITY="quantity";
		public static final String  INVENTORY= "inventory";
		public static final String ORDERED="Ordered";
		public static final String TAXRATE="tax_rate";
		public static final String MRP="mrp";
		public static final String SELLING_PRICE="selling_price";
		public static final String SUBNAME ="name";
		public static final String PHONE_NUMBER="phone_number";
		public static final String ADDRESS_LINE_1="address_line_1";
		public static final String ADDRESS_LINE_2="address_line_2";
		public static final String STATE="state";
		public static final String CITY="city";
		public static final String CODE="code";
		public static final String DOCUMENTS="documents";
		public static final String EASYECOMINVOICE="easyecom_invoice";
		public static final String EASYECOMLABEL="label";
		public static final String ORDERID="orderid";
		
	
		public static final String DATA_INI = "data.ini";
		public static final String DATA_PROPERTIES = "data.properties";
		
		public static final String AIRTEL_SERVER = "airtelServer";
		


		/*
		 * For Upload API
		 */
		
		public static final String UPLOAD_API_INITIAL = "UPLOAD_API_INITIAL";
		public static final String LABEL_UPLOAD_API_URL = "LABEL_UPLOAD_API_URL";
		public static final String INVOICE_UPLOAD_API_URL = "INVOICE_UPLOAD_API_URL";
		public static final String GET_INVOICE_URL = "GET_INVOICE_URL";
		public static final String GET_LABEL_URL = "GET_LABEL_URL";
		public static final String TOKEN_HEADER = "token";
		public static final String OWNER_ID_HEADER = "owner_id";
		public static final String GET_TOKEN = "TOKEN";
		public static final String GET_OWNER = "OWNER";
		public static final String SO_ID = "<SO-ID>";
		
		public static final String LABEL_UPLOAD_FAIL_MESSAGE = "failed to upload label";
		public static final String INVOICE_UPLOAD_FAIL_MESSAGE = "failed to upload invoice";

		public static final String CRON_STATUS = "EXEC [dbo].[SP_EMIZA_CRON_STATUS] ?, ?, ?, ?, ?, ?,?";
		public static final String STATUS_DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
		public static final String CRON_TYPE = "4";
		
		
		
}
