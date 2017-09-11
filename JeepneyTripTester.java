import junit.framework.TestCase;

public class JeepneyTripTester extends TestCase {
  
  public void testX() {
    JeepneyTrip j = new JeepneyTrip(5, 5, 3);
    
    assertEquals(5.0, j.distance);
    assertEquals(5, j.totalPassengers);
    assertEquals(3, j.discountPassengers);
  }
  
   public void testChangeWithDiscount() {
    JeepneyTrip j = new JeepneyTrip(5, 1, 1);
    JeepneyTrip j1 = new JeepneyTrip(5,2,1); 
    JeepneyTrip j2 = new JeepneyTrip(10,5,1);
    
    assertEquals(4.0, j.fareChange(10));
    assertEquals(7.0,j1.fareChange(20));
    assertEquals(3.5,j2.fareChange(50));
  }
   
   public void testChangeWithoutDiscount() {
    JeepneyTrip j = new JeepneyTrip(5, 1, 0);
    JeepneyTrip j2 = new JeepneyTrip(10,5,0);
    
    assertEquals(3.0, j.fareChange(10));
    assertEquals(43.0, j.fareChange(50));
  }
   
   public void testComputeFare() {
     JeepneyTrip j = new JeepneyTrip(5, 1, 1);
     JeepneyTrip j1 = new JeepneyTrip(5, 1, 0);
     
      assertEquals(7.0, j.computeFare(j.totalPassengers, j.BASE_FARE,5));
      assertEquals(0.0, j1.computeFare(j1.discountPassengers, j1.DISCOUNT,5));
  }
  
  public void testExcessDistance() {
    JeepneyTrip j = new JeepneyTrip(5, 1, 1);
    JeepneyTrip j1 = new JeepneyTrip(5, 1, 0);
    JeepneyTrip j2 = new JeepneyTrip(10, 1, 0);
    
    assertEquals(0.0, j.excessDistance());
    assertEquals(0.0, j1.excessDistance());
    assertEquals(5.0, j2.excessDistance());
  }
  
  public void testTotal(){
     JeepneyTrip j = new JeepneyTrip(5, 1, 0);
     JeepneyTrip j1 = new JeepneyTrip(7, 1, 1);
     JeepneyTrip j2 = new JeepneyTrip(5, 3, 2);
     
     assertEquals(7.0, j.totalFare(1,0,5));
     assertEquals(6.0, j.totalFare(1,1,7));
     assertEquals(19.0, j.totalFare(3,2,5));
  }      
}
