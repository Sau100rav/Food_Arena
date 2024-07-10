import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from '../services/login.service';
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupForm:FormGroup=new FormGroup({})
  showTable=false
  type:any;



  constructor(private login:LoginService,private fb:FormBuilder,private router: Router,private http:HttpClient) { }
  successMessage: string=""
  errorMessage: string = ""
  showMsg: boolean=false;

  public state:any;
  ngOnInit(): void {
      this.signupForm=this.fb.group({
      name:['',[Validators.required,Validators.pattern(/[a-zA-Z]$/)]],
      emailId: ['', [Validators.required, Validators.pattern(/^(.+)@(.+)$/)]],
      mobileNo:['',[Validators.required, Validators.pattern(/^[0-9]{10}$/)]],
      password:['',[Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$@!%&*?])[A-Za-z\d#$@!%&*?]{8,30}$/)]],
      confirmPassword:['',[Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$@!%&*?])[A-Za-z\d#$@!%&*?]{8,30}$/)]]
    })


  }


  submitData(){
    this.errorMessage=this.successMessage;
    console.log("try to submit form");
    console.log("DATA",this.signupForm.value)
    this.login.obj(this.signupForm.value).subscribe((_data)=>{
      this.successMessage="Registration Successfull";
      this.pop()
    this.router.navigate(['/login/user'])},
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



