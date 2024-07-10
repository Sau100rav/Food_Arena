import { Component,OnInit} from '@angular/core';
import { LoginService } from '../services/login.service';

import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SafeValue } from '@angular/platform-browser';



@Component({
  selector: 'app-my-orders',
  templateUrl: './my-orders.component.html',
  styleUrls: ['./my-orders.component.css']
})
export class MyOrdersComponent implements OnInit {
order:any;
qrdata:any;
qrCodeDownloadLink:SafeValue='';
isvendor:any;
onChange(url:SafeValue){
    this.qrCodeDownloadLink=url;
}

constructor(private route:ActivatedRoute,private http :HttpClient){

  this.order=history.state.data['orderss'];
  this.qrdata = JSON.stringify(this.order)
  console.log(this.qrdata)
  this.isvendor=history.state.data['is_vendor'];
  console.log(this.isvendor);
}
ngOnInit(): void {

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


}

