package com.vulnverify.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * 读取excel的工具类
 * @author LiWenbin
 *
 */
public class ExcelUtil {
	
	/**
	 * 读取excel，兼容2003和2007
	 * 默认第一行为列头,第二行为数据起始行
	 * @param file
	 * @param modelClass
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> loadData(File file,Map<String,String> fieldMap,Class<T> modelClass) throws Exception{
		InputStream is = null;
		Workbook wb = null;
		try{
			is = new FileInputStream(file);
			wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0);
			int lastRowNum = sheet.getLastRowNum();
			Row row = null;
			int lastCellNum = 0;
			String cellValue = null;
			Cell cell = null;
			List<T> dataList = new ArrayList<T>();
			T data = null;
			ObjectMapper om = new ObjectMapper();
			Map<String,String> dataMap = null;
			for(int i=1;i<=lastRowNum;i++){
				row = sheet.getRow(i);
				if(isRowEmpty(row)){
					continue;
				}
				dataMap = new HashMap<String,String>();
				lastCellNum = row.getLastCellNum();
				for(int j=0;j<=lastCellNum;j++){
					cell = row.getCell(j);
					if(cell != null){
						cellValue = row.getCell(j).toString();
						if(cellValue.endsWith(".0")){
							cellValue = cellValue.substring(0,cellValue.length()-2);
						}
						dataMap.put(fieldMap.get(j+""), cellValue);
					}
				}
				data = om.convertValue(dataMap, modelClass);
				dataList.add(data);
			}
			return  dataList;
		}catch(Exception e){
			throw e;
		}finally{
			if(wb != null){
				wb.close();
			}
			if(is != null){
				is.close();
			}
		}
	}
	
	/**
	 * 判断行是否为空行
	 * @param row
	 * @return
	 */
	public static boolean isRowEmpty(Row row){
		boolean isEmpty = true;
		if(row != null){
			for (int c = row.getFirstCellNum(); c <= row.getLastCellNum(); c++) {
		        Cell cell = row.getCell(c);
		        if (cell != null && !"".equals(cell.toString())){
		        	isEmpty = false;
		        	break;
		        }
		    }
		}
	    return isEmpty;
	}
	
}
