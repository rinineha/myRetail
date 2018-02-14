export interface Product {
  id: string;
  name: string;
  currentPrice: CurrentPrice;
}

export interface CurrentPrice {
  value: number;
  currencyCode: string;
}
