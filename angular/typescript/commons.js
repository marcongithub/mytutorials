var _a, _b;
var anyObject = (_a = {
        pippo: 'paperino',
        foo: 'bar',
        0: 'baz'
    },
    _a[1] = 'horsti',
    _a.fonzi = {
        alias: 'LeFonce',
        fonzischildren: ['tick', 'trick', 'track']
    },
    _a);
console.log(anyObject.pippo);
console.log(anyObject['pippo']);
console.log(anyObject[0]);
console.log(anyObject['0']);
console.log(anyObject['1']);
anyObject['fonzi'].fonzischildren.forEach(function (c) { return console.log(c); });
console.log('########');
Object.keys(anyObject).forEach(function (t) { return console.log(t + ' is typeof ' + typeof t); });
//Object.keys(anyObject).map(t => Number(t)).filter(t => !isNaN(t)).forEach(t => console.log(t));
console.log('++++++++++');
var colors = (_b = { red: 0, green: 1, blue: 2 }, _b[0] = "red", _b[1] = "green", _b[2] = "blue", _b);
Object.keys(colors).forEach(function (t) { return console.log(t + ' is typeof ' + typeof t); });
var MyEnum;
(function (MyEnum) {
    MyEnum[MyEnum["FOO"] = 0] = "FOO";
    MyEnum[MyEnum["BAR"] = 1] = "BAR";
    MyEnum[MyEnum["BAZ"] = 2] = "BAZ";
})(MyEnum || (MyEnum = {}));
;
console.log('-------------');
Object.values(MyEnum).forEach(function (v) { return console.log(v); });
// --------------- map
console.log(':::::::::::::::::::::::::::::::::::');
var Man = /** @class */ (function () {
    function Man(name) {
        this.name = name;
    }
    return Man;
}());
var Soldier = /** @class */ (function () {
    function Soldier(man) {
        this.man = man;
    }
    return Soldier;
}());
var names = ['John', 'Jim', 'Hugo', 'Bob'];
var exclude = ['Hugo'];
var excludeHugo = names.includes(exclude[0]);
console.log('We should exclude Hugo: ' + excludeHugo);
// let men: Man[] = names.map(name => {return new Man(name)}) as Man[];
// men.forEach(man => console.log('And god created '+man.name));
var soldiers = names.map(function (name) { console.log('creating ' + name); return new Man(name); }).map(function (man) { console.log('making ' + man.name + ' a soldier'); return new Soldier(man); });
console.log('Gods own army:');
soldiers.forEach(function (s) { return console.log(s.man.name); });
//---------------------------- more arrays
console.log('//---------------------------- more arrays');
var choicesArray = ['Foo', 'Bar', 'Baz'];
var selectionArray = [false, true, false];
var madeChoiceArray = [];
selectionArray.forEach(function (value, i) {
    console.log('%d: %s', i, value);
    if (value) {
        madeChoiceArray.push(choicesArray[i]);
    }
});
madeChoiceArray.forEach(function (e) { return console.log(e); });
