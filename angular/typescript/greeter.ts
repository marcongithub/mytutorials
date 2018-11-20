interface IPerson {
  name: String;
  surname: String;
  age: number;
}

class Person implements IPerson {

	constructor (private _name: String, private _surname: String, private _age: number){
  }

	get name(): String {
    return this._name;
  }

  set name(value: String) {
    this._name = value;
  }

  get surname(): String {
    return this._surname;
  }

  set surname(value: String) {
    this._surname = value;
  }

  get age(): number {
    return this._age;
  }

  set age(value: number) {
    this._age = value;
  }
}

let hugo: Person = new Person('Hugo','Meier',50);
//console.log('Hello '+hugo.name);

let fritz: IPerson = hugo;
//console.log('Hello '+fritz.name);

let pippo: IPerson = {
	age: 46,
	name: 'Pippo',
	surname: 'Paperino'
};
//console.log('Hello '+pippo.name);


// Indexable types example, see https://www.typescriptlang.org/docs/handbook/interfaces.html#indexable-types
let map:  {[key: string]: any}  = {};
map['foo'] = 'pippo';
map['bar'] = 'paperino';

let map2: { [key: string]: any } = {horsti:{'foo':'pippo','bar':'paperino'}};
console.log(map2.horsti.foo);

let map3: { [key: string]: any } = {'foo':'pippo','bar':'paperino'};
console.log(map3.foo);
