import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class EndpointServiceService {

  constructor() { }

  public SERVER_URL = "http://localhost:8084";
  public MESSAGE = this.SERVER_URL + "/Message";
  public USER = this.SERVER_URL + "/User";
  public SALARY = this.SERVER_URL + "/Salary";
  public ATIMS = this.SERVER_URL + "/ATIMS";
  public VEHICLE = this.SERVER_URL + "/Vehicle";
  public EMPL = this.SERVER_URL + "/Empl";
  public JOB = this.SERVER_URL + "/Job";
  public TRACKING = this.SERVER_URL + "/Tracking";
  public OWNER = this.SERVER_URL + "/Owner";
  public TRANS = this.SERVER_URL + "/Trans";
  public ROLE = this.SERVER_URL + "/Role";
  public COLLEGE = this.SERVER_URL + "/College";
  public MARKSHEET = this.SERVER_URL + "/Marksheet";
  public STUDENT = this.SERVER_URL + "/Student";
  public SUBJECT = this.SERVER_URL + "/Subject";
  public FACULTY = this.SERVER_URL + "/Faculty";
  public COURSE = this.SERVER_URL + "/Course";
  public TIMETABLE = this.SERVER_URL + "/TimeTable";
  public JASPERREPORT = this.SERVER_URL + "/Jasper";
  public ORDER = this.SERVER_URL + "/order";
  public PAYMENT = this.SERVER_URL + "/Payment";
  public DOCTOR = this.SERVER_URL + "/Doctor";
  public WISHLIST = this.SERVER_URL + "/Wishlist";
  public PRES = this.SERVER_URL + "/Prescription";
  public INVENTORY = this.SERVER_URL + "/Inventory";
  public SUPPLIER = this.SERVER_URL + "/Supplier";

}
