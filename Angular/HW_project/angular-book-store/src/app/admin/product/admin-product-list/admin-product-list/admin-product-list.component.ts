import { Component, OnInit, Output } from '@angular/core';
import { Product } from 'src/app/shared/models/product';
import { products } from 'src/app/shared/mock-data/product-list';

@Component({
  selector: 'app-admin-product-list',
  templateUrl: './admin-product-list.component.html',
  styleUrls: ['./admin-product-list.component.scss'],
})
export class AdminProductListComponent implements OnInit {
  @Output() selectedProduct: Product;
  products: Product[] = [];

  constructor() {}

  ngOnInit(): void {
    this.products = products;
  }

  viewDetail(p): void {
    this.selectedProduct = p;
  }
}
