import { HttpClient} from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SharedServiceCartItemCountService } from '../shared-service-cart-item-count.service';
//import { NONE_TYPE, Token } from '@angular/compiler';



@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})

export class CheckoutComponent implements OnInit {

  finalCart:any[]=[];
  item_quantity_map:Map<any,any>=new Map<any,any>();
  constructor(public http:HttpClient, public router:Router,private sharedService:SharedServiceCartItemCountService) {

  }


  ngOnInit(): void {
    this.finalCart=JSON.parse(sessionStorage.getItem('cartItems') || '[]');
    console.log(this.finalCart)
    for(let items of this.finalCart){
      const currentValue=this.item_quantity_map.get(items.productId)
      if(currentValue !== undefined)
      {
        this.item_quantity_map.set(items.productId,currentValue+1)
      }
      else{
        this.item_quantity_map.set(items.productId,1)
      }


    }

    this.finalCart=this.finalCart.filter(
      (object,index,self)=>index===self.findIndex(
          (o)=>JSON.stringify(o)===JSON.stringify(object)
      )
    )
    console.log(this.finalCart);
    this.sharedService.cartItemCount=this.showTotalItems()
  }
  getQuantity(id:any){
    let quantity=this.item_quantity_map.get(id);
    return quantity;
   }

  removeFromCart(id:any){
    this.finalCart=this.finalCart.filter(item=>item.productId !== id)
    this.item_quantity_map.delete(id)

  }



  addProduct(id:any){
    let quantity=this.item_quantity_map.get(id)
    this.item_quantity_map.set(id,quantity+1)

  }
  removeProduct(id:any){
    let quantity=this.item_quantity_map.get(id)
    this.item_quantity_map.set(id,quantity-1)

  }
  showPrice(id:any){
   let quantity =  this.getQuantity(id)
   let price = 0;
   for(let item of this.finalCart){
      if (item.productId === id){
        price = item.price
      }
   }
   return (quantity*price)
  }

  totalPrice(){
    let total_price=0;
    for(let items of this.finalCart){
      total_price = total_price+ this.showPrice(items.productId)

    }
    return total_price;
  }
  showTotalItems(){
    let totalItems=0;
    for(const [key , value]  of this.item_quantity_map.entries() ){
      totalItems=totalItems+value
    }
    return totalItems;
  }




async placeOrder(){


    let cart:any[] = []

    const email=sessionStorage.getItem('email')
    const totalPrice=this.totalPrice();
    const customerName=sessionStorage.getItem('name')
    console.log(customerName)
    const vendor_id = sessionStorage.getItem('selected_vendor_id')
    for(let items of this.finalCart){
      const product_name=items.name
      const product_quantity=this.getQuantity(items.productId)
      const productId=items.productId
      const productPrice=items.price

      const cartItem={productName:product_name,quantity:product_quantity,productId:productId,productPrice:productPrice,}
      cart.push(cartItem)
    }
    const product_request={customerEmailId:email,customerName:customerName,totalPrice:totalPrice,vendorNo:vendor_id,orderedProducts:cart}
    console.log(product_request)


   try{
    // let response:string|undefined=undefined
     var response = await this.http.post("http://localhost:9090/order-api/placeOrder",product_request).toPromise()

      console.log('response', response)

      sessionStorage.removeItem('token')
      if(response!==undefined)
       sessionStorage.setItem('token',response.toString())


    } catch(error){

      console.log("error",error);

    }





  this.router.navigateByUrl("/thank-you")

  }

  getMaxQuantity(id:any,maxQty:any){
    let quantity=this.getQuantity(id)
    if(quantity<maxQty){
      return true;
    } else{
      return false;
    }

  }
}
