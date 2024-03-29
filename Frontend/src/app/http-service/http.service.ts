import {HttpClient, HttpRequest} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';

@Injectable()
export class HttpService {

  constructor(private httpClient: HttpClient) { }

  public get(url: string): Observable<any>{
    return this.httpClient.get(url);
  }

  public post(url: string, obj: any): Observable<any>{
    return this.httpClient.request(new HttpRequest('POST', url, obj));
  }

}
