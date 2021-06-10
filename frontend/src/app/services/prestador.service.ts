import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Prestador } from 'app/models/prestador';

@Injectable({
  providedIn: 'root'
})
export class PrestadorService {

  //Api Rest Springboot
  url = 'http://localhost:8080/prestadorservico';

  // Injetando httpClient
  constructor(private httpClient : HttpClient) { }

  httpOptions = {
    headers : new HttpHeaders({'Content-Type' : 'application/json'})
  }

  getPrestadores(): Observable<Prestador[]>{
    return this.httpClient.get<Prestador[]>(this.url)
    .pipe(
      retry(2),
      catchError(this.handlerError))
  }
  getPrestador(id : number): Observable<Prestador>{
    return this.httpClient.get<Prestador>(this.url + '/' + id)
      .pipe(
        retry(2),
        catchError(this.handlerError)
      )
  }
  savePrestador(prestador : Prestador) : Observable<Prestador>{
    return this.httpClient.post<Prestador>(this.url, JSON.stringify(prestador), this.httpOptions)
    .pipe(
      retry(2),
      catchError(this.handlerError))
  }
  updatePrestador(prestador: Prestador): Observable<Prestador>{
      return this.httpClient.put<Prestador>(this.url + '/' + prestador.id, JSON.stringify(prestador), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handlerError))
  }
  deletePrestador(prestador: Prestador) {
    return this.httpClient.delete<Prestador>(this.url + '/' + prestador.id, this.httpOptions)
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



