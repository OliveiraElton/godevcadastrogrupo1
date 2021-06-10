import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators'
import { Empresa } from './models/empresa';

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
      catchError(this.handlerError)
    )
  }

  saveEmpresa(prestador : Empresa) : Observable<Empresa>{
    return this.httpClient.post<Empresa>(this.url, JSON.stringify(prestador), this.httpOptions)
    .pipe(
      retry(2),
      catchError(this.handlerError))
  }

  updateEmpresa(empresa : Empresa) : Observable<Empresa> {
    return this.httpClient.put<Empresa>(this.url + '/' + empresa.id, JSON.stringify(empresa), this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.handlerError)
    )
  }

  handlerError(error: HttpErrorResponse){
    let errorMessage = '';
    if(error.error instanceof ErrorEvent){
      //Erro ocorreu no lado do client
      errorMessage = error.error.message;
    }else{
      //Erro ocorreu no lado do servidor
      errorMessage = `Código do erro: ${error.status},` + `mensagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };


}
