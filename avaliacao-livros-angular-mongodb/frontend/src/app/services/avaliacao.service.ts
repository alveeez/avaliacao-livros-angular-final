import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Avaliacao } from '../models/avaliacao';
@Injectable({providedIn:'root'}) export class AvaliacaoService {
 private http=inject(HttpClient); private url='http://localhost:8080/avaliacoes';
 listarPorLivro(id:string):Observable<Avaliacao[]>{return this.http.get<Avaliacao[]>(`${this.url}/livro/${id}`);}
 criar(a:Avaliacao):Observable<Avaliacao>{return this.http.post<Avaliacao>(this.url,a);}
 excluir(id:string):Observable<void>{return this.http.delete<void>(`${this.url}/${id}`);}
}
