import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { BackService } from './services/back.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front';
  valor: any;
  mensajeRespuesta: string = '';

  respuesta: boolean = false;

  verSueldo: boolean = false;
  verAhorro: boolean = false;
  verBtonoes: boolean = false;

  miFormulario: FormGroup = this.fb.group({
    opcion: ['', [Validators.required]],
    sueldo: [1600000, [Validators.required, Validators.min(0)]],
    ahorro: [25000000, [Validators.required, Validators.min(0)]]
  })

  constructor(
    private fb: FormBuilder,
    public backService: BackService) { }

  campoEsValido(campo: string) {
    return this.miFormulario.controls[campo].errors && this.miFormulario.controls[campo].touched;
  }

  menu() {
    let opcion = this.miFormulario.controls['opcion'].value;
    this.verSueldo = false;
    this.verAhorro = false;
    this.verBtonoes = true;

    if (opcion === 'DxC') {
      this.verSueldo = true;
      this.verAhorro = true;
    }
    else if (opcion === 'Saldo') {
      this.verAhorro = true;
    }
    else if (opcion === 'Impuesto') {
      this.verSueldo = true;
    }
  }

  limpiar() {
    this.miFormulario.reset();
    this.valor = '';
    this.respuesta = false;
  }

  consultar() {
    if (this.miFormulario.invalid) {
      this.miFormulario.markAllAsTouched();
    }
    let opcion = this.miFormulario.controls['opcion'].value;
    let sueldo = this.miFormulario.controls['sueldo'].value;
    let ahorro = this.miFormulario.controls['ahorro'].value;

    if (opcion === 'DxC') {
      this.backService.getDxC(sueldo, ahorro).subscribe((resp: any) => { this.respuesta = true; this.valor = resp.dxc; this.mensajeRespuesta = 'El 10% que se obtendría es ' });
    }
    else if (opcion === 'Saldo') {
      this.backService.getSaldo(ahorro).subscribe((resp: any) => { this.respuesta = true; this.valor = resp.saldoAhorro; this.mensajeRespuesta = 'El saldo restante que quedará luego de un posible retiro es ' });
    }
    else if (opcion === 'Impuesto') {
      this.backService.getImpuesto(sueldo).subscribe((resp: any) => { this.respuesta = true; this.valor = resp.impuesto; this.mensajeRespuesta = 'El impuesto asociado al retirar el monto máximo es ' });
    }
  }
}

