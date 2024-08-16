import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-ownerlist',
  templateUrl: './ownerlist.component.html',
  styleUrls: ['./ownerlist.component.css']
})
export class OwnerlistComponent extends BaseListCtl {

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
  isValidSupplierNameInput:boolean=true;
  isValidQuantityInput:boolean=true;
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.OWNER, locator, route);
  }
  validateInput(event: any, field: string) {
    const value = event.target.value;
  
    switch(field) {
      case 'name':
        const containsNonAlphabetic = /[^\sa-zA-Z]/.test(value);
        this.isValidSupplierNameInput = !containsNonAlphabetic;
        break;
  
      case 'vehicleId':
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

}

