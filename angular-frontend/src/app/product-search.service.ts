import {Injectable} from '@angular/core';
import {Product} from './product';
import {Headers, Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class ProductService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: Http) {
  }

  getProductById(id: String): Promise<Product> {
    return this.http.get(this.baseUrl + '/api/products/' + id)
      .toPromise()
      .then(response => response.json() as Product)
      .catch(this.handleError);
  }

  updateProduct(productData: Product): Promise<Product> {
    return this.http.put(this.baseUrl + '/api/products/' + productData.id, productData)
      .toPromise()
      .then(response => response.json() as Product)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('Some error occured', error);
    return Promise.reject(error.message || error);
  }
}
