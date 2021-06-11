import { Component, OnInit } from '@angular/core';
import { FormControl, NgForm } from '@angular/forms';
import { Colaborador } from 'app/models/colaborador';
import { Conta } from 'app/models/conta';
import { Contatos } from 'app/models/contatos';
import { Dependentes } from 'app/models/dependentes';
import { Endereco } from 'app/models/endereco';
import { ExameMedico } from 'app/models/exameMedico';
import { ColaboradorService } from 'app/services/colaborador.service';

@Component({
  selector: 'app-colaborador',
  templateUrl: './colaborador.component.html',
  styleUrls: ['./colaborador.component.css']
})
export class ColaboradorComponent implements OnInit {

  colaborador = {} as Colaborador;
  endereco = {} as Endereco;
  contatos = {} as Contatos;
  dependente = {} as Dependentes;
  examesMedicos = {} as ExameMedico;
  colaboradores: Colaborador[];
  conta = {} as Conta;
  constructor(private colaboradorService : ColaboradorService) { }

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
  optanteIR = new FormControl('optante');
  ehOptanteVTColab = new FormControl('ehOptanteVTColab');
  ehOptanteVAVRColab = new FormControl('ehOptanteVAVRColab');
  ehOptanteDepColab = new FormControl('ehOptanteDepColab');
  emailCorpColab = new FormControl('emailCorpColab');
  exameMedico = new FormControl('exameMedico');
  aptidao = new FormControl('aptidao');


  ngOnInit() {
  }

  /*
  // Define se um colaborador será criado ou atualizado
   saveColaborador(form: NgForm) {
    if (this.colaborador.idColab !== undefined) {
      this.colaboradorService.updateColaborador(this.colaborador).subscribe(() => {
        this.cleanForm(form);
      });
    } else {
      this.colaboradorService.saveColaborador(this.colaborador).subscribe(() => {
        this.cleanForm(form);
      });
    }
  }

  // Obter todos os colaboradores
  getColaboradores() {
    this.colaboradorService.getColaboradores().subscribe((colaboradores: Colaborador[]) => {
      this.colaboradores = colaboradores;
    });
  }

  // Deletar um colaborador
  deleteColaborador(colaborador: Colaborador) {
    this.colaboradorService.deleteCar(colaborador).subscribe(() => {
      this.getColaboradores();
    });
  }

  // ???
  editColaborador(colaborador: Colaborador) {
    this.colaborador = { ...colaborador };
  }

  // Limpar o formulário
  cleanForm(form: NgForm) {
    this.getColaboradores();
    form.resetForm();
    this.colaborador = {} as Colaborador;
  }
*/
}
