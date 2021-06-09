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
  nacionalidade = new FormControl('nacionalidade');
  naturalidade = new FormControl('naturalidade');
  pcd = new FormControl('pcd');
  generoDepen = new FormControl('generoDepen');
  identGeneroDepen = new FormControl('identGeneroDepen');
  tipoDependente = new FormControl('tipoDependente');
  optante = new FormControl('optante');
  ehOptanteVTColab = new FormControl('ehOptanteVTColab');
  ehOptanteVAVRColab = new FormControl('ehOptanteVAVRColab');
  ehOptanteDepColab = new FormControl('ehOptanteDepColab');
  emailCorpColab = new FormControl('emailCorpColab');
  ngOnInit() {
  }

}
