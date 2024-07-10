import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { SharedServiceCartItemCountService } from '../shared-service-cart-item-count.service';
import { Food } from '../shared/models/Food';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  navbarOpen=false;
  cart_item_list :Food[]=[];
  cart_list_string: String='';
  cart_item_count:any=0;

  constructor(private router:Router, public sharedService:SharedServiceCartItemCountService){

  }
  ngOnInit(): void {
    this.cart_item_count=JSON.parse(sessionStorage.getItem('cartItems') || '[]').length;
    console.log(this.cart_item_count)
  }
  toggleNavbar(){
    this.navbarOpen=!this.navbarOpen;
  }
  is_cart_items_exist(){
    return Boolean(sessionStorage.getItem('cart_items'))
  }
  get_url(){
         console.log(this.router.url)
          return (this.router.url.includes('/menupagehome'));

  }

  get_cart_item_count(){
    return JSON.parse(sessionStorage.getItem('cart_items') || '[]').length;
  }

  checkUrl(){
    return Boolean((!(this.router.url.includes('/my-orders')) && sessionStorage.getItem('email') )&& !(this.router.url.includes('/vendor-myorders')))
  }

   checkLogout(){
    return Boolean(sessionStorage.getItem('email'))
   }

   logoClick(){
    if(sessionStorage.getItem('email') == undefined){
      this.router.navigateByUrl('/first')
    }
    else{
      this.router.navigateByUrl('/home')
    }
   }

}
