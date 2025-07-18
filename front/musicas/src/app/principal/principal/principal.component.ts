import { Component } from '@angular/core';
import { Musica } from '../../modelo/musica';
import { MusicaService } from '../../servico/musica.service';

@Component({
  selector: 'app-principal',
  standalone: false,
  templateUrl: './principal.component.html',
  styleUrl: './principal.component.scss'
})
export class PrincipalComponent {

  musica = new Musica();

  btnCadastrar:boolean = true;

  musicas:Musica[] = [];

  tabela:boolean = true;

  constructor(private servico:MusicaService){}

  selecionar():void {
    this.servico.selecionar()
    .subscribe(retorno => this.musicas = retorno);
  }

  cadastrar():void {
    this.servico.cadastrar(this.musica)
    .subscribe(retorno => {
      
      this.musicas.push(retorno);});

      //limpar fomulario
      this.musica = new Musica();

      //mensagem
      alert('Musica cadastrada com sucesso!')
  }

  selecionarMusica(posicao:number):void {

    //selecionar cliente no vetor
    this.musica = this.musicas[posicao];

    //visibilidade dos botoes
    this.btnCadastrar = false;

    //visibilidade da tabela
    this.tabela = false;
  }

  editar():void {

    this.servico.editar(this.musica)
    .subscribe(retorno => {

      let posicao = this.musicas.findIndex(obj => {
        return obj.id == retorno.id;
      });

      //alterar os dados do cliente no vetor
      this.musicas[posicao] = retorno;

      this.musica = new Musica();

      this.btnCadastrar = true;
      this.tabela = true;

      alert("Musica alterada com sucesso!")
    })
  }

  remover():void {

    this.servico.remover(this.musica.id)
    .subscribe(retorno => {

      let posicao = this.musicas.findIndex(obj => {
        return obj.id == this.musica.id;
      });

      //remover cleinte
      this.musicas.splice(posicao, 1);

      this.musica = new Musica();

      this.btnCadastrar = true;
      this.tabela = true;

      alert("Música removida com sucesso!")
    })
  }

  cancelar():void{

    this.musica = new Musica;

    this.btnCadastrar = true;
    this.tabela = true;
  }

  ngOnInit(){
    this.selecionar();
  }


}
