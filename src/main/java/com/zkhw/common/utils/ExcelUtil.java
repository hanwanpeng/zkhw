package com.zkhw.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zkhw.framework.utils.MathUtils;
import com.zkhw.framework.utils.StringUtils;

/**
 * excel操作工具
 * @author houmeng
 *
 */
public class ExcelUtil {
	//配置项属性
	private String selectedSheetName = "";	//设定操作的sheet的名称
    private int selectedSheetIdx =0;	//设定操作的sheet在索引值
	private int endReadPos = 0;	//读取到倒数第几行，默认为0，用负数来表示倒数第n行( 取值<=0 )
    private int startReadPos = 0;	//设定开始读取的位置，默认为0
    
    /**
     * excel读取示例
     */
	public static void main(String[] args) throws Exception{
		//获取数据
		ExcelUtil excelutil = new ExcelUtil();
		excelutil.setSelectedSheetIdx(0);
		excelutil.setStartReadPos(0);
		List<List<String>> rowList = excelutil.readExcel("d:\\3333\\data.xls");
		
		System.out.println( rowList.get(1) );
	}
	
	/**
	 * 写excel 
	 * @param headerList 表头
	 * @param rowList 行内容
	 * @param xlsPath 文件完整路径
	 * @param sheetName  工作表名称
	 * @throws IOException
	 */
    public void writeExcel(List<String> headerList, List<List<String>> rowList, String xlsPath, String sheetName) throws IOException {  
        if (xlsPath == null || xlsPath.equals("")) {  
            throw new IOException("文件路径不能为空");  
        }
        // 判断列表是否有数据，如果没有数据，则返回   
        if (rowList == null || rowList.size() == 0) {  
            return;  
        }
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);
		//表头
		HSSFRow headerRow = sheet.createRow(0);
		for (int i=0; i<headerList.size(); i++) {
			HSSFCell cell = headerRow.createCell(i);
			cell.setCellValue( headerList.get(i) );
		}
		//行数据
		int _row=1;
		for( List<String> list : rowList ){
			HSSFRow row = sheet.createRow(_row);
			//输出本行各单元格
			for(int cellIndex=0; cellIndex<list.size(); cellIndex++){
				Cell cell=row.createCell(cellIndex);
				cell.setCellValue(list.get(cellIndex));
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			}
			_row++;
		}
		//生成Excel
		OutputStream os=new FileOutputStream(xlsPath);
		wb.write(os);
		wb.close();
    }

    
	/**
	 * 写excel到输出流,用于内存操作不生成实际文件 的情况 
	 * @param headerList 表头
	 * @param rowList 行内容
	 * @param xlsPath 文件完整路径
	 * @param sheetName  工作表名称
	 * @throws IOException
	 */
    public void writeExcel(List<String> headerList, List<List<String>> rowList, OutputStream outputStream, String sheetName) throws IOException { 
    	if(outputStream==null){
    		return;
    	}
        // 判断列表是否有数据，如果没有数据，则返回   
        //if (rowList == null || rowList.size() == 0) {  
        //    return;  
        //}
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);
		//表头
		HSSFRow headerRow = sheet.createRow(0);
		for (int i=0; i<headerList.size(); i++) {
			HSSFCell cell = headerRow.createCell(i);
			cell.setCellValue( headerList.get(i) );
		}
		//行数据
		int _row=1;
		if(rowList!=null){
			for( List<String> list : rowList ){
				HSSFRow row = sheet.createRow(_row);
				//输出本行各单元格
				for(int cellIndex=0; cellIndex<list.size(); cellIndex++){
					Cell cell=row.createCell(cellIndex);
					cell.setCellValue(list.get(cellIndex));
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				}
				_row++;
			}
		}
		//输出Excel到输出流
		wb.write(outputStream);
		outputStream.flush();
		wb.close();
    }
    
	/**
	 * 写excel到输出流,用于内存操作不生成实际文件 的情况
	 * 数据量大时创建多个sheet
	 * @param headerList 表头
	 * @param rowList 行内容
	 * @param xlsPath 文件完整路径
	 * @param sheetName  工作表名称
	 * @throws IOException
	 */
    public void writeExcelWithMultiSheet(List<String> headerList, List<List<String>> rowList, OutputStream outputStream, String sheetName) throws IOException { 
    	if(outputStream==null){
    		return;
    	}
        // 判断列表是否有数据，如果没有数据，则返回   
        //if (rowList == null || rowList.size() == 0) {  
        //    return;  
        //}
        HSSFWorkbook wb = new HSSFWorkbook();
        
        int sheetMax = 60000; //每个sheet页最多几条数据
        int sheetCount = 0;
        if( rowList.size()%sheetMax==0 ){
        	sheetCount = rowList.size()/sheetMax;
        }else{
        	sheetCount = rowList.size()/sheetMax + 1;
        }
    	
        for(int sheetIndex=1; sheetIndex<=sheetCount; sheetIndex++){
        	HSSFSheet sheet = wb.createSheet(sheetName+"-"+sheetIndex);
        	//表头
        	HSSFRow headerRow = sheet.createRow(0);
        	for (int i=0; i<headerList.size(); i++) {
        		HSSFCell cell = headerRow.createCell(i);
        		cell.setCellValue( headerList.get(i) );
        	}

        	//行数据
        	int _row=1;
        	if(rowList!=null){
        		int start = (sheetIndex-1)*sheetMax;
        		int end = start + sheetMax -1;
        		if( sheetIndex==sheetCount ){ //最后一页 110-100-1
        			end = start + (rowList.size() - (sheetIndex-1)*sheetMax -1);
        		}
        		
        		for(int j=start; j<=end; j++){
        			List<String> list = rowList.get(j);
        			HSSFRow row = sheet.createRow(_row);
        			//输出本行各单元格
        			for(int cellIndex=0; cellIndex<list.size(); cellIndex++){
        				Cell cell=row.createCell(cellIndex);
        				cell.setCellValue(list.get(cellIndex));
        				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        			}
        			_row++;
        		}
        	}
        }
		
		
		//输出Excel到输出流
		wb.write(outputStream);
		outputStream.flush();
		wb.close();
    }
    
    /**
	 * 写excel到输出流,用于内存操作不生成实际文件 的情况
	 * 数据量大时创建多个sheet
	 * @param headerList 表头
	 * @param rowList 行内容
	 * @param xlsPath 文件完整路径
	 * @param sheetName  工作表名称
	 * @throws IOException
	 */
    public void writeExcelStyleWithMultiSheet(List<String> headerList, List<List<String>> rowList, OutputStream outputStream, String sheetName,Double temHigh,Double temLow) throws IOException { 
    	if(outputStream==null){
    		return;
    	}
        // 判断列表是否有数据，如果没有数据，则返回   
        //if (rowList == null || rowList.size() == 0) {  
        //    return;  
        //}
        HSSFWorkbook wb = new HSSFWorkbook();
        
        int sheetMax = 60000; //每个sheet页最多几条数据
        int sheetCount = 0;
        if( rowList.size()%sheetMax==0 ){
        	sheetCount = rowList.size()/sheetMax;
        }else{
        	sheetCount = rowList.size()/sheetMax + 1;
        }
    	
        //设置单元格红色字体样式
        HSSFCellStyle style = wb.createCellStyle();
        HSSFFont font=wb.createFont();
        font.setColor(HSSFColor.RED.index);//HSSFColor.VIOLET.index //字体颜色
        font.setFontHeightInPoints((short)12);
        font.setBold(true);;         //字体增粗
         //把字体应用到当前的样式
         style.setFont(font);
       
         String cellValue = "";
         Float  cellVal = 0f;
         boolean isNumber = false;
        
        
        for(int sheetIndex=1; sheetIndex<=sheetCount; sheetIndex++){
        	HSSFSheet sheet = wb.createSheet(sheetName+"-"+sheetIndex);
        	//表头
        	HSSFRow headerRow = sheet.createRow(0);
        	for (int i=0; i<headerList.size(); i++) {
        		HSSFCell cell = headerRow.createCell(i);
        		cell.setCellValue( headerList.get(i) );
        	}

        	//行数据
        	int _row=1;
        	if(rowList!=null){
        		int start = (sheetIndex-1)*sheetMax;
        		int end = start + sheetMax -1;
        		if( sheetIndex==sheetCount ){ //最后一页 110-100-1
        			end = start + (rowList.size() - (sheetIndex-1)*sheetMax -1);
        		}
        		
        		for(int j=start; j<=end; j++){
        			List<String> list = rowList.get(j);
        			HSSFRow row = sheet.createRow(_row);
        			//输出本行各单元格
        			for(int cellIndex=0; cellIndex<list.size(); cellIndex++){
        				Cell cell=row.createCell(cellIndex);
        				cellValue = list.get(cellIndex);
        				cell.setCellValue(list.get(cellIndex));
        				isNumber = StringUtils.isNumeric(cellValue );
        				if( isNumber){  //数字
        					cellVal = Float.valueOf(cellValue);
        					if( cellVal >= temHigh || cellVal <= temLow){
        						cell.setCellStyle(style);
        					}else{
        						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        					}
        				}else{
        					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        				}
        			}
        			_row++;
        		}
        	}
        }
		
		
		//输出Excel到输出流
		wb.write(outputStream);
		outputStream.flush();
		wb.close();
    }
    
 
    
	  /** 
     * 自动根据文件扩展名，判断excel格式,调用对应的读取方法 
     */  
    public List<List<String>> readExcel(String xlsPath) throws IOException{  
        //扩展名为空时，   
        if (xlsPath.equals("")){  
            throw new IOException("文件路径不能为空！");  
        }else{  
            File file = new File(xlsPath);  
            if(!file.exists()){  
                throw new IOException("文件不存在:" + xlsPath);  
            }  
        }  
        //获取扩展名   
        String ext = xlsPath.substring(xlsPath.lastIndexOf(".")+1);  
        try {  
            if("xls".equals(ext)){              //使用xls方式读取   
                return readExcel_xls(xlsPath);  
            }else if("xlsx".equals(ext)){       //使用xlsx方式读取   
                return readExcel_xlsx(xlsPath);  
            }else{                                  //依次尝试xls、xlsx方式读取   
                try{  
                    return readExcel_xls(xlsPath);  
                } catch (IOException e1) {
                	e1.printStackTrace();
                    try{  
                        return readExcel_xlsx(xlsPath);  
                    } catch (IOException e2) {  
                        e2.printStackTrace();
                        throw e2;  
                    }  
                }  
            }  
        } catch (IOException e) {  
            throw e;  
        }  
    }  	

	/*** 
     * 读取Excel(97-03版，xls格式) 
     */  
    public List<List<String>> readExcel_xls(String xlsPath) throws IOException {  
        // 判断文件是否存在   
        File file = new File(xlsPath);  
        if (!file.exists()) {  
            throw new IOException("文件名为" + file.getName() + "Excel文件不存在:" + xlsPath);  
        }  
  
        HSSFWorkbook wb = null;// 用于Workbook级的操作，创建、删除Excel   
        List<List<String>> rowList = new ArrayList<List<String>>();  
        try {  
            // 读取Excel   
            wb = new HSSFWorkbook(new FileInputStream(file));  
            // 读取Excel 97-03版，xls格式 (HSSFWorkbook)
            rowList = readExcel(wb);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return rowList;  
    }  
    
	/** 
     * 读取Excel 2007版，xlsx格式  
     */  
    public List<List<String>> readExcel_xlsx(String xlsPath) throws IOException {  
        // 判断文件是否存在   
        File file = new File(xlsPath);  
        if (!file.exists()) {  
            throw new IOException("文件名为" + file.getName() + "Excel文件不存在:" + xlsPath);  
        }  
  
        XSSFWorkbook wb = null;  
        List<List<String>> rowList = new ArrayList<List<String>>();  
        try {  
            FileInputStream fis = new FileInputStream(file);  
            // 去读Excel   
            wb = new XSSFWorkbook(fis);  
            // 读取Excel 2007版，xlsx格式  (XSSFWorkbook)
            rowList = readExcel(wb);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return rowList;  
    }
    
    /** 
     * 通用读取Excel
     */  
    private List< List<String> > readExcel(Workbook wb) {  
    	List< List<String> > rowList = new ArrayList<List<String>>();  
        Sheet sheet = null;  
        
        // 获取设定操作的sheet(如果设定了名称，按名称查，否则按索引值查)   
        sheet =selectedSheetName.equals("")? wb.getSheetAt(selectedSheetIdx):wb.getSheet(selectedSheetName);
        if(sheet==null){
        	return null;
        }
        //获取最后行号   
        int lastRowNum = sheet.getLastRowNum();  
        Row row = null;  
        // 循环读取   
        for (int i = startReadPos; i <= lastRowNum + endReadPos; i++) {  
            row = sheet.getRow(i);  
            if (row != null) {  
            	List<String> _list = new ArrayList<String>(); 
                 // 获取每一单元格的值   
                 for (int j = 0; j < row.getLastCellNum(); j++) { 
                	 String value = null;
                	 Cell cell = row.getCell(j);
                	 if(cell==null){
                		 _list.add(null);
                	 }else{
                		 if( cell.getCellType() == Cell.CELL_TYPE_NUMERIC ){
                			 if( HSSFDateUtil.isCellDateFormatted(cell) ){
                				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                				 value = sdf.format( cell.getDateCellValue() );
                			 }else{
                				 double d = cell.getNumericCellValue();
                				 value = MathUtils.formatDouble2(d);
                			 }
                		 }else{
                			 value = getCellValue(row.getCell(j));
                		 }
                		 _list.add(value);
                	 }
                 } 
                 rowList.add(_list);
            }  
        }  
        return rowList;  
    }
    
    /*** 
     * 读取单元格的值 
     */  
    private String getCellValue(Cell cell) {
    	FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
        Object result = "";  
        if (cell != null) {  
            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:  
                result = cell.getStringCellValue();  
                break;  
            case Cell.CELL_TYPE_NUMERIC:  
                result = cell.getNumericCellValue();
                if(result!=null){
                	DecimalFormat df = new DecimalFormat("0.00");//使用DecimalFormat类对科学计数法格式的数字进行格式化
                	result = df.format( result );
                }
                break;  
            case Cell.CELL_TYPE_BOOLEAN:  
                result = cell.getBooleanCellValue();  
                break;  
            case Cell.CELL_TYPE_FORMULA:  
            	//hm excel表达式处理
                CellValue cellValue = evaluator.evaluate(cell);
				switch (cellValue.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					result = cellValue.getBooleanValue();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					result = cellValue.getNumberValue();
					break;
				case Cell.CELL_TYPE_STRING:
					result = cellValue.getStringValue();
					break;
				case Cell.CELL_TYPE_BLANK:
					result = "";
					break;
				case Cell.CELL_TYPE_ERROR:
					result = "";
					break;
				}
                break;  
            case Cell.CELL_TYPE_ERROR:  
                result = cell.getErrorCellValue();  
                break;  
            case Cell.CELL_TYPE_BLANK:  
                break;  
            default:  
                break;  
            }  
        }  
        return result.toString();  
    }  

	/**
	 * 设置要读取的工作表名称
	 * @param selectedSheetName
	 */
	public void setSelectedSheetName(String selectedSheetName) {
		this.selectedSheetName = selectedSheetName;
	}
	public String getSelectedSheetName() {
		return selectedSheetName;
	}

	/**
	 * 设置要读取的sheet的下标(0-第1张表)
	 * @param selectedSheetIdx
	 */
	public void setSelectedSheetIdx(int selectedSheetIdx) {
		this.selectedSheetIdx = selectedSheetIdx;
	}
	public int getSelectedSheetIdx() {
		return selectedSheetIdx;
	}

	/**
	 * 设置读取到倒数第几行
	 * @param endReadPos
	 */
	public void setEndReadPos(int endReadPos) {
		this.endReadPos = endReadPos;
	}
	public int getEndReadPos() {
		return endReadPos;
	}


	/**
	 * 设置从第几行开始读取(0-第1行)
	 * @param startReadPos
	 */
	public void setStartReadPos(int startReadPos) {
		this.startReadPos = startReadPos;
	}
	public int getStartReadPos() {
		return startReadPos;
	}    
	
	/**
	 * 读取Excel
	 * @param name  文件名称
	 * @param inputStream
	 * @return
	 * @throws IOException
	 * @author hm
	 */
    public List< List<String> > readExcel(String name,InputStream inputStream) throws IOException {  
    	 //获取扩展名   
        String ext = name.substring(name.lastIndexOf(".")+1);
        List<List<String>> rowList = new ArrayList<List<String>>();  
    	if( "xls".equals(ext) ){  //2007版以前office
    		HSSFWorkbook wb = new HSSFWorkbook(inputStream);
    		rowList = readExcel(wb);  
    	}else{//2007版及以后office
    		 XSSFWorkbook wb = new XSSFWorkbook(inputStream);
    		 rowList = readExcel(wb); 
    	}
    	return rowList;
    }
    
   
	
}
