import { Component, OnInit } from '@angular/core';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BaseListCtl } from '../base-list.component';

@Component({
  selector: 'app-vehicle-tracking-list',
  templateUrl: './vehicle-tracking-list.component.html',
  styleUrls: ['./vehicle-tracking-list.component.css']
})
export class VehicleTrackingListComponent extends BaseListCtl {

  public form = {
    error: false, //error 
    message: null, //error or success message
    preload: [], // preload data
    data: {}, //form data
    inputerror: {}, // form input error messages
    searchParams: {}, //search form
    searchMessage: null, //search result message
    list: [], // search list 
    pageNo: 0
  };

  isValidLatInput: boolean = true;
  isValidLonInput: boolean = true;
  isValidVehicleIDInput: boolean = true;
  isValidDateInput: boolean = true;

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.TRACKING, locator, route);
  }

 

  validateInput(event: any, field: string) {
    const value = event.target.value;

    switch(field) {
      case 'lat':
        this.isValidLatInput = !isNaN(value);
        break;

      case 'lon':
        this.isValidLonInput = !isNaN(value);
        break;

      case 'vehicleId':
        this.isValidVehicleIDInput = /^[0-9]+$/.test(value);
        break;

      case 'date':
        // Validate if input is a valid date
        this.isValidDateInput = /^\d{4}-\d{2}-\d{2}$/.test(value);
        break;

      default:
        break;
    }
  }

}
