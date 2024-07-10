import { Component ,OnInit} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {

  constructor(private router:Router) { }

  vendor:any = "vendor"
  user:any = "user"
  ngOnInit(): void {
   sessionStorage.clear()
  }

  login = (isVendor:string) =>{
    this.router.navigate(['/login',isVendor])
  }
  signup= ()=>{
    this.router.navigate(['/signup'])
  }
  vendorSignup=()=>{
    this.router.navigate(['/vendorsign'])
  }

}
