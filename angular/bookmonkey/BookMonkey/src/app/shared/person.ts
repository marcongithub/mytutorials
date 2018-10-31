export class Person {

  private _age: number;

  constructor(private name: string, private surname: string) {}

  get age(): number {
    return this._age;
  }

  set age(age: number) {
    this._age = age;
  }

  getFullName(): string {
    return this.name + ' ' + this.surname;
  }
}
