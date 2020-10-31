import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})export class CommonService {
    constructor(private http: HttpClient) {}

    public static handleError(error : HttpErrorResponse) {
        if (error.error instanceof ErrorEvent) {
            // A client-side or network error occurred. Handle it accordingly.
            console.error('An error occurred:', error.error.message);
        } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong,
            console.error(
            `Backend returned code ${error.status}, ` +
            `body was: ${error.error}`);
        }
        // return an observable with a user-facing error message
        return throwError(
          'Something bad happened; please try again later.');
    };

    public parseXmlList(sitesList: any[]): any[] {
        let newList = new Array();
        let parser = new DOMParser();
        if (sitesList.length > 0) {
            sitesList.forEach((element: any) => {
                let newElement = {};
                newElement['checked'] = element.checked;
                newElement['id'] = element.id;
                let domElement = parser.parseFromString(element.name, 'text/xml');
                if (domElement.children && domElement.children.length > 0
                    && domElement.children[0].children.length > 0) {
                        newElement['name'] = domElement.children[0].children[0].textContent;
                }
                newList.push(newElement);
            });
        }
        return newList;
    }

    public getListOfDays(startDate: Date, endDate: Date) {
        let dateList = new Array();
        if (startDate && endDate) {
            if (endDate < startDate) {
                endDate = startDate;
            }

            let tempStartDate = Date.UTC(startDate.getFullYear(), startDate.getMonth(), startDate.getDate());
            let tempEndDate = Date.UTC(endDate.getFullYear(), endDate.getMonth(), endDate.getDate());
            let difference = Math.round(tempEndDate - tempStartDate);
            let numberOfDay = difference / (1000 * 3600 * 24);
            for (let i = 0; i <= numberOfDay; i++) {
                let newTime = new Date(startDate.getTime() + (i * 1000 * 3600 * 24));
                dateList.push(newTime);
            }
        }
        return dateList;
    }

    // Returns the ISO week of the date.
    getWeek(dataDate: Date) {
        if (dataDate != null) {
            var date = new Date(dataDate.getTime());
            date.setHours(0, 0, 0, 0);
            // Thursday in current week decides the year.
            date.setDate(date.getDate() + 3 - (date.getDay() + 6) % 7);
            // January 4 is always in week 1.
            var week1 = new Date(date.getFullYear(), 0, 4);
            // Adjust to Thursday in week 1 and count number of weeks from date to week1.
            return 1 + Math.round(((date.getTime() - week1.getTime()) / 86400000
                - 3 + (week1.getDay() + 6) % 7) / 7);
        }
    }

    getNumberOfWeek(year: number) {
        let month = 11;
        let day = 31;
        let week = 0;

        do {
            let d = new Date(year, month, day--);
            week = this.getWeek(d);
        } while (week == 1);
        
        return week;
    }

    getDateFromWeek(weekNumber: number, year: number) {
        let day = (1 + (weekNumber - 1) * 7);
        let simple = new Date(year, 0, day);
        var dow = simple.getDay();
        var ISOweekStart = simple;
        if (dow < 4)
            ISOweekStart.setDate(simple.getDate() - simple.getDay() + 1);
        else
            ISOweekStart.setDate(simple.getDate() + 8 - simple.getDay());
        return ISOweekStart;
    }
}