import { Component, OnInit } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { AuthenticationService } from 'src/app/site/authentication.service';
import { AdminFileUploadService } from '../admin-file-upload.service';

@Component({
  selector: 'app-admin-file-upload',
  templateUrl: './admin-file-upload.component.html',
  styleUrls: ['./admin-file-upload.component.css']
})
export class AdminFileUploadComponent implements OnInit {
  uploadFlag:boolean=false;
  apiEndPoint = "http://localhost:8083/upload-excel-service/upload-excel/upload";
  summary: any;
  constructor(private http:HttpClient, private authenticateService: AuthenticationService,private uploadExcelService:AdminFileUploadService) { }

  ngOnInit() {
    
  }

  fileChange(event) {
    let fileList: FileList = event.target.files;
    if (fileList.length > 0) {
      let file: File = fileList[0];
      let formData: FormData = new FormData();
      formData.append('uploadFile', file, file.name);
      let token = "Bearer "+ this.authenticateService.getToken();
      const httpOption = { 
        headers : new HttpHeaders({
          'Content-Type' : 'multipart/form-data; boundary=----WebKitFormBoundaryJ6Q2VG5TMUfGoSqg',
          'Authorization': token})};
      this.http.post(this.apiEndPoint, formData).subscribe(
              (response)=>this.uploadFlag =true
        
        )
    }
    this.uploadExcelService.showSummary().subscribe((response) =>{
      console.log(response);
      this.summary = response;
    })
  }

  back(){
    this.uploadFlag =false;
  }
}
