

public class MassiveNumbers {

  public String getLargest(String numberA, String numberB) {
    String[] splitA = numberA.split("\\^");
    String[] splitB = numberB.split("\\^");
    Double a = Double.parseDouble(splitA[0]);
    Double b = Double.parseDouble(splitA[1]);
    Double c = Double.parseDouble(splitB[0]);
    Double d = Double.parseDouble(splitB[1]);
    if (b * Math.log(a) > d * Math.log(c)) {
      return numberA;
    } else {
      return numberB;
    }
  }
}
