import {Component, OnInit} from '@angular/core'
import {CurrentPrice, Product} from './product';
import {NgForm} from '@angular/forms';
import {ProductService} from "./product-search.service";

@Component({
  selector: ' product-search',
  templateUrl: './product-search.component.html'
})

export class ProductSearchComponent implements OnInit {

  productResponse: Object = new Object();

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
  }

  getProduct(id: string): void {
    this.productService.getProductById(id).then(product => this.productResponse = product);
  }

  updateProduct(productData: Product): void {
    console.log(productData);
    this.productService.updateProduct(productData)
      .then(updatedProduct => this.productResponse = updatedProduct);
  }
}
