
public class WaiterTipping {

  public int maxPercent(int total, int taxPercent, int money) {
    //
    for(int tip = 0; true; tip++){
      if(total + Math.floor(total*taxPercent/100) + Math.floor(total*tip/100) > money)
        return tip -1;
    }
  }
}
