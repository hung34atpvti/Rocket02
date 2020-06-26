import { Component, OnInit, Output } from '@angular/core';
import { Product } from 'src/app/shared/models/product';
import { products } from 'src/app/shared/mock-data/product-list';
import { ProductService } from 'src/app/shared/services/product.service';

@Component({
  selector: 'app-admin-product-list',
  templateUrl: './admin-product-list.component.html',
  styleUrls: ['./admin-product-list.component.scss'],
})
export class AdminProductListComponent implements OnInit {
  @Output() selectedProduct: Product;
  products: Product[] = [];
  isForm: boolean;

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.products = products;

    this.productService.$newProduct.subscribe(p=>{
      products.push(p);
      this.isForm = false;
    });
  }

  viewDetail(p): void {
    this.selectedProduct = p;
  }

  newForm(): void {
    this.isForm = true;
  }
}
