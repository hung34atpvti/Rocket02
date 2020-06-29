import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { Product } from 'src/app/shared/models/product';
import { products } from 'src/app/shared/mock-data/product-list';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss'],
})
export class ProductDetailComponent implements OnInit, OnChanges {
  @Input() productId: string;
  product: Product;
  constructor() {}

  ngOnInit(): void {}

  

  ngOnChanges(productId: { previousValue; currentValue; firstChange }) {
    this.product = products.find((ele) => ele.id === this.productId);
  }
}
