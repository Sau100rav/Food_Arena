import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { MenupagehomeComponent } from './menupagehome/menupagehome.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { ThankYouComponent } from './thank-you/thank-you.component';
import { FirstComponent } from './first/first.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { MyOrdersComponent } from './my-orders/my-orders.component';
import { VendorMyordersComponent } from './vendor-myorders/vendor-myorders.component';
import { OrderHistoryComponent } from './order-history/order-history.component';
import { VendorsignComponent } from './vendorsign/vendorsign.component';
import { VendormenuComponent } from './vendormenu/vendormenu.component';


const routes: Routes = [

  {path:'',redirectTo:'first',pathMatch: 'full'},
  {path:'home',component:HomeComponent},
  {path:'first',component:FirstComponent},
  {path:'login',component:LoginComponent},
  {path: 'login/:isVendor', component: LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'menupagehome', component:MenupagehomeComponent},
  {path:'checkout', component:CheckoutComponent},
  {path:'thank-you', component:ThankYouComponent},
  {path:'order-detail',component:MyOrdersComponent},
  {path:'my-orders',component:OrderHistoryComponent},
  {path:'vendor-myorders',component:VendorMyordersComponent},
  {path:'vendorsign',component:VendorsignComponent},
  {path:'vendormenu',component:VendormenuComponent},
 
  { path: '**', redirectTo: '', pathMatch: 'full' },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
