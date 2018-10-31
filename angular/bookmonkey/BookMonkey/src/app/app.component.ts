import {Component, OnInit} from '@angular/core';
import {Person} from './shared/person';

@Component({
  selector: 'bm-root',
  templateUrl: './app.component.html',
  styles: []
})
export class AppComponent implements OnInit {
  private title = 'BookMonkey';

  private person: Person;

  private fbFriendList: Person[];

  private adultFriends: Person[];


  ngOnInit(): void {
    // simulate some logic
    const personName = 'Marco';
    const personSurname = 'Bernasconi';
    this.person = new Person(personName, personSurname);
    this.fbFriendList = this.loadFbFriendList(this.person);
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
