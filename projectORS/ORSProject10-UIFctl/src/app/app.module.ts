import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

import { AppComponent } from './app.component';
import { MarksheetComponent } from './marksheet/marksheet.component';
import { StudentComponent } from './student/student.component';
import { CollegeComponent } from './college/college.component';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule, HttpClient, HTTP_INTERCEPTORS } from '@angular/common/http';

import { HttpServiceService } from './http-service.service';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DataValidator } from './utility/data-validator';
import { ForgotPasswordComponent } from './login/forgotpassword.component';
import { SignUpComponent } from './login/signup.component';
import { MessageComponent } from './message/message.component';
import { CookieService } from 'ngx-cookie-service';
import { MessageListComponent } from './message/message-list.component';
import { MarksheetListComponent } from './marksheet/marksheet-list.component';
import { CollegeListComponent } from './college/college-list.component';
import { StudentListComponent } from './student/student-list.component';
import { UserComponent } from './user/user.component';

import { UserListComponent } from './user/user-list.component';

import { RoleComponent } from './role/role.component';
import { CourseComponent } from './course/course.component';
import { SubjectComponent } from './subject/subject.component';
import { RoleListComponent } from './role/role-list.component';
import { TimetableComponent } from './timetable/timetable.component';
import { CourseListComponent } from "./course/course-list.component";
import { FacultyComponent } from './faculty/faculty.component';
import { FacultyListComponent } from "./faculty/faculty-list.component";
import { FileComponent } from './file/file.component';
import { TimetableListComponent } from "./timetable/timetable-list.component";
import { SubjectListComponent } from "./subject/subject-list.component";
import { MarksheetmeritListComponent } from "./marksheet/marksheetmerit-list.component";
import { GetmarksheetComponent } from "./marksheet/getmarksheet.component";
import { ChangepasswordComponent } from "./user/changepassword.component";
import { LoaderComponent } from "./loader/loader.component";
import { NavbarComponent } from './navbar/navbar.component';

import { SpinnerComponent } from './spinner/spinner.component';
import { FooterComponent } from './footer/footer.component';
import { MyprofileComponent } from './user/myprofile.component';
import { AuthService } from './auth-service.service';
import { OrderComponent } from './order/order.component';
import { OrderlistComponent } from './order/orderlist.component';
import { PaymentComponent } from './payment/payment.component';
import { PaymentlistComponent } from './payment/paymentlist.component';
import { PrescriptionComponent } from './prescription/prescription.component';
import { PrescriptionlistComponent } from './prescription/prescriptionlist.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { WishlistListComponent } from './wishlist/wishlist-list.component';
import { InventoryComponent } from './inventory/inventory.component';
import { InventorylistComponent } from './inventory/inventorylist.component';
import { SupplierComponent } from './supplier/supplier.component';
import { SupplierlistComponent } from './supplier/supplierlist/supplierlist.component';
import { WorkorderComponent } from './workorder/workorder.component';
import { WorkorderlistComponent } from './workorder/workorderlist/workorderlist.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { VehiclelistComponent } from './vehiclelist/vehiclelist.component';
import { OwnerComponent } from './owner/owner.component';
import { OwnerlistComponent } from './ownerlist/ownerlist.component';
import { TransportationComponent } from './transportation/transportation.component';
import { TransportationListComponent } from './transportation-list/transportation-list.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { JobComponent } from './job/job.component';
import { JobListComponent } from './job-list/job-list.component';
import { VehicleTrackingComponent } from './vehicle-tracking/vehicle-tracking.component';
import { VehicleTrackingListComponent } from './vehicle-tracking-list/vehicle-tracking-list.component';
import { SalaryComponent } from './salary/salary.component';
import { SalaryListComponent } from './salary-list/salary-list.component';
import { AtimsComponent } from './atims/atims.component';
import { AtimslistComponent } from './atimslist/atimslist.component';








// import { AuthService } from './auth.service';


export function myHttpLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}


@NgModule({
  declarations: [
    AppComponent,
    MarksheetComponent,
    MarksheetListComponent,
    StudentComponent,
    StudentListComponent,
    CollegeComponent,
    CollegeListComponent,
    LoginComponent,
    DashboardComponent,
    ForgotPasswordComponent,
    SignUpComponent,
    MessageComponent,
    MessageListComponent,
    UserComponent,
    UserListComponent,

    RoleComponent,
    RoleListComponent,
    CourseComponent,
    SubjectComponent,
    SubjectListComponent,
    TimetableComponent,
    CourseListComponent,
    FacultyComponent,
    FacultyListComponent,
    TimetableComponent,
    TimetableListComponent,
    MarksheetmeritListComponent,
    GetmarksheetComponent,
    ChangepasswordComponent,
    LoaderComponent,
    FileComponent,
    NavbarComponent,
    SpinnerComponent,
    FooterComponent,
    MyprofileComponent,
    OrderComponent,
    OrderlistComponent,
    PaymentComponent,
    PaymentlistComponent,
    PrescriptionComponent,
    PrescriptionlistComponent,
    WishlistComponent,
    WishlistListComponent,
    InventoryComponent,
    InventorylistComponent,
    SupplierComponent,
    SupplierlistComponent,
    WorkorderComponent,
    WorkorderlistComponent,
    VehicleComponent,
    VehiclelistComponent,
    OwnerComponent,
    OwnerlistComponent,
    TransportationComponent,
    TransportationListComponent,
    EmployeeComponent,
    EmployeeListComponent,
    JobComponent,
    JobListComponent,
    VehicleTrackingComponent,
    VehicleTrackingListComponent,
    SalaryComponent,
    SalaryListComponent,
    AtimsComponent,
    AtimslistComponent,
   
  
   
  ],
  imports: [
    BrowserModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: myHttpLoader,
        deps: [HttpClient]
      }
    }),
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
   
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: AuthService, multi: true
    },
    HttpServiceService,
    DataValidator,
    CookieService
  ],
  bootstrap: [AppComponent]
})


export class AppModule {

}