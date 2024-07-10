import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { QRCodeModule } from 'angularx-qrcode';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { MenupagehomeComponent } from './menupagehome/menupagehome.component';
// import { SharedServiceCartItemCountService } from './shared-service-cart-item-count.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ThankYouComponent } from './thank-you/thank-you.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { FirstComponent } from './first/first.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MyOrdersComponent } from './my-orders/my-orders.component';
import { ToastrModule } from 'ngx-toastr';
import { VendorMyordersComponent } from './vendor-myorders/vendor-myorders.component';
import { NglrxPipesModule } from '@nglrx/pipes';
import { OrderHistoryComponent } from './order-history/order-history.component';
import { VendorsignComponent } from './vendorsign/vendorsign.component';
import { VendormenuComponent } from './vendormenu/vendormenu.component';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    MenupagehomeComponent,
    ThankYouComponent,
    CheckoutComponent,
    FirstComponent,
    LoginComponent,
    SignupComponent,
    MyOrdersComponent,
    VendorMyordersComponent,
    OrderHistoryComponent,
    VendorsignComponent,
    VendormenuComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NglrxPipesModule,
    QRCodeModule,

    ToastrModule.forRoot({
      timeOut: 1500,
      progressBar: true,
      progressAnimation: 'decreasing',
      positionClass: 'toast-bottom-center',
      preventDuplicates: true
    }),
  ],
  // providers: [SharedServiceCartItemCountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
