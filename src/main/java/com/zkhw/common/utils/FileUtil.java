package com.zkhw.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	
	 public static boolean createDir(String destDirName) {  
	        File dir = new File(destDirName);  
	        if (dir.exists()) {  
	            return true;  
	        }  
	        if (!destDirName.endsWith(File.separator)) {  
	            destDirName = destDirName + File.separator;  
	        }  
	        //创建目录  
	        if (dir.mkdirs()) {  
	            return true;  
	        } else {  
	            return false;  
	        }  
	    }
	 
	   // 复制文件
	    public static void copyFile(File sourceFile, File targetFile) throws IOException {
	        BufferedInputStream inBuff = null;
	        BufferedOutputStream outBuff = null;
	        try {
	            // 新建文件输入流并对它进行缓冲
	            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

	            // 新建文件输出流并对它进行缓冲
	            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

	            // 缓冲数组
	            byte[] b = new byte[1024 * 5];
	            int len;
	            while ((len = inBuff.read(b)) != -1) {
	                outBuff.write(b, 0, len);
	            }
	            // 刷新此缓冲的输出流
	            outBuff.flush();
	        } finally {
	            // 关闭流
	            if (inBuff != null)
	                inBuff.close();
	            if (outBuff != null)
	                outBuff.close();
	        }
	    }
	    
	    
	    // 复制文件夹
	    public static void copyDirectiory(String sourceDir, String targetDir) throws IOException {
	        // 新建目标目录
	        (new File(targetDir)).mkdirs();
	        // 获取源文件夹当前下的文件或目录
	        File[] file = (new File(sourceDir)).listFiles();
	        for (int i = 0; i < file.length; i++) {
	            if (file[i].isFile()) {
	                // 源文件
	                File sourceFile = file[i];
	                // 目标文件
	                File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
	                copyFile(sourceFile, targetFile);
	            }
	            if (file[i].isDirectory()) {
	                // 准备复制的源文件夹
	                String dir1 = sourceDir + "/" + file[i].getName();
	                // 准备复制的目标文件夹
	                String dir2 = targetDir + "/" + file[i].getName();
	                copyDirectiory(dir1, dir2);
	            }
	        }
	    }
	    
	    
	    /**
	     * 
	     * @param filepath
	     * @throws IOException
	     */
	    public static void del(String filepath) throws IOException {
	        File f = new File(filepath);// 定义文件路径
	        if (f.exists() && f.isDirectory()) {// 判断是文件还是目录
	            if (f.listFiles().length == 0) {// 若目录下没有文件则直接删除
	                f.delete();
	            } else {// 若有则把文件放进数组，并判断是否有下级目录
	                File delFile[] = f.listFiles();
	                int i = f.listFiles().length;
	                for (int j = 0; j < i; j++) {
	                    if (delFile[j].isDirectory()) {
	                        del(delFile[j].getAbsolutePath());// 递归调用del方法并取得子目录路径
	                    }
	                    delFile[j].delete();// 删除文件
	                }
	            }
	        }
	    }
}
