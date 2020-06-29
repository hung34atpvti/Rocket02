import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminProductDetailComponent } from './product/admin-product-detail/admin-product-detail.component';
import { AdminProductListComponent } from './product/admin-product-list/admin-product-list.component';
import { AdminProductFormComponent } from './product/admin-product-form/admin-product-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminProductReactiveFormComponent } from './product/admin-product-reactive-form/admin-product-reactive-form.component';

@NgModule({
  declarations: [
    AdminProductDetailComponent,
    AdminProductListComponent,
    AdminProductFormComponent,
    AdminProductReactiveFormComponent
  ],
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  exports: [
    AdminProductListComponent,
    AdminProductDetailComponent,
    AdminProductFormComponent,
    AdminProductReactiveFormComponent
  ],
})
export class AdminModule {}
