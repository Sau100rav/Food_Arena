import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// import { SharedServiceCartItemCountService } from '../shared-service-cart-item-count.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  vendor_list : any
  cart_items: any[]=[]

  constructor(private http : HttpClient){
  }
  ngOnInit(): void {
    sessionStorage.removeItem('selected_vendor_id')
    sessionStorage.removeItem('cart_items')
    sessionStorage.removeItem('cartItems')
    this.http.get('http://localhost:9090/vendor-api/getvendors').subscribe(response=>{
      this.vendor_list = response
      console.log(response)
    })
    let email = sessionStorage.getItem('email')
      console.log(email);
      this.http.get('http://localhost:9090/users/getdetails/'+email).subscribe(response=>{
       let userDetails = response
       console.log("get info response is =>",Object.values(userDetails).at(1))
       sessionStorage.setItem('name',Object.values(userDetails).at(1))


     })

  }
  selected_vendor(vendor_id:any){
    sessionStorage.setItem('selected_vendor_id',vendor_id)
    console.log(vendor_id)
  }
}
