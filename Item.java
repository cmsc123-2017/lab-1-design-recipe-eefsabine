class Item{
 double discount;
 double price;

 final int SALE_LIMIT = 1000;

 Item(double discount, double price){
  this.discount = discount;
  this.price = price;
 }
// -> double
//Returns the price of an item, reduced by the given sale percentage
double computeSalePrice(){
 return price - (price * discount);
}

//double, double -> double
// Given the item price and the sale percentage, apply the sale to
//item price if exceeds 200, otherwise return the original price 
double salePrice1000(){
 if(price > SALE_LIMIT){
  return computeSalePrice();
 }
 else{
  return price;
 }
}
}