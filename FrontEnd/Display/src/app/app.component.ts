import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  notFound:boolean=false
  constructor(private router:Router){
  }
  
  // if (router.url)
    
  // }
  title = 'food_order_app';
}
