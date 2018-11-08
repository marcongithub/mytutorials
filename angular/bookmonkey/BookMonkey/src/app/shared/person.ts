export class Person {

  constructor(private readonly _name: string, private readonly _surname: string, private readonly _age?: number) {
  }

  getFullName(): string {
    return this._name + ' ' + this._surname;
  }

  get name(): string {
    return this._name;
  }

  get surname(): string {
    return this._surname;
  }

  get age(): number {
    return this._age;
  }
}

