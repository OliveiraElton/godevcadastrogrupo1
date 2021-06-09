import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Colaborador } from 'app/models/colaborador';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

    //Api Rest Springboot
    url = 'http://localhost:8080/colaborador';

    // Injetando httpClient
    constructor(private httpClient : HttpClient) { }
  
    httpOptions = {
      headers : new HttpHeaders({'Content-Type' : 'application/json'})
    }

    // Buscar todos colaboradores
    getColaboradores(): Observable<Colaborador[]>{
      return this.httpClient.get<Colaborador[]>(this.url)
      .pipe(
        retry(2),
        catchError(this.handleError))
    }

    // Cadastrar colaborador
    saveColaborador(colaborador : Colaborador) : Observable<Colaborador>{
      return this.httpClient.post<Colaborador>(this.url, JSON.stringify(colaborador), this.httpOptions)
      .pipe(
        retry(2),
        catchError(this.handleError))
    }

    // Atualizar colaborador
    updateColaborador(colaborador: Colaborador): Observable<Colaborador>{
        return this.httpClient.put<Colaborador>(this.url + '/' + colaborador.idColab, JSON.stringify(colaborador), this.httpOptions)
        .pipe(
          retry(1),
          catchError(this.handleError))
    }

    // Obter um colaborador por ID
    getColaboradorById(idColab: number): Observable<Colaborador> {
      return this.httpClient.get<Colaborador>(this.url + '/' + idColab)
        .pipe(
          retry(2),
          catchError(this.handleError))
    }

      // Obter um colaborador por nome
      getColaboradorByName(nomeColab: String): Observable<Colaborador> {
        return this.httpClient.get<Colaborador>(this.url + '/' + nomeColab)
          .pipe(
             retry(2),
            catchError(this.handleError))
      }

    // Deletar um colaborador
    deleteCar(colaborador: Colaborador) {
      return this.httpClient.delete<Colaborador>(this.url + '/' + colaborador.idColab, this.httpOptions)
        .pipe(
          retry(1),
          catchError(this.handleError)
        )
    }

    // Apresenta os erros, se houver
    handleError(error: HttpErrorResponse){
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
