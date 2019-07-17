package com.zkhw.common.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
                 
    public static String shanxiUrl;
    
    public static String baiheUrl;
    
    public static String danfengUrl;
    
    public static String endpoint;
    
    public static String oss_accessKeyId;
    
    public static String oss_accessKeySecret;
    
    public static String bucketName;
    
    static{
        Properties prop = new Properties();   
        InputStream in = Config.class.getResourceAsStream("/config.properties");   
        try {   
            prop.load(in);            
            shanxiUrl = prop.getProperty("shanxiUrl").trim();
            baiheUrl = prop.getProperty("baiheUrl").trim();
            danfengUrl = prop.getProperty("danfengUrl").trim();
            
            endpoint = prop.getProperty("endpoint").trim();
            oss_accessKeyId = prop.getProperty("oss_accessKeyId").trim();
            oss_accessKeySecret = prop.getProperty("oss_accessKeySecret").trim();
            bucketName = prop.getProperty("bucketName").trim();
            
        } catch (IOException e) {   
            e.printStackTrace();   
        } 
    }
}
