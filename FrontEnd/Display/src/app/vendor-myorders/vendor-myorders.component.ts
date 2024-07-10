import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-vendor-myorders',
  templateUrl: './vendor-myorders.component.html',
  styleUrls: ['./vendor-myorders.component.css']
})
export class VendorMyordersComponent implements OnInit{
  public ordered:any[]=[];
  vendor_id:any;
  vendorPage:boolean=true;
  constructor(private router:Router,private http:HttpClient,private order:LoginService){}
  ngOnInit(): void {
    this.order.vendorId(sessionStorage.getItem('email')).subscribe((data: any) => {

      this.vendor_id=data.vendorId;
      console.log(this.vendor_id)
      // console.log(sessionStorage.getItem('email'))
    })
    this.order.orderList().subscribe((data: any) => {
      // console.log(data)
      // console.log(sessionStorage.getItem('email'))
      for(let item of data){


        // this.ordered.push(item)
        if(item.vendorNo===this.vendor_id){

          this.ordered.push(item)

        }
      }
      this.ordered.sort((a,b)=>b.orderId-a.orderId)
      this.ordered.sort((a,b)=>{
        const statusA = a.orderStatus.toLowerCase();
        const statusB = b.orderStatus.toLowerCase();
        if (statusA>statusB) return -1;
        if (statusA<statusB) return 1;
        return 0;
      })
      console.log(this.ordered)

  });
}
changeStatus(orderId:any){
  let url="http://localhost:9090/order-api/order/updateStatus/"+orderId.toString()+"?orderStatus=COMPLETED"
  console.log(url)
  const headers = new HttpHeaders({
    'Content-Type':'application/json'
  })
  let data_to_update = {orderStatus:'COMPLETED'};
  this.http.put(url,data_to_update,{headers}).subscribe(
    (response)=>{
      console.log("Status Updated",response)
    },
    (error)=>{
      console.log(error)
    }
  )
  location.reload()


}
showComplete(orderStatus:any){
  if (orderStatus.toString()!="COMPLETED"){
    return true;
  }
  else return false;
}
viewDetail(orderId:any){
  let orderss = this.ordered.find(obj=> obj.orderId === orderId)
  console.log(orderss)
  var data={
    is_vendor:true,
    orderss:orderss
  }
  this.router.navigate(['/order-detail'],{state:{data:data}});
}
}

