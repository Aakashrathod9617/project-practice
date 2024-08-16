import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-atims',
  templateUrl: './atims.component.html',
  styleUrls: ['./atims.component.css']
})
export class AtimsComponent extends BaseCtl {


  isValidRemarkInput:boolean=true;
  isValidQuantityInput:boolean=true;


  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.ATIMS, locator, route);
  }

  validateInput(event: any, field: string) {
    const value = event.target.value;
  
    switch(field) {
      case 'remark':
        const containsNonAlphabetic = /[^\sa-zA-Z]/.test(value);
        this.isValidRemarkInput = !containsNonAlphabetic;
        break;
  
      case 'quantity':
        // Validate if input is a valid integer
        this.isValidQuantityInput = /^[0-9]*$/.test(value);
        break;
  
      // Add more cases for other fields as needed
      // case 'anotherField':
      //   // Validation logic for another field
      //   break;
  
      default:
        break;
    }
  }

  
  submit() {
    var _self = this;
    console.log('in submit');
    console.log(this.form);
    console.log(this.form.data);
    this.serviceLocator.httpService.post(this.api.save, this.form.data, function (res) {
      _self.form.message = '';
      _self.form.inputerror = {};
      _self.form.data.id = res.result.data;

      if (res.success) {
        _self.form.message = "Data is saved";
        _self.form.error = false; // Ensure this is set to false for success
        _self.form.data.id = res.result.data;

        console.log(_self.form.data.id);
        console.log("----------Rahul----------.");

      } else {
        _self.form.error = true;
        if (res.result.inputerror) {
          _self.form.inputerror = res.result.inputerror;
        }
        _self.form.message = res.result.message;
      }
      _self.form.data.id = res.result.data;
      console.log('FORM', _self.form);
    });
  }

  submit1() {
    var _self = this;
    console.log(this.form + "submit running start");
    console.log(this.form.data + "form data going to be submit");
    this.serviceLocator.httpService.post(this.api.search, this.form.data, function (res) {
      _self.form.message = '';
      _self.form.inputerror = {};
      _self.form.data.id = res.result.data;

      if (res.success) {
        _self.form.message = "Data is saved";
        _self.form.data.id = res.result.data;

        console.log(_self.form.data.id);
        console.log("--------------------.");

      } else {
        _self.form.error = true;
        _self.form.inputerror = res.result.inputerror;
        _self.form.message = res.result.message;
      }
      _self.form.data.id = res.result.data;
      console.log('FORM', _self.form);
    });
  }

  onUpload(userform: FormData) {
    this.submit();
    console.log(this.form.data.id + '---- after submit');
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.location);
    flag = flag && validator.isNotNullObject(form.cashAvailable);
    flag = flag && validator.isNotNullObject(form.lastRestockedDate);
    flag = flag && validator.isNotNullObject(form.remark);
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.location = data.location;
    form.cashAvailable = data.cashAvailable;
    form.lastRestockedDate = this.formatDate(data.lastRestockedDate); // Assuming lastRestockedDate is in ISO string format
    form.remark = data.remark;
  }

  private formatDate(dateString: string): string {
    if (dateString) {
      const date = new Date(dateString);
      return date.toISOString().split('T')[0]; // Format as yyyy-MM-dd
    }
    return null;
  }

  test() {
    // Any additional test logic if needed
  }
}
