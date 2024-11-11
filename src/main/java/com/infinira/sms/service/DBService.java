package com.infinira.sms.service;

import java.util.Properties;
import java.text.MessageFormat;
import java.io.InputStream;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class DBService{
    private static final String PROPERTY_FILE= "dbconfig.properties";
    private static final String URL ="db.url";
    private static final String USERNAME = "db.username";
    private static final String PASSWORD = "db.password";
    private String userName = null;
    private String password = null;
    private String url = null;
    
    private volatile static DBService dbService; 
    
    public static DBService getInstance(){
        if(dbService == null){
            synchronized(DBService.class){
                if(dbService == null){
                    dbService= new DBService();
                }
            }
        }
        return dbService;
    }
    
    private DBService(){
        init();
    }
    
    private void init(){
        Properties prop= new Properties();
        InputStream inputStream = null;
        try{
            inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE);
        }catch(Throwable th){
            throw new RuntimeException(MessageFormat.format(SMS_MSG_1001, PROPERTY_FILE), th);
        }
        
        try{
            prop.load(inputStream);
        } catch(Throwable th){
            throw new RuntimeException(MessageFormat.format(SMS_MSG_1002, PROPERTY_FILE), th);
        }finally {
        	if(inputStream != null){
				try {
					inputStream.close();
			    } catch(Throwable th){
					throw new RuntimeException (MessageFormat.format(SMS_MSG_1003, PROPERTY_FILE), th);
				}
			}
        }
        url = prop.getProperty(URL);
        validate(url,URL,PROPERTY_FILE);
        userName = prop.getProperty(USERNAME);
        validate(userName,USERNAME,PROPERTY_FILE);
        password = prop.getProperty(PASSWORD);
        validate(password,PASSWORD,PROPERTY_FILE);        
    }    
    
    public Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url,userName,password);
        } catch(Throwable th){
            throw new RuntimeException(MessageFormat.format(SMS_MSG_1004, url, userName), th);
        }   
        return conn;        
    }
    
    public  void closeResources(ResultSet rs, Statement stmt, Connection conn){
        if (rs!=null){
            try{
                rs.close();
            } catch(Throwable th){
                //throw new RuntimeException(SMS_MSG_1035,th);
            }
        }
        if (stmt != null){
            try{
                stmt.close();
            } catch(Throwable th){
				 //throw new RuntimeException(SMS_MSG_1036,th);  
            }
        }
        if (conn != null){
            try{
                conn.close();
            } catch(Throwable th){
				//throw new RuntimeException(SMS_MSG_1037,th); 
            }
        }
    }
    
    private void validate(String value,String property,String file){
        if(value == null || value.isEmpty()){
            throw new RuntimeException(MessageFormat.format("Invalid property <{0}> in property file <{1}>",property,file));
        }
    }
    
    private static final String SMS_MSG_1001 = "Property file <{0}> not found";
    private static final String SMS_MSG_1002 = "Cannot load data from file : <{0}>";
    private static final String SMS_MSG_1003 = "Cannot close property file : <{0}>";
    private static final String SMS_MSG_1004 = "Connection failed with URL: <{0}> and USERNAME : <{1}>";
    private static final String SMS_MSG_1005 = "Invalid property <{0}> in property file <{1}>";
    private static final String SMS_MSG_1035 = "Failed to close ResultSet";
    private static final String SMS_MSG_1036 = "Failed to close Statement";
    private static final String SMS_MSG_1037 = "Failed to close Connection";
}