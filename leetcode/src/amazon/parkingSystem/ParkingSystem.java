package amazon.parkingSystem;

import java.util.HashMap;

class ParkingSystem {
  HashMap<Integer, Integer> available = new HashMap<>();
  public ParkingSystem(int big, int medium, int small) {
    available.put(1, big);
    available.put(2, medium);
    available.put(3, small);
  }

  public boolean addCar(int carType) {
    int freeSpaces = available.getOrDefault(carType, 0);
    if (freeSpaces  == 0) return false;
    available.put(carType, freeSpaces - 1);
    return  true;
  }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
