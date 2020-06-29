import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/shared/services/product.service';
import { Product } from 'src/app/shared/models/product';
import { publishers } from 'src/app/shared/mock-data/publisher-list';
import { Subscription } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-product-form',
  templateUrl: './admin-product-form.component.html',
  styleUrls: ['./admin-product-form.component.scss'],
})
export class AdminProductFormComponent implements OnInit {
  defaultTikiNow = 'false';
  publishers = [];
  subscription: Subscription;
  productForm: FormGroup;

  constructor(private fb: FormBuilder, private productService: ProductService) {}

  ngOnInit(): void {
    this.publishers = publishers;
    this.productForm = this.fb.group({
      title: this.fb.control('',Validators.required),
      //publisher: this.fb.control(this.product.publisher, [Validators.required, Validators.pattern('(http(s?):)([/|.|\w|\s|-])*\.(?:jpg|gif|png|jpeg)')]),
      publisher: this.fb.control('',[Validators.required]),
      imageUrl: this.fb.control('',[Validators.required] ),
      publishedDate: this.fb.control('',[Validators.required]),
      author: this.fb.control('',[Validators.required]),
      size: this.fb.control('',[Validators.required]),
      finalPrice: this.fb.control('',[Validators.required]),
      pageCount: this.fb.control('',[Validators.required]),
      regularPrice: this.fb.control('',[Validators.required]),
      isTikiNow: this.fb.control('',[Validators.required]),
    });
  }

  addProduct(addForm): void {
    const publisher = publishers.find(
      (ele) => ele.id === addForm.value.publisher
    );
    const product = new Product({
      ...addForm.value,
      publisher: publisher ? publisher.value : '',
    });
    this.subscription = this.productService
      .createProduct(product)
      .subscribe((result) => console.log(result));
  }
}
