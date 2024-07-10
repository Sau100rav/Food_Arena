import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
@Component({
  selector: 'app-vendormenu',
  templateUrl: './vendormenu.component.html',
  styleUrls: ['./vendormenu.component.css']
})
export class VendormenuComponent implements OnInit{
  public itemsArray: any[] = [];
  public errorMessage: string = "";
  public currentProduct :any;
  constructor(private router:Router,private http:HttpClient,private vmenu:LoginService){}
  ngOnInit(): void {
    this.getItemData()
  }

  getItemData() {
    this.vmenu.vendormenu().subscribe((response: any[]) => {
      this.itemsArray = response;

    }, (error: any) => {
      this.errorMessage = "No item!"
    })

}
deleteMenu(id:string){
if(confirm('Want to delete this item?'))
  this.http.delete('http://localhost:9090/food-api/product/'+id).subscribe();

this.getItemData();
alert('Item successfully deleted')

}
Edit(id:string){
// get product by product id
// populate card with product details
// change the button value to update product
console.log(this.itemsArray);
this.currentProduct=this.itemsArray.find((p)=>{
 return  p.productId===id

})
console.log(this.currentProduct);
console.log(id);
}
}
