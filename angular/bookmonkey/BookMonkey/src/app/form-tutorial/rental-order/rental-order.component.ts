import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {RentalOrder} from '../model/rental-order';

@Component({
  selector: 'bm-rental-order',
  templateUrl: './rental-order.component.html',
  styleUrls: ['./rental-order.component.css']
})
export class RentalOrderComponent implements OnInit {

  countries = ['USA', 'Germany', 'Italy', 'France'];

  coDriverOptions = ['yes', 'no', 'maybe'];

  rentalForm: FormGroup;

  availableExtras;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.rentalForm = this.createRentalForm();
  }

  onSubmit() {
    let rentalOrder: RentalOrder = this.rentalForm.value;
    let extrasRaw = rentalOrder.extras;
    let index = 0;
    let _extrasTmp: string[] = [];
    extrasRaw.forEach((value, index) => {
      if (value) {
        _extrasTmp.push(this.availableExtras[index]);
      }
    });
    rentalOrder.extras = _extrasTmp;

    console.log(rentalOrder);
  }


  private createRentalForm(): FormGroup {

    return this.formBuilder.group({
      personalData: this.formBuilder.group({
        name: '',
        surname: '',
        country: ''
      }),
      adacMember: '',
      coDriverOption: '',
      extras: this.availableExtrasFormArray()
    });
  }

  private availableExtrasFormArray(): FormArray {
    // simulate loading extras from any service
    const _availableExtras = ['Navi', 'Soundsystem', 'Vollkasko'];
    // simulate loading previously made choice of user
    const _selectedExtras = ['Navi', 'Vollkasko'];
    // provide choices
    this.availableExtras = _availableExtras;
    //provide form-array
    // _selectedExtras.includes(extra)?'false':'false'
    return new FormArray(this.availableExtras.map(extra => {
      return new FormControl(_selectedExtras.includes(extra) ? true : false);
    }));
  }

}
