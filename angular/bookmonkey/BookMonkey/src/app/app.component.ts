import {Component, OnInit} from '@angular/core';
import {Person} from './shared/person';
import {Book} from './shared/book';

@Component({
  selector: 'bm-root',
  // templateUrl: './app.component.html',
  template: `
    <bm-book-list *ngIf="listOn" (showDetailsEvent)="showDetails($event)"></bm-book-list>
    <bm-book-details *ngIf="detailsOn" (showListEvent)="showList()" [book]="book"></bm-book-details>
  `
})
export class AppComponent implements OnInit {
  private title = 'BookMonkey';

  listOn: boolean = true;

  detailsOn = false;

  private person: Person;

  private fbFriendList: Person[];

  private adultFriends: Person[];

  book: Book;


  ngOnInit(): void {
    // simulate some logic
    const personName = 'Horst';
    const personSurname = 'Katzmeier';
    this.person = new Person(personName, personSurname);
    this.fbFriendList = this.loadFbFriendList(this.person);
  }

  showList() {
    this.listOn = true;
    this.detailsOn = false;
  }

  showDetails(book: Book) {
    this.book = book;
    this.listOn = false;
    this.detailsOn = true;
  }

  private loadFbFriendList(person: Person): Person[] {
    const fbRawJson = ['Hans Wurst 23', 'Pippo Paperino 44', 'Fredl Fesl 36', 'Elke Brunzkachel 55', 'Moni Klobürsterl 16'];
    const friends: Person [] = new Array();
    for (const rawName of fbRawJson) {
      const nameAndSurname: string[] = rawName.split(' ');
      const friend: Person = new Person(nameAndSurname[0], nameAndSurname[1]);
      friend.age = Number(nameAndSurname[2]);
      friends.push(friend);
    }

    // filter adults
    this.adultFriends = friends.filter(value => value.age >= 18);


    return friends;
  }

}
