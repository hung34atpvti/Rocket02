import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { products } from 'src/app/shared/mock-data/product-list';
import { Product } from 'src/app/shared/models/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss'],
})

export class ProductListComponent implements OnInit {
  @Output() selectProduct = new EventEmitter<String>();
  products: Product[] = [];
  publishers: string[];
  authors: string[];
  originProducts: Product[] = [];

  constructor() {}

  ngOnInit(): void {
    this.originProducts = products;
    this.products = products;
    const publishersObj = {};
    const authorsObj = {};
    products.forEach((ele) => {
      publishersObj[ele.publisher] = ele.publisher;
      authorsObj[ele.author] = ele.author;
    });
    this.publishers = Object.keys(publishersObj);
    this.authors = Object.keys(authorsObj);
  }

  onSelectedProduct(productId): void {
    this.selectProduct.emit(productId);
  }

  search(searchValue): void {
    const lsSearchValue = searchValue.toLocaleLowerCase();
    this.products=this.originProducts.filter(
      ele => ele.title.toLocaleLowerCase().includes(lsSearchValue)
      || ele.author.toLocaleLowerCase().includes(lsSearchValue)
    );
  }


}
