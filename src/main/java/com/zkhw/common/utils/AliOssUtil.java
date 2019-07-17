package com.zkhw.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.zkhw.common.config.Config;

public class AliOssUtil {

    private static String endpoint = Config.endpoint;
    private static String accessKeyId = Config.oss_accessKeyId;
    private static String accessKeySecret = Config.oss_accessKeySecret;
    private static String bucketName = Config.bucketName;
    //private static String key = "12121212122111";
	public static void main(String[] args) throws IOException {
		
		String url = presignedURL(bucketName,"test");
		System.out.println(url);
		//String key = "test";
		//File file = new File("C:\\Users\\Administrator\\Desktop\\hypFollow.pdf");
		//putFile(key,bucketName,file);
	}
	public static PutObjectResult putFile(String key,String bucketName,File file){
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		try{			
			return ossClient.putObject(new PutObjectRequest(bucketName, key, file));
		}catch (OSSException oe) {
			
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
            return null;
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
            return null;
        } finally {
            ossClient.shutdown();
        }
	}
	
	public static InputStream getFileObject(String bucketName, String key){
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		try{
	        OSSObject object = ossClient.getObject(bucketName, key);
	        System.out.println("Content-Type: "  + object.getObjectMetadata().getContentType());
	        return object.getObjectContent();
		}catch (OSSException oe) {
			
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
            return null;
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
            return null;
        } finally {
            ossClient.shutdown();
        }
	}
	
	public static String presignedURL(String bucketName,String key){ //
	     Calendar ca = Calendar.getInstance();
	     ca.add(Calendar.HOUR, 23);
	     ca.add(Calendar.MINUTE, 59);
	     ca.add(Calendar.SECOND, 59);
	     ca.add(Calendar.MONTH, 1);//增加一个月
	     Date expires = ca.getTime();
		//Date expires = new Date (new Date().getTime() + 1000 * 60 * 60 * 24 * 3); // 3天后过期
		
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, key);

		generatePresignedUrlRequest.setExpiration(expires);

		URL url = ossClient.generatePresignedUrl(generatePresignedUrlRequest);

		System.out.println(url.toString());
		return url.toString();
	}
	
    @SuppressWarnings("unused")
	private static File createSampleFile() throws IOException {
        File file = File.createTempFile("oss-java-sdk-", ".txt");
        file.deleteOnExit();

        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.write("0123456789011234567890\n");
        writer.close();

        return file;
    }

    @SuppressWarnings("unused")
	private static void displayTextInputStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;

            System.out.println("    " + line);
        }
        System.out.println();
        
        reader.close();
    }
}
