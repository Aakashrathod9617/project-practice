import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BaseListCtl } from 'src/app/base-list.component';
import { ServiceLocatorService } from 'src/app/service-locator.service';

@Component({
  selector: 'app-workorderlist',
  templateUrl: './workorderlist.component.html',
  styleUrls: ['./workorderlist.component.css']
})
export class WorkorderlistComponent extends BaseListCtl {

  public form = {

    error: false, //error 
    message: null, //error or success message
    preload: [], // preload data
    data: { id: null }, //form data
    inputerror: {}, // form input error messages
    searchParams: {}, //search form
    searchMessage: null, //search result message
    list: [], // search list 
    pageNo: 0
  };
  isValidEqNameInput:boolean=true;
  isValidFrequencyInput:boolean=true;
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.WORK, locator, route);
  }
  validateInput(event: any, field: string) {
    const value = event.target.value;
  
    switch(field) {
      case 'eqName':
        const containsNonAlphabetic = /[^\sa-zA-Z]/.test(value);
        this.isValidEqNameInput = !containsNonAlphabetic;
        break;
  
      case 'frequency':
        // Validate if input is a valid integer
        this.isValidFrequencyInput = /^[0-9]*$/.test(value);
        break;
  
      // Add more cases for other fields as needed
      // case 'anotherField':
      //   // Validation logic for another field
      //   break;
  
      default:
        break;
    }
  }

}
