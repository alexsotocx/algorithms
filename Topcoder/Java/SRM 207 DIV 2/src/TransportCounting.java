public class TransportCounting {

  public int countBuses(int speed, int[] positions, int[] velocities, int time) {
    int finalPosition = speed * time;
    int buses = 0;
    for (int i = 0; i < positions.length; i++) {
      if (velocities[i] * time + positions[i] <= finalPosition || positions[i] == 0)
        buses++;
    }

    return buses;

  }
}
