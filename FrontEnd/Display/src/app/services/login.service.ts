import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }
  emailId !: any;
  name :string="";
  mobileNo !:any;
  password !:any;
  category !:any;

  userData = {}
  loginObj: { name: string, loginBtnStatus: string } = { name: '', loginBtnStatus: 'Log In' }
  setData(name: string, loginBtnStatus: string) {
    if (loginBtnStatus == 'Log Out') {
      this.loginObj.name = "Welcome, " + name
    } else {
      this.loginObj.name = name
    }
    this.loginObj.loginBtnStatus = loginBtnStatus
  }
  getData() {
    return this.loginObj
  }
  obj(data:any){
    return this.http.post('http://localhost:9090/users/register',data,{responseType:'text'})
  }

  vendor(data:any){
    let formData=new FormData();
    formData.append("vendorName",data.vendorName);
    formData.append("emailId",data.emailId);
    formData.append("mobileNumber",data.mobileNumber);
    formData.append("description",data.description);
    formData.append("password",data.password);
    formData.append("confirmPassword",data.confirmPassword);
    formData.append("image",data.fileToUpload);

    return this.http.post('http://localhost:9090/vendor-api/register',data,{responseType:'text'});
  }
  login(loginCredentials:any){
    return this.http.post('http://localhost:9090/users/Userlogin',loginCredentials,{responseType:'text'})

    .pipe(
      map(user => {

        localStorage.setItem("currentUser",JSON.stringify(user))
        return user;

      })
    )


  }
  loginVendor(loginCredentials:any){
    return this.http.post('http://localhost:9090/vendor-api/Vendorlogin',loginCredentials,{responseType:'text'})

  }

  getUsersData(){
    return this.http.get('http://localhost:9090/users/allusers')
  }
  orderList(){
    return this.http.get('http://localhost:9090/order-api/orders')
  }
vendorId(emailId:any){
  return this.http.get('http://localhost:9090/vendor-api/getdetails/'+emailId)
}
vendormenu(): Observable<any>{
  return this.http.get('http://localhost:9090/food-api/products')
}

}


