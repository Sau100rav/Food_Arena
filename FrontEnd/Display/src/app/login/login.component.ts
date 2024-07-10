import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from '../services/login.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isVendor:any;
  constructor(private fb: FormBuilder,private router: Router,private route:ActivatedRoute,private login:LoginService,private toastr: ToastrService,private http: HttpClient) {
    this.route.params.subscribe((param: { [x: string]: any; }) => {
      this.isVendor = param['isVendor'];
    }
    )
   }

  usersArray: any = []
  errorMessage: any = ''
  userDetails:any
  email:any
  currentURL:any
  loginForm:FormGroup = new FormGroup({})
  loginSuccessfulFun() {
    throw new Error('Method not implemented.');
  }
  userName =''


  ngOnInit(): void {
    sessionStorage.clear()
    this.loginForm = this.fb.group({
      emailId: ['', [Validators.required, Validators.pattern(/^(.+)@(.+)$/)]],
      password: ['', [Validators.required]]
    })
    this.currentURL=this.router.url;

    // this.login.getUsersData().subscribe((data) => {
    //   this.usersArray = data
    // }, (error) => {

    // })

    this.loginSuccessfulFun = () => {
      if(this.currentURL=="/login/user"){


        this.login.login(this.loginForm.value).subscribe(response=>{console.log(response);
          sessionStorage.setItem('email',this.loginForm.value.emailId)
          this.login.emailId = this.loginForm.value.emailId
          console.log(this.loginForm.value.emailId)
          this.toastr.success('Login Successfull !!', ''); // Success Notification
          this.router.navigate(['/home'])
        },
        error=>{
        this.toastr.error("Invalid Credentials!!!")
          console.log(error);
        });
      }
      else if(this.currentURL=="/login/vendor"){
        this.login.loginVendor(this.loginForm.value).subscribe(response=>{console.log(response);
          sessionStorage.setItem('email',this.loginForm.value.emailId)
          this.login.emailId = this.loginForm.value.emailId
          console.log(this.loginForm.value.emailId)
          this.toastr.success('Login Successfull !!', ''); // Success Notification
          this.router.navigate(['/vendor-myorders'])
        },
        error=>{
        this.toastr.error("Invalid Credentials!!!")
          console.log(error);
        });
      }

      // this.usersArray.find((user: any) => {
      //   if (user.email == this.loginForm.controls['email'].value && user.password == this.loginForm.controls['password'].value) {
      //     this.login.emailId = user.email;
      //     this.router.navigate(['/home2']);


      //     this.login.userData = user //Hold All Data Related To Loged User
      //   } else {
      //     this.errorMessage = "Invalid Credentials!!!"
      //   }
      // })

    }
  }
  loginOnKeyUp(e:any){
    if(e.keyCode === 13){
      this.loginSuccessfulFun()
    }
  }
}

//
