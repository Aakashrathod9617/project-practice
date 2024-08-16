import { Component, OnInit } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.css']
})
export class JobListComponent extends BaseListCtl {
  public form = {
    error: false,
    message: null,
    preload: [],
    data: { id: null },
    inputerror: {},
    searchParams: { },
    searchMessage: null,
    list: [],
    pageNo: 0
  };

  isValidNameInput: boolean = true;
  isValidCostInput: boolean = true;

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.JOB, locator, route);
  }

  validateInput(event: any, field: string) {
    const value = event.target.value;

    switch (field) {
      case 'name':
        const containsNonAlphabetic = /[^\sa-zA-Z]/.test(value);
        this.isValidNameInput = !containsNonAlphabetic;
        break;

      case 'cost':
        // Validate if input is a valid integer
        this.isValidCostInput = /^[0-9]+$/.test(value);
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