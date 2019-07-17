package com.zkhw.common.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class WordToPdf {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

        String docPath = "D:\\test111.docx";
        String pdfPath = "D:\\zkhw.pdf";

        XWPFDocument document;
        InputStream doc = new FileInputStream(docPath);
        document = new XWPFDocument(doc);
        PdfOptions options = PdfOptions.create();
        OutputStream out = new FileOutputStream(pdfPath);
        PdfConverter.getInstance().convert(document, out, options);

        doc.close();
        out.close();

	}
	
	public void word2007ToHtml() throws Exception {
        String filepath = "d:/files/";
        String sourceFileName ="D:\\test222.docx"; 
        String targetFileName = filepath+"1496717486420.html"; 
        //String imagePathStr = filepath+"/image/";  
        OutputStreamWriter outputStreamWriter = null; 
        try { 
          XWPFDocument document = new XWPFDocument(new FileInputStream(sourceFileName)); 
          XHTMLOptions options = XHTMLOptions.create(); 
          // 存放图片的文件夹 
          //options.setExtractor(new FileImageExtractor(new File(imagePathStr))); 
          // html中图片的路径 
          //options.URIResolver(new BasicURIResolver("image")); 
          outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetFileName), "utf-8"); 
          XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance(); 
          xhtmlConverter.convert(document, outputStreamWriter, options); 
        } finally { 
          if (outputStreamWriter != null) { 
            outputStreamWriter.close(); 
          } 
        }
      } 	
	
	public void testTemplateWrite() throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("archiveNo", "③⑦①③②⑦-①②③-③②①-⑤⑦⑥④③①");
        params.put("name", "李四");
        params.put("address", "山东济南");
        params.put("registerAddress", "山东临沂");
        params.put("phone", "13512673249");
        params.put("townsName", "道口镇");
        params.put("villageName", "书院村委会");
        String shortno = "①②③-③②①④⑤";
        params.put("shortno", shortno);
               
        params.put("sex", "①");
        params.put("birthday", "1974-02-25"); 
        params.put("idNumber", "317128199211258555");
        params.put("linkName", "王五");
        params.put("linkPhone", "15821345712");
        params.put("type", "①");
        params.put("nation", "苗族");
        params.put("bg", "①/③");
        params.put("edu", "②");
        params.put("pro", "④");
        params.put("mar", "②");
        params.put("drug", "②/③//");
        params.put("exp", "②/③/");
        params.put("her", "②");
        params.put("def", "②/③////");
        params.put("defo", "ewe");
        params.put("kit", "③");
        params.put("fue", "③");
        params.put("fueo", "其他");
        params.put("dri", "③");
        params.put("drio", "sas");   
        params.put("toi", "①");
        params.put("pou", "④");
        
        //params.put("ast1", "1");

        String filePath = "D:\\test111.docx";
        InputStream is = new FileInputStream(filePath);
        XWPFDocument doc = new XWPFDocument(is);
        //替换段落里面的变量
        this.replaceInPara(doc, params);
        this.replaceInTable(doc, params);
        //替换表格里面的变量
//        this.replaceInTable(doc, params);
        OutputStream os = new FileOutputStream("D:\\test222.docx");
        doc.write(os);

        this.close(os);
        this.close(is);
    }

	   private void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
	        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
	        XWPFParagraph para;

	        while (iterator.hasNext()) {
	            para = iterator.next();
//	            CTPPr pr = para.getCTP().getPPr();
	            this.replaceInPara(para, params);
	        }
	    }

	    private void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
	        List<XWPFRun> runs;
	        Matcher matcher;
	        if (this.matcher(para.getParagraphText()).find()) {
	            runs = para.getRuns();
	            System.out.println("2:"+runs);
	            for (int i=0; i<runs.size(); i++) {
	                XWPFRun run = runs.get(i);
	                String runText = run.toString();
	                System.out.println("runText:" + runText);
	                matcher = this.matcher(runText);
	                if (matcher.find()) {
	                    while ((matcher = this.matcher(runText)).find()) {
	                        runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
	                    }
	                    //直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
	                    //所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。

	                    run.setText(runText,0);
//	                    int fontSize = run.getFontSize();
//	                    String fontFamily = run.getFontFamily();
//	                    para.removeRun(i);
//	                    para.insertNewRun(i).setText(runText);
//	                    para.insertNewRun(i).setFontSize(fontSize);
//	                    para.insertNewRun(i).setFontFamily(fontFamily);
	                }
	            }
	        }
	    }  
	    
	    private void replaceInTable(XWPFDocument doc, Map<String, Object> params) {
	        Iterator<XWPFTable> iterator = doc.getTablesIterator();
	        XWPFTable table;
	        List<XWPFTableRow> rows;
	        List<XWPFTableCell> cells;
	        List<XWPFParagraph> paras;
	        while (iterator.hasNext()) {
	            table = iterator.next();
	            rows = table.getRows();
	            for (XWPFTableRow row : rows) {
	                cells = row.getTableCells();
	                for (XWPFTableCell cell : cells) {
	                    paras = cell.getParagraphs();
	                    for (XWPFParagraph para : paras) {
	                        this.replaceInPara(para, params);
	                    }
	                }
	            }
	        }
	    }

	    private Matcher matcher(String str) {
	        Pattern pattern = Pattern.compile("\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(str);
	        return matcher;
	    }

	    private void close(InputStream is) {
	        if (is != null) {
	            try {
	                is.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    private void close(OutputStream os) {
	        if (os != null) {
	            try {
	                os.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }


}
