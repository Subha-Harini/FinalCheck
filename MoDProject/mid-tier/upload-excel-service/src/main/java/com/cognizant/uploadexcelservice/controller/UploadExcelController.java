package com.cognizant.uploadexcelservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cognizant.uploadexcelservice.dto.UploadExcelDto;
import com.cognizant.uploadexcelservice.service.UploadExcelService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

@RestController
@RequestMapping("/upload-excel")
public class UploadExcelController {

    private static final Logger logger = LoggerFactory.getLogger(UploadExcelController.class);

    @Autowired
    private UploadExcelService uploadExcelService;

    @PostMapping("/upload")
	 public void UploadFile(MultipartHttpServletRequest request) throws IOException {

       Iterator<String> itr = request.getFileNames();
       MultipartFile file = request.getFile(itr.next());
       String fileName = file.getOriginalFilename();
       File dir = new File("C:\\Users\\Admin\\Desktop\\MoDProject");
       if (dir.isDirectory()) {
         File serverFile = new File(dir, fileName);
         BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
         stream.write(file.getBytes());
         stream.close();
       }
       uploadExcelService.storeFile(dir+"\\"+fileName);
     }
	
	@GetMapping("/summary")
	public UploadExcelDto getSummary() {
		return uploadExcelService.getSummary();
	}
	
	

   
}