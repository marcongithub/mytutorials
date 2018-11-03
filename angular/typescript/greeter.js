"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const rxjs_1 = require("rxjs");
const observable = rxjs_1.Observable.create(function (observer) {
    observer.next(1);
    observer.next(2);
    observer.next(3);
    setTimeout(() => {
        observer.next(4);
        observer.complete();
    }, 1000);
});
var result = 0;
setTimeout(function () {
    result++;
    console.log('Hello node:' + result);
}, 2);
console.log('Bye ' + result);
