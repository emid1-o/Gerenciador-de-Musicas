import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Musica } from '../modelo/musica';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MusicaService {

  private apiUrl:string = "http://localhost:8080";

   constructor(private http: HttpClient) { }

   selecionar(): Observable<Musica[]> {
    return this.http.get<Musica[]>(this.apiUrl);
  }

  cadastrar(Musica: Musica): Observable<Musica> {
    return this.http.post<Musica>(this.apiUrl, Musica);
  }

  editar(Musica: Musica): Observable<Musica> {
    return this.http.put<Musica>(`${this.apiUrl}/${Musica.id}`, Musica);
  }

  remover(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
