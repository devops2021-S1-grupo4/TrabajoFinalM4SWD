import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BackService {

  constructor(private http: HttpClient) {
  }

  getDxC(sueldo: string, ahorro: string) {
    let queryParams = new HttpParams();
    let url = 'http://localhost:8080/rest/msdxc/dxc';
    queryParams = queryParams.append("sueldo", sueldo);
    queryParams = queryParams.append("ahorro", ahorro);
    return this.http.get(url, { params: queryParams });
  }

  getSaldo(ahorro: string) {
    let queryParams = new HttpParams();
    let url = 'http://localhost:8080/rest/msdxc/saldoahorro';
    queryParams = queryParams.append("ahorro", ahorro);
    return this.http.get(url, { params: queryParams });
  }

  getImpuesto(sueldo: string) {
    let url = 'http://localhost:8080/rest/msdxc/impuesto';
    let queryParams = new HttpParams();
    queryParams = queryParams.append("sueldo", sueldo);
    return this.http.get(url, { params: queryParams });
  }

}
