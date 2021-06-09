import { getLocaleDateFormat } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { EmailValidator, FormControl } from '@angular/forms';
import { MatInput } from '@angular/material/input';
import { PrestadorService } from 'app/prestador.service';
/*import { EmpresaService } from '../empresa.service';*/


@Component({
  selector: 'app-prestador',
  templateUrl: './prestador.component.html',
  styleUrls: ['./prestador.component.css']
})
export class PrestadorComponent implements OnInit {

  genero = new FormControl('outros');
  identidadeGenero = new FormControl('outros');
  /*empresas: Empresa[] = EmpresaService.getEmpresas();*/

  constructor(private prestadorService : PrestadorService) { 

  }
  getEmpresas(){
   /* this.empresas = EmpresaService.getEmpresas();*/

  }
  ngOnInit(){
    this.getEmpresas();
  }

}
