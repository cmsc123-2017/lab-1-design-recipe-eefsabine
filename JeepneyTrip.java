class JeepneyTrip {
  double distance;
  int totalPassengers;
  int discountPassengers;

  // constants
  final int BASE_KM = 5;
  final double EXCESS = 0.5;
  final int BASE_FARE = 7;
  final int DISCOUNT = 6;
    
  JeepneyTrip(double distance, int totalPassengers, int discountPassengers) {
    this.distance = distance;
    this.totalPassengers = totalPassengers;
    this.discountPassengers = discountPassengers;
  }

  // -> double
  // Returns the excess distance travelled by the passenger, 0 if there's none (excess distance > 5 km)
  double excessDistance(){
    if(distance <= BASE_KM){
      return 0;
    }
    else{
      return distance - BASE_KM;
    }
  }

  // int, double, double -> double
  // Returns the total fare to be paid by the passenger

  double computeFare(int totalPassengers, double fare, double distance){
    return totalPassengers * (fare + (excessDistance() * EXCESS));
  }

  double totalFare(int totalPassengers, int discountPassengers, double distance){
    return computeFare(totalPassengers - discountPassengers, BASE_FARE, distance) +
    computeFare(discountPassengers, DISCOUNT, distance);
  }

  double fareChange(double payment){
    return payment - totalFare(totalPassengers, discountPassengers, distance);
  }
}