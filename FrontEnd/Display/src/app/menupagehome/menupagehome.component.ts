import { Component , OnInit} from '@angular/core';
 import { SharedServiceCartItemCountService } from '../shared-service-cart-item-count.service';
import { HttpClient } from '@angular/common/http'
import { Timestamp } from 'rxjs';
import { Router, mapToCanActivate } from '@angular/router';

@Component({
  selector: 'app-menupagehome',
  templateUrl: './menupagehome.component.html',
  styleUrls: ['./menupagehome.component.css']
})
export class MenupagehomeComponent implements OnInit{
   products_list: any;
   selected_vendor_list: any[]=[];
   cart_items:any[]=[];


   constructor(private router:Router,private http:HttpClient,private sharedService:SharedServiceCartItemCountService){
   }

   ngOnInit():void{
    // sessionStorage.removeItem('cartItems')
    this.cart_items = JSON.parse(sessionStorage.getItem('cartItems') || '[]');
    this.http.get('http://localhost:9090/food-api/products',{}).subscribe(response=>{
      this.products_list = response;
      for(let product of this.products_list){
          if(product.vendor_id == sessionStorage.getItem('selected_vendor_id')){
            this.selected_vendor_list.push(product)

          }
      }
      this.sharedService.cartItemCount=this.cart_items.length;

      console.log(this.products_list)
      console.log(this.selected_vendor_list)
    })
   }
  //  incrementCartItemCount(){
  //   this.cartItemCountService.cartItemCount=this.cartItemCountService.cartItemCount+1;
  //  }

   getEstimatedTime(time:string){
      const timestamp = Date.parse(time)
      const date = new Date(timestamp)
      return date.getMinutes();

   }
   addToCart(productId:any){
              console.log(productId)
            for(let cart_item of this.products_list)
            {
              if(productId==cart_item.productId){



                this.cart_items.push(cart_item);
                sessionStorage.setItem('cartItems',JSON.stringify(this.cart_items))

              }
            }
             console.log("cart-items",this.cart_items);
             this.sharedService.cartItemCount=this.sharedService.cartItemCount+1;

   }
   sendToCart(){
    // console.log(this.cart_items)
    sessionStorage.setItem('cartItems',JSON.stringify(this.cart_items));
    this.router.navigate(['/checkout'])

   }
   itemQuantity(id:any){
      let quantity = 0
      for(let item of this.cart_items){
        if (item.productId === id)
        {
          quantity= quantity +1
        }
      }
      console.log("quantity = ", quantity)
      return quantity;

   }

   removeFromCart(id:any){
    let index=0
     for(let item of this.cart_items){
      if (item.productId === id){
        this.cart_items.splice(index,1)
        break;
       }
       index=index+1
     }

    this.sharedService.cartItemCount=this.sharedService.cartItemCount-1;
    sessionStorage.setItem('cartItems',JSON.stringify(this.cart_items))
   }

   getMaxQuantity(id:any,maxQty:any){
    console.log("max",maxQty)
    let quantity=this.itemQuantity(id)
    if(quantity<maxQty){
      return true;
    } else{
      return false;
    }

  }

}

