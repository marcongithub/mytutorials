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

  usersBirthday: Date = new Date();

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.rentalForm = this.createRentalForm();
  }

  onSubmit() {
    let rentalOrderRaw: any = this.rentalForm.value;
    let rentalOrder: RentalOrder = this.rentalForm.value;
    let extrasRaw = rentalOrder.extras;
    let index = 0;
    let _extrasTmp: string[] = [];
    // array with true/false values
    // extrasRaw.forEach((value, index) => {
    //   if (value) {
    //     _extrasTmp.push(this.availableExtras[index]);
    //   }
    // });
    // same as above shorter
    _extrasTmp = extrasRaw.map((value, index) => value ? this.availableExtras[index] : null).filter(extra => extra !== null);
    rentalOrder.extras = _extrasTmp;

    console.log('date before: '+rentalOrder.personalData.birthDate);
    // convert date
    let birthdayFromInputForm: string = rentalOrderRaw.personalData.birthDate;
    rentalOrder.personalData.birthDate = this.getBirthdayFromDateInput(birthdayFromInputForm);
    console.log('date after: '+rentalOrder.personalData.birthDate);
    console.log(rentalOrder);
  }

  private createRentalForm(): FormGroup {

    return this.formBuilder.group({
      personalData: this.formBuilder.group({
        name: 'Horst',
        surname: ['Katzmeier'],
        country: new FormControl(['Germany']),
        birthDate: this.getBirthdayForDateInput()
      }),
      adacMember: '',
      coDriverOption: '',
      extras: this.availableExtrasFormArray()
    });
  }

  private getBirthdayForDateInput(): string {
    // simulate retrieval of users birthdate
    this.usersBirthday = new Date(1972, 5, 15);
    // yyyy-MM-dd with timezone
    return new Date(this.usersBirthday.getTime() - (this.usersBirthday.getTimezoneOffset() * 60000))
      .toISOString()
      .split('T')[0];
  }

  private getBirthdayFromDateInput(birthDate: string): Date {
    let birthDaySplit: number[] = birthDate.split('-').map(s => Number(s));
    this.usersBirthday = new Date(birthDaySplit[0], (birthDaySplit[1] - 1), birthDaySplit[2]);
    return this.usersBirthday;
  }

  private availableExtrasFormArray(): FormArray {
    // simulate loading available extras from any service
    const _availableExtras = ['Navi', 'Soundsystem', 'Vollkasko'];
    // simulate loading previously made choice of user
    const _selectedExtras = ['Navi', 'Vollkasko'];
    // provide choices for displaying the name in the template
    this.availableExtras = _availableExtras;
    // provide form-array with true/false values
    return new FormArray(this.availableExtras.map(extra => {
      return new FormControl(_selectedExtras.includes(extra) ? true : false);
    }));
  }

}
