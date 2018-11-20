var Person = /** @class */ (function () {
    function Person(_name, _surname, _age) {
        this._name = _name;
        this._surname = _surname;
        this._age = _age;
    }
    Object.defineProperty(Person.prototype, "name", {
        get: function () {
            return this._name;
        },
        set: function (value) {
            this._name = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "surname", {
        get: function () {
            return this._surname;
        },
        set: function (value) {
            this._surname = value;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "age", {
        get: function () {
            return this._age;
        },
        set: function (value) {
            this._age = value;
        },
        enumerable: true,
        configurable: true
    });
    return Person;
}());
var hugo = new Person('Hugo', 'Meier', 50);
//console.log('Hello '+hugo.name);
var fritz = hugo;
//console.log('Hello '+fritz.name);
var pippo = {
    age: 46,
    name: 'Pippo',
    surname: 'Paperino'
};
//console.log('Hello '+pippo.name);
// Indexable types example, see https://www.typescriptlang.org/docs/handbook/interfaces.html#indexable-types
var map = {};
map['foo'] = 'pippo';
map['bar'] = 'paperino';
var map2 = { horsti: { 'foo': 'pippo', 'bar': 'paperino' } };
console.log(map2.horsti.foo);
var map3 = { 'foo': 'pippo', 'bar': 'paperino' };
console.log(map3.foo);
