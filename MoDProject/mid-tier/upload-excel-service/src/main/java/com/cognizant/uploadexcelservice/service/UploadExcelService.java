package com.cognizant.uploadexcelservice.service;

import java.io.FileNotFoundException;

import com.cognizant.uploadexcelservice.dto.UploadExcelDto;

public interface UploadExcelService {
	
	public UploadExcelDto getSummary();
	 public void storeFile(String file) throws FileNotFoundException;

}
