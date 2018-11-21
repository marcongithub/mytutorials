export class RentalOrder {

  private _personalData: PersonalData;

  private _coDriverOption: string;

  private _adacMember: boolean;

  private _extras: string[];

  get extras(): string[] {
    return this._extras;
  }

  set extras(value: string[]) {
    this._extras = value;
  }

  get adacMember(): boolean {
    return this._adacMember;
  }

  set adacMember(value: boolean) {
    this._adacMember = value;
  }

  get coDriverOption(): string {
    return this._coDriverOption;
  }

  set coDriverOption(value: string) {
    this._coDriverOption = value;
  }

  get personalData(): PersonalData {
    return this._personalData;
  }

  set personalData(value: PersonalData) {
    this._personalData = value;
  }
}

export class PersonalData{

  constructor(private _name: string, private _surname?: string, private _country?: string, private _birthDate?: Date) {
    this._name = _name ? _name : '';
  }

  get birthDate(): Date {
    return this._birthDate;
  }

  set birthDate(value: Date) {
    this._birthDate = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get surname(): string {
    return this._surname;
  }

  set surname(value: string) {
    this._surname = value;
  }

  get country(): string {
    return this._country;
  }

  set country(value: string) {
    this._country = value;
  }
}



