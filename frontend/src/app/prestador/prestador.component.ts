import { Component, OnInit } from '@angular/core';
import { FormControl, NgForm } from '@angular/forms';
import { Prestador } from 'app/models/prestador';
import { PrestadorService } from 'app/prestador.service';
import { Contatos } from 'app/models/contatos';
/*import { EmpresaService } from '../empresa.service';*/


@Component({
  selector: 'app-prestador',
  templateUrl: './prestador.component.html',
  styleUrls: ['./prestador.component.css']
})
export class PrestadorComponent implements OnInit {

  contatos = {} as Contatos;
  /*empresas: Empresa[] = EmpresaService.getEmpresas();*/
  /*nomeEmpresa = EmpresaService.getEmpresa().getNome()*/

  prestador = {} as Prestador;
  constructor(private prestadorService : PrestadorService) { 

  }
  getEmpresas(){
   /* this.empresas = EmpresaService.getEmpresas();*/

  }

  savePrestador(form : NgForm){
    if(this.prestador.id !== undefined){
      this.prestador.contatos = this.contatos;
      this.prestadorService.updatePrestador(this.prestador).subscribe(() => {
        this.cleanForm(form);
      });
    }else{
      this.prestador.contatos = this.contatos;
      this.prestadorService.savePrestador(this.prestador).subscribe(() => {
        this.cleanForm(form);
      })
    }
  }
  ngOnInit(){
    this.getEmpresas();
  }
  cleanForm(form : NgForm){
    form.resetForm();
  }
}
