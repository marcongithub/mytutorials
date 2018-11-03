import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';

import {Book} from '../shared/book';
import {BookStoreService} from '../shared/book-store.service';

@Component({
  templateUrl: './book-details.component.html'
})
export class BookDetailsComponent implements OnInit {
  book: Book;

  constructor(
    private bs: BookStoreService,
    private route: ActivatedRoute
  ) {
  }

  ngOnInit() {
    const params = this.route.snapshot.params;
    this.book = this.bs.getSingle(params['isbn']);
  }

  getRating() {
    return new Array(this.book.rating);
  }
}
