import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  // Api Rest Springboot
  url = 'http://localhost:8080/empresa';

  // Injetando httpClient
  constructor(private httpClient : HttpClient) { }

  httpOptions = {
    Headers : new HttpHeaders({'Content-Type' : 'application/json'})
  }
  
  getEmpresas() : Observable<Empresa[]> {
    return this.httpClient.get<Empresa[]>(this.url)
    .pipe(
      retry(2),
      catchError(this.handlerError))
  }

  saveEmpresa(empresa : Empresa)


}
