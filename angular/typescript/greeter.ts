import { Observable } from 'rxjs';
import { Observer } from 'rxjs';

const observable: Observable<any> = Observable.create(function (observer: Observer<any>) {
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
  console.log('Hello node:'+result);
}, 2);
console.log('Bye '+result);
