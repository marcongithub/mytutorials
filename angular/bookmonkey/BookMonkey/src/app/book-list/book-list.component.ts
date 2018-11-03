import { Component, OnInit, Output, EventEmitter } from '@angular/core';

import { Book, Thumbnail } from '../shared/book';
import {BookStoreService} from '../shared/book-store.service';

@Component({
  templateUrl: './book-list.component.html'
})
export class BookListComponent implements OnInit {
  books: Book[];

  constructor(private bs: BookStoreService){}

  ngOnInit() {
    this.books = this.bs.getAll();
  }

}
