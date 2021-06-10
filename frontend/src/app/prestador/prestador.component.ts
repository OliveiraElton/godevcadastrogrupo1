import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Prestador } from 'app/models/prestador';
import { Contatos } from 'app/models/contatos';
import { PrestadorService } from 'app/services/prestador.service';
import { EmpresaService } from '../services/empresa.service'
import { Empresa } from 'app/models/empresa';


@Component({
  selector: 'app-prestador',
  templateUrl: './prestador.component.html',
  styleUrls: ['./prestador.component.css']
})
export class PrestadorComponent implements OnInit {

  contatos = {} as Contatos;

  empresas: Empresa[] = [];
  empresaId: number;
  prestador = {} as Prestador;
  prestadores: Prestador[];
  empresa = {} as Empresa;
  @Input() prestadorSelecionado?: Prestador;

  constructor(private prestadorService: PrestadorService, private empresaService: EmpresaService) {

  }
  getEmpresas() {
    this.empresaService.getEmpresas()
      .subscribe(empresas => this.empresas = empresas);
  }
  savePrestador(form: NgForm) {
    this.prestador.contatos = this.contatos;
    this.empresas.forEach(empresaDb => {

      if (empresaDb.id == this.empresaId) this.prestador.empresa = empresaDb;
    })
    if (this.prestador.id !== undefined) {
      this.prestadorService.updatePrestador(this.prestador).subscribe(() => {
        this.cleanForm(form);
      });
    } else {
      this.prestadorService.savePrestador(this.prestador).subscribe(() => {
        this.cleanForm(form);
      })
    }
  }

  // Obter todos
  getPrestadores() {
    this.prestadorService.getPrestadores().subscribe((prestadores: Prestador[]) => {
      this.prestadores = prestadores;
    });
  }

  // Obter todos
  getPrestador() {
    this.prestadorService.getPrestador(this.prestador.id).subscribe((prestador: Prestador) => {
      this.empresa = prestador.empresa;
      this.contatos = prestador.contatos;
      this.prestador = prestador;
    });
  }

  // Deletar 
  deletePrestador(prestador: Prestador) {
    this.prestadorService.deletePrestador(prestador).subscribe(() => {
      this.getPrestadores();
    });
  }

  // ???
  editPrestador(prestador: Prestador) {
    this.prestador = { ...prestador };
  }

  ngOnInit() {
    this.getEmpresas();
  }

  cleanForm(form: NgForm) {
    form.resetForm();
  }
}
