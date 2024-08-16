import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-vehicle-tracking',
  templateUrl: './vehicle-tracking.component.html',
  styleUrls: ['./vehicle-tracking.component.css']
})
export class VehicleTrackingComponent extends BaseCtl {

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.TRACKING, locator, route);
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.vehicleId);
    flag = flag && validator.isNotNullObject(form.lat);
    flag = flag && validator.isNotNullObject(form.lon);
    flag = flag && validator.isNotNullObject(form.date);
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.vehicleId = data.vehicleId;
    form.lat = data.lat;
    form.lon = data.lon;
    form.date = data.date;
  }

  parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }

  test() {
    // Any additional test logic if needed
  }

 
}
