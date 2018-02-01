import { Component, OnInit } from '@angular/core'
import { Product } from './product';
import { NgForm } from '@angular/forms';

@Component( {
  selector: ' product-search',
  templateUrl: './product-search.component.html'
})

export class ProductSearchComponent implements OnInit {

  products: Product[];
  newProduct: Product = new Product();

  ngOnInit(): void {
;
  }

  getProduct( id: string ): void {

  }

  updateProduct( productForm: NgForm ) :void {

  }


}
