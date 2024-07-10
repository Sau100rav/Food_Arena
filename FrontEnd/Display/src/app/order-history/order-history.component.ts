import { Component } from '@angular/core';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent {
  public ordered:any[]=[];
constructor(private order:LoginService,private router:Router){}
  date:String="";
  timeOrder:String="";
  timePick:String="";
  email=" ";
  order_data:any;
  ngOnInit(): void {
    // this.email = this.order.emailId
    this.order.orderList().subscribe((data: any) => {
      // this.ordered=data.find((x: { customerEmailId: string; }) =>{
      //   return x.customerEmailId == sessionStorage.getItem('email');
      // });
      // console.log(this.ordered);
      // this.date=this.ordered[0].dateOfOrder
      // console.log(this.date)
     // console.log(data)
      for(let item of data){
        
        console.log(sessionStorage.getItem('email'))
        console.log(item.customerEmailId)
        if(item.customerEmailId===sessionStorage.getItem('email')){
          
          this.ordered.push(item)
  
        }
      }
      this.ordered.sort((a,b)=>b.orderId-a.orderId)
      console.log(this.ordered)
     
      // this.timeOrder=this.ordered[0].dateOfOrder.slice(11,19)
      // this.timePick=this.ordered[0].deliveryTime.slice(11,19)
    },
      (error: { message: any; }) => console.log(error.message));
      //
  }
  viewOrderDetail(orderId:any){
      const orderss = this.ordered.find(obj=> obj.orderId === orderId)
      console.log(orderss)
      this.router.navigate(['/order-detail'],{state:{data:orderss}});
  }
  
}
