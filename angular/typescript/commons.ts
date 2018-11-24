let anyObject = {
  pippo : 'paperino',
  foo : 'bar',
  0 : 'baz',
  [1] : 'horsti',
  fonzi : {
    alias: 'LeFonce',
    fonzischildren:['tick','trick','track']
  },
  errors: null
};

anyObject.errors = {foo:'bar'};
anyObject['newprop'] = 'newpropval';
console.log(anyObject['newprop']);
console.log(anyObject.newprop);


console.log(anyObject.errors);

console.log(anyObject.pippo);
console.log(anyObject['pippo']);
console.log(anyObject[0]);
console.log(anyObject['0']);
console.log(anyObject['1']);
anyObject['fonzi'].fonzischildren.forEach(c => console.log(c));

console.log('########');



Object.keys(anyObject).forEach(t => console.log(t + ' is typeof ' + typeof t ));
//Object.keys(anyObject).map(t => Number(t)).filter(t => !isNaN(t)).forEach(t => console.log(t));


console.log('++++++++++');
var colors = { red: 0, green: 1, blue: 2,
               [0]: "red", [1]: "green", [2]: "blue" };

Object.keys(colors).forEach(t => console.log(t + ' is typeof ' + typeof t ));

enum MyEnum {
  FOO, BAR, BAZ
};
console.log('-------------');
Object.values(MyEnum).forEach(v => console.log(v));

// --------------- map
console.log(':::::::::::::::::::::::::::::::::::');
class Man{
  name: string
  constructor(name: string){
    this.name = name;
  }
}

class Soldier{
  man: Man
  constructor(man: Man){
    this.man = man;
  }
}

let names = ['John', 'Jim', 'Hugo','Bob'];
let exclude = ['Hugo'];
let excludeHugo: boolean = names.includes(exclude[0]);
console.log('We should exclude Hugo: '+excludeHugo);
// let men: Man[] = names.map(name => {return new Man(name)}) as Man[];
// men.forEach(man => console.log('And god created '+man.name));

let soldiers: Soldier[] = names.map(name => {console.log('creating '+ name); return new Man(name)}).map(man => {console.log('making ' + man.name + ' a soldier'); return new Soldier(man)}) as Soldier[];
console.log('Gods own army:')
soldiers.forEach(s => console.log(s.man.name));

//---------------------------- more arrays
console.log('//---------------------------- more arrays');
var choicesArray = ['Foo', 'Bar', 'Baz'];
var selectionArray = [false,true,false];
var madeChoiceArray = [];

selectionArray.forEach(function (value, i) {
    console.log('%d: %s', i, value);
    if(value){
      madeChoiceArray.push(choicesArray[i]);
    }
});
madeChoiceArray.forEach(e => console.log(e));
