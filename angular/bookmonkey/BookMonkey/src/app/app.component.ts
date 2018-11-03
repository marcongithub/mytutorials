import {Component, OnInit} from '@angular/core';
import {Book} from './shared/book';

@Component({
  selector: 'bm-root',
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  private title = 'BookMonkey';

  book: Book;

  ngOnInit(): void {

  }


}
