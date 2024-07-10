import { Component,OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-vendorsign',
  templateUrl: './vendorsign.component.html',
  styleUrls: ['./vendorsign.component.css']
})
export class VendorsignComponent implements OnInit {

constructor(private fb:FormBuilder,private router: Router,private http:HttpClient,private login:LoginService) { }
  successMessage: string=""
  errorMessage: string = ""
  showMsg: boolean=false;

  public state:any;
  public url:string="/assets/images/a1.png";
  public fileToUpload:File=new File([],"");
  onFileSelected(event:any){
    const selectedFile=event.target.files[0];
    if(selectedFile){
      this.fileToUpload=selectedFile;
      var reader =new FileReader();
      reader.onload=(e:any)=>{
        this.url=e.target.result;
    };
    reader.readAsDataURL(this.fileToUpload);

   }

  }

  vendorsign:FormGroup=new FormGroup({})
  showTable=false
  type:any;




  ngOnInit(): void {
      this.vendorsign=this.fb.group({
      vendorName:['',[Validators.required,Validators.pattern(/[a-zA-Z]$/)]],
      emailId: ['', [Validators.required, Validators.pattern(/^(.+)@(.+)$/)]],
      mobileNumber:['',[Validators.required, Validators.pattern(/^[0-9]{10}$/)]],
     description:['',[Validators.required, Validators.pattern(/^[aA-zZ]{0,30}$/)]],
      password:['',[Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$@!%&*?])[A-Za-z\d#$@!%&*?]{8,30}$/)]],
      confirmPassword:['',[Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$@!%&*?])[A-Za-z\d#$@!%&*?]{8,30}$/)]],
      image:['',[Validators.required]]
    })


  }

  signVendor(){
    this.errorMessage=this.successMessage;
    console.log("try to submit form");
    console.log("DATA",this.vendorsign.value)

    this.login.vendor(this.vendorsign.value).subscribe((_data)=>{
      this.successMessage="Registration Successfull";
      this.pop()
    this.router.navigate(['/login/vendor'])},
    (error)=>{
      if(error.status==404){this.errorMessage="Data submission failed"};
    console.log(error)
  this.errorMessage="Registration Failed"})
  }
  pop(){
    alert('SignUp Successfull')
  }

  onChange(e:any) {
    this.type= e.target.value;
 }

  }




