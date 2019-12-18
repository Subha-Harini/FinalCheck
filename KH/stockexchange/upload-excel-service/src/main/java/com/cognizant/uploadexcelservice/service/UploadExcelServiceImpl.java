package com.cognizant.uploadexcelservice.service;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.uploadexcelservice.dto.UploadExcelDto;
import com.cognizant.uploadexcelservice.model.StockPrice;
import com.cognizant.uploadexcelservice.repository.CompanyRepository;
import com.cognizant.uploadexcelservice.repository.StockPriceRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@Service
public class UploadExcelServiceImpl implements UploadExcelService {

	
	@Autowired
	private StockPriceRepository stockPriceRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	
	UploadExcelDto uploadExcelDto =  new UploadExcelDto();

	@Override
	public void storeFile(String filePath) throws FileNotFoundException {
		
		int companyCodeDetails = 0;
		
		Date minDate=null;
		Date maxDate=null;
		
		FileInputStream inputStream = new FileInputStream(filePath);
		 
		
		 int count=0;
		 Workbook workbook;
		 
		 try {
				workbook = new XSSFWorkbook(inputStream);
				 Sheet firstSheet = workbook.getSheetAt(0);
		         Iterator<Row> rowIterator = firstSheet.iterator();
		      
	            
		            rowIterator.next();
		            
		while (rowIterator.hasNext()) {

			StockPrice stockPrice = new StockPrice();
			
			Row nextRow = rowIterator.next();
			count = count-1;
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();

				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 0:
			
					int companyCode = (int) nextCell.getNumericCellValue();
					stockPrice.setCompanyCode(companyCode);
					companyCodeDetails = companyCode;
					break;
				case 1:
					String stockExchange = nextCell.getStringCellValue();
					stockPrice.setStockExchange(stockExchange);
					break;
				case 2:
					
					double sharePrice = (double) nextCell.getNumericCellValue();
					stockPrice.setCurrentPrice(sharePrice);
					break;
				case 3:
                	Date date = nextCell.getDateCellValue();
                	if(minDate==null) {
                	minDate = date;}
                	if(maxDate==null) {
                    	maxDate = date;}
                	if(date.compareTo(minDate)<0) {
                		minDate=date;
                		
                	}
                	if(date.compareTo(maxDate)>0) {
                		maxDate=date;
                		
                	}
                	stockPrice.setDate(date);
                	System.out.println("=================>" + date);
                	break;
                case 4:
                	Date time = nextCell.getDateCellValue();               	
                	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                	stockPrice.setTime(Time.valueOf(sdf.format(time)));
                	System.out.println("=================>1212" + Time.valueOf(sdf.format(time)));
          
                	break;
                	default:
                		break;
                }

			}
			if(stockPrice.getCompanyCode() != 0 ) {
                stockPriceRepository.save(stockPrice);}              
               }     
           workbook.close();
           
	} catch (IOException e) {
		e.printStackTrace();
	}

		
		uploadExcelDto.setNoOfRecords(count-1);
		uploadExcelDto.setCompanyName(companyRepository.findById(companyCodeDetails).get().getName());
		uploadExcelDto.setMaxDate(maxDate);
		uploadExcelDto.setMinDate(minDate);
		
		System.out.println(uploadExcelDto);
		
	}
	

	@Override
	public UploadExcelDto getSummary() {
		return uploadExcelDto;
	}
}