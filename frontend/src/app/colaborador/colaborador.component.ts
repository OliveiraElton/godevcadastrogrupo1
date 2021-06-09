import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-colaborador',
  templateUrl: './colaborador.component.html',
  styleUrls: ['./colaborador.component.css']
})
export class ColaboradorComponent implements OnInit {

  constructor() { }

  // Necessário para que não haja problema no carregamento da tela devido às listas
  generoColab = new FormControl('generoColab');
  identGeneroColab = new FormControl('identGeneroColab');
  escolaridadeColab = new FormControl('escolaridadeColab');
  estadoCivilColab = new FormControl('estadoCivilColab');
  nacionalidadeColab = new FormControl('nacionalidadeColab');
  naturalidadeColab = new FormControl('naturalidadeColab');
  ehPcdColab = new FormControl('ehPcdColab');
  operacaoContaColab = new FormControl('operacaoContaColab');

  ngOnInit() {
  }

}
