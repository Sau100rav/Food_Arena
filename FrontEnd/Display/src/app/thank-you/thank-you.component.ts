import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-thank-you',
  templateUrl: './thank-you.component.html',
  styleUrls: ['./thank-you.component.css']
})
export class ThankYouComponent implements OnInit{
   token:any=undefined

  constructor(private router :Router,private order:LoginService) {

  }
  ngOnInit(): void {
    // sessionStorage.removeItem('cartItems')
  }
  getToken(){
    this.token= sessionStorage.getItem('token')
    console.log("token from thank you ",this.token)
    return this.token
  }
  viewOrderDetail(token:any){
      this.order.orderList().subscribe((data: any) => {
        for(let order of data){
          if (order.orderId.toString() === token.toString()){
            let data={
              is_vendor:false,
              orderss:order
            }
            this.router.navigate(['/order-detail'],{state:{data:data}});
          }
        }

      })
  }




}
