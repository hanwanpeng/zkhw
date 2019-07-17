package com.zkhw.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfUtils {

	public void createPdf(List<List<String>> rowList, OutputStream out, List<String> headerList, String deviceNum,
			String startTime, String endTime, String high, String low, Image jpeg) {

		try {

			// Create Document Instance
			Document document = new Document();
			// add Chinese font
			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

			// Font headfont=new Font(bfChinese,10,Font.BOLD);
			Font keyfont = new Font(bfChinese, 14, Font.NORMAL);
			Font textfont = new Font(bfChinese, 10, Font.NORMAL);

			// Create Writer associated with document
			/*
			 * File savePath = new File("E:\\POReceiveReport.pdf"); if
			 * (!savePath.exists()) { savePath.createNewFile(); }
			 */
			PdfWriter.getInstance(document, out);
			document.addTitle(deviceNum);
			document.open();

			// Seperate Page controller
			// int recordPerPage=10;
			// int fullPageRequired=rowList.size()/recordPerPage;
			// int remainPage=rowList.size()%recordPerPage>1?1:0;
			// int totalPage=fullPageRequired+remainPage;

			// for(int j=0;j<totalPage;j++){
			// document.newPage();

			// create page number
			// String pageNo=leftPad("页码: "+(j+1)+" / "+totalPage,615);
			// Paragraph pageNumber=new Paragraph(pageNo, keyfont) ;
			// document.add(pageNumber);

			// header information
			PdfPTable tHeader = new PdfPTable(2);
			tHeader.setWidthPercentage(100);
			// float[] widthsHeader={3f,3f};
			// tHeader.setWidths(widthsHeader);
			int[] widthheads = { 50, 50 };
			tHeader.setWidths(widthheads);
			tHeader.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

			PdfPCell c1Header = new PdfPCell(new Paragraph("设备编号: " + deviceNum, keyfont));
			tHeader.addCell(c1Header);
			c1Header = new PdfPCell(new Paragraph("", keyfont));
			tHeader.addCell(c1Header);
			c1Header = new PdfPCell(new Paragraph("开始时间: " + startTime, keyfont));
			tHeader.addCell(c1Header);
			c1Header = new PdfPCell(new Paragraph("结束时间: " + endTime, keyfont));
			tHeader.addCell(c1Header);
			c1Header = new PdfPCell(new Paragraph("最高温度: " + high, keyfont));
			tHeader.addCell(c1Header);
			c1Header = new PdfPCell(new Paragraph("最低温度: " + low, keyfont));
			tHeader.addCell(c1Header);
			document.add(tHeader);

			// record header field
			PdfPTable t = new PdfPTable(headerList.size());
			t.setWidthPercentage(100);
			// float[] widths={1.5f,0.5f,4f};
			// t.setWidths(widths);
			int[] width = { 18, 10, 72 };
			t.setWidths(width);
			t.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
			for (int i = 0; i < headerList.size(); i++) {
				PdfPCell c1 = new PdfPCell(new Paragraph(headerList.get(i), keyfont));
				// c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				t.addCell(c1);
			}

			// create title image
			if (jpeg != null) {
				jpeg.setAlignment(Image.ALIGN_CENTER);
				jpeg.scaleAbsolute(600, 300);
				document.add(jpeg);
			}

			// calculate the real records within a page ,to calculate the last
			// record number of every page
			// int maxRecordInPage= j+1 ==totalPage ?
			// (remainPage==0?recordPerPage:(rowList.size()%recordPerPage)):recordPerPage;

			for (int i = 0; i < rowList.size(); i++) {
				List<String> cols = rowList.get(i);
				for (int n = 0; n < cols.size(); n++) {
					PdfPCell c2 = new PdfPCell(new Paragraph(cols.get(n), textfont));
					if (n != (cols.size() - 1)) {
						c2.setHorizontalAlignment(Element.ALIGN_CENTER);
					}
					t.addCell(c2);
				}
			}
			document.add(t);
			out.flush();
			// }
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String leftPad(String str, int i) {
		int addSpaceNo = i - str.length();
		String space = "";
		for (int k = 0; k < addSpaceNo; k++) {
			space = " " + space;
		}
		;
		String result = space + str;
		return result;
	}

	// 利用模板生成pdf
	@SuppressWarnings("unchecked")
	public static void pdfout(Map<String, Object> o) {
		// 模板路径
		String templatePath = "d:/testpdf.pdf";
		// 生成的新文件路径
		String newPDFPath = "d:/testout1.pdf";

		PdfReader reader;
		FileOutputStream out;
		ByteArrayOutputStream bos;
		PdfStamper stamper;
		try {
			
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			//Font FontChinese = new Font(bf, 5, Font.NORMAL);
			out = new FileOutputStream(newPDFPath);// 输出流
			reader = new PdfReader(templatePath);// 读取pdf模板
			bos = new ByteArrayOutputStream();
			stamper = new PdfStamper(reader, bos);
			AcroFields form = stamper.getAcroFields();
			// 文字类的内容处理
			Map<String, String> datemap = (Map<String, String>) o.get("datemap");
			form.addSubstitutionFont(bf);
			for (String key : datemap.keySet()) {
				String value = datemap.get(key);
				form.setField(key, value);
			}
			// 图片类的内容处理
			Map<String, String> imgmap = (Map<String, String>) o.get("imgmap");
			for (String key : imgmap.keySet()) {
				String value = imgmap.get(key);
				String imgpath = value;
				int pageNo = form.getFieldPositions(key).get(0).page;
				Rectangle signRect = form.getFieldPositions(key).get(0).position;
				float x = signRect.getLeft();
				float y = signRect.getBottom();
				// 根据路径读取图片
				Image image = Image.getInstance(imgpath);
				// 获取图片页面
				PdfContentByte under = stamper.getOverContent(pageNo);
				// 图片大小自适应
				image.scaleToFit(signRect.getWidth(), signRect.getHeight());
				// 添加图片
				image.setAbsolutePosition(x, y);
				under.addImage(image);
			}
			stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
			stamper.close();
			Document doc = new Document();
			//Font font = new Font(bf, 32);
			PdfCopy copy = new PdfCopy(doc, out);
			doc.open();
			PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
			copy.addPage(importPage);
			doc.close();

		} catch (IOException e) {
			System.out.println(e);
		} catch (DocumentException e) {
			System.out.println(e);
		}

	}

	@SuppressWarnings("unchecked")
	public void createPdf(OutputStream out,Map<String, Object> o,String templatePath){


		PdfReader reader;
		ByteArrayOutputStream bos;
		PdfStamper stamper;
		try {
			
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			//Font FontChinese = new Font(bf, 5, Font.NORMAL);
			reader = new PdfReader(templatePath);// 读取pdf模板
			int pages = reader.getNumberOfPages();
			bos = new ByteArrayOutputStream();
			stamper = new PdfStamper(reader, bos);
			AcroFields form = stamper.getAcroFields();
			// 文字类的内容处理
			Map<String, String> datemap = (Map<String, String>) o.get("datemap");
			form.addSubstitutionFont(bf);
			for (String key : datemap.keySet()) {
				String value = datemap.get(key);
				form.setField(key, value);
			}
			// 图片类的内容处理
			Map<String, String> imgmap = (Map<String, String>) o.get("imgmap");
			for (String key : imgmap.keySet()) {
				String value = imgmap.get(key);
				String imgpath = value;
				int pageNo = form.getFieldPositions(key).get(0).page;
				Rectangle signRect = form.getFieldPositions(key).get(0).position;
				float x = signRect.getLeft();
				float y = signRect.getBottom();
				// 根据路径读取图片
				Image image = Image.getInstance(imgpath);
				// 获取图片页面
				PdfContentByte under = stamper.getOverContent(pageNo);
				// 图片大小自适应
				image.scaleToFit(signRect.getWidth(), signRect.getHeight());
				// 添加图片
				image.setAbsolutePosition(x, y);
				under.addImage(image);
			}
			stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
			stamper.close();
			Document doc = new Document();
			//Font font = new Font(bf, 32);
			PdfCopy copy = new PdfCopy(doc, out);
			doc.open();
			for(int i = 1; i <= pages; i++){
				PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), i);
				copy.addPage(importPage);
			}
			out.flush();
			doc.close();

		} catch (IOException e) {
			System.out.println(e);
		} catch (DocumentException e) {
			System.out.println(e);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap();
		map.put("no1", "1");
		map.put("no2", "3");
		map.put("no3", "5");


		Map<String, String> map2 = new HashMap();
		//map2.put("img", "c:/50336.jpg");

		Map<String, Object> o = new HashMap();
		o.put("datemap", map);
		o.put("imgmap", map2);
		pdfout(o);
	}

}
