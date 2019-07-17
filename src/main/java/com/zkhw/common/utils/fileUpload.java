package com.zkhw.common.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class fileUpload {

	public static String uploadLogoImg(HttpServletRequest request) throws IllegalStateException, IOException{
		
		String fileType = "";
	    String newFileName = "";
		String path = request.getSession().getServletContext().getRealPath( "/logo_img/");
		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        UUID imgCode = UUID.randomUUID();
        //String imgCode = codeUtil.getUUID();
        String imgUrl = "/logo_img/";
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
            File savePath = null;
            while(iter.hasNext()){  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){  
                    //取得当前上传文件的文件名称  
                   String myFileName = file.getOriginalFilename();
                   fileType = myFileName.substring( myFileName.lastIndexOf(".") + 1, myFileName.length() );
                   fileType = fileType.toLowerCase();
                   newFileName = imgCode+"." + fileType;
                   savePath = new File(path+ File.separator +newFileName);
                   // 转存文件
                   file.transferTo(savePath);
                   imgUrl += newFileName;
                }
            }
        }
       
        return imgUrl;
       
		
	}

	
	
}
