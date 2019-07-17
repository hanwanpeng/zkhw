package com.zkhw.framework.datasource;

import java.util.Properties;

import org.springframework.beans.factory.FactoryBean;

@SuppressWarnings("rawtypes")
public class PropertiesEncryptFactoryBean implements FactoryBean{
	private Properties properties; 
	
	public Object getObject() throws Exception {  
        return getProperties();  
    }  
  
    public Class getObjectType() {  
        return java.util.Properties.class;  
    }  
  
    public boolean isSingleton() {  
        return true;  
    }  
  
    public Properties getProperties() {  
        return properties;  
    }  
  
    public void setProperties(Properties inProperties) {  
        this.properties = inProperties;  
        String originalUsername = properties.getProperty("user");  
        String originalPassword = properties.getProperty("password");  
        if (originalUsername != null){  
            String newUsername = deEncryptUsername(originalUsername);  
            properties.put("user", newUsername);  
        }  
        if (originalPassword != null){  
            String newPassword = deEncryptPassword(originalPassword);  
            properties.put("password", newPassword);  
        }  
    }  
      
    private String deEncryptUsername(String originalUsername){  
        return deEncryptString(originalUsername);  
    }  
      
    private String deEncryptPassword(String originalPassword){  
        return deEncryptString(originalPassword);  
    }  
    //�?单加�?  
    private String deEncryptString(String originalString){  
        StringBuilder newString = new StringBuilder();  
        for (int i = 0; i < originalString.length(); i++) {  
            char eachChar= originalString.charAt(i);  
            char newChar = (char)(eachChar + i);  
            newString.append(newChar);  
        }  
        return newString.toString();  
    }  
}
