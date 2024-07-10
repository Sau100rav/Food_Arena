import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedServiceCartItemCountService {
  cartItemCount : any
  constructor() {this.cartItemCount=0}
}
