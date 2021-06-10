import { Component, OnInit } from '@angular/core';
import {FormControl, NgForm} from '@angular/forms';
import { Contatos } from 'app/models/contatos';
import { Empresa } from 'app/models/empresa';
import { Endereco } from 'app/models/endereco';
import { EmpresaService } from 'app/services/empresa.service';

declare var $: any;

@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.css'],
})
export class EmpresaComponent implements OnInit {

  empresa = {} as Empresa;
  contatos = {} as Contatos;
  empresas : Empresa [];
  endereco = {} as Endereco;

  constructor(private empresaService : EmpresaService) { }

  //options: FormGroup;
  estado = new FormControl('estado');

  pais = new FormControl('pais');


  ngOnInit() {
  }
  saveEmpresa(form : NgForm){
    if(this.empresa.id !== undefined){
      this.empresa.contatos = this.contatos;
      this.empresa.endereco = this.endereco;
      this.empresaService.updateEmpresa(this.empresa).subscribe(() => {
        this.cleanForm(form);
      });
    }else{
      this.empresa.contatos = this.contatos;
      this.empresaService.saveEmpresa(this.empresa).subscribe(() => {
        this.cleanForm(form);
      })
    }
  }
  cleanForm(form : NgForm){
    form.resetForm();
  }
  showNotification(from, align){
    const type = ['','info','success','warning','danger'];

    

    $.notify({
        icon: "thumb_up",
        message: "Empresa Cadastrada com Sucesso!"

    },{
        type: type[2],
        timer: 4000,
        placement: {
            from: from,
            align: align
        },
        template: '<div data-notify="container" class="col-xl-4 col-lg-4 col-11 col-sm-4 col-md-4 alert alert-{0} alert-with-icon" role="alert">' +
          '<button mat-button  type="button" aria-hidden="true" class="close mat-button" data-notify="dismiss">  <i class="material-icons">close</i></button>' +
          '<i class="material-icons" data-notify="icon">thumb_up</i> ' +
          '<span data-notify="title">{1}</span> ' +
          '<span data-notify="message">{2}</span>' +
          '<div class="progress" data-notify="progressbar">' +
            '<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
          '</div>' +
          '<a href="{3}" target="{4}" data-notify="url"></a>' +
        '</div>'
    });
}

}

