import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-vehiclelist',
  templateUrl: './vehiclelist.component.html',
  styleUrls: ['./vehiclelist.component.css']
})
export class VehiclelistComponent  extends BaseListCtl  {

  isValidPaymentTermInput: boolean = true;

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.VEHICLE, locator, route); // Assuming 'VEHICLE' is your endpoint for vehicles
  }

  validateInput(event: any, field: string) {
    const value = event.target.value;
  
    switch(field) {
      case 'paymentTerm':
        // Validate if input is a valid integer
        this.isValidPaymentTermInput = /^[0-9]*$/.test(value);
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
