import { Component, OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.css']
})
export class EmpresaComponent implements OnInit {

  constructor() { }

  //options: FormGroup;
  estado = new FormControl('estado');

  pais = new FormControl('pais');

  ngOnInit() {
  }

}
