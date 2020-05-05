package object_oriented_design.locker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class LockerSystem {
  private List<Stack<Slot>> freeSlotsPerSize;
  private HashMap<Package, Slot> occupiedSlots;

  public LockerSystem(List<Stack<Slot>> freeSlotsPerSize) {
    this.freeSlotsPerSize = freeSlotsPerSize;
    occupiedSlots = new HashMap<>();
  }

  public LockerSystem(List<SizeEnum> sizes, List<Integer> slotPerSize) {
    freeSlotsPerSize = new ArrayList<>();
    occupiedSlots = new HashMap<>();
    for(int i = 0; i < sizes.size(); i++) {
      int slotsAmount = slotPerSize.get(i);
      SizeEnum size = sizes.get(i);
      Stack<Slot> slots = new Stack<>();
      while(slotsAmount > 0) {
        slots.push(new Slot(size, "" + size.name() + "" + i));
        slotsAmount--;
      }
      freeSlotsPerSize.add(slots);
    }
  }

  public Slot placePackage(Package p) {
    if(occupiedSlots.containsKey(p)) throw new Error("Package already placed");
    Slot freeSpot = this.findExtractSlot(p.getSize());
    if(freeSpot == null) throw new Error("Lockers are full, package can't be placed");
    occupiedSlots.put(p, freeSpot);
    return freeSpot;
  }

  private Slot findExtractSlot(SizeEnum size) {
    for(Stack<Slot> slots: freeSlotsPerSize) {
      if(slots.isEmpty()) continue;
      if(slots.peek().getSize().compareTo(size) < 0) continue;
      return slots.pop();
    }
    return null;
  }

  public Slot removePackage(Package p) {
    if(!occupiedSlots.containsKey(p)) throw new Error("Package is not in the system");
    Slot slot = occupiedSlots.get(p);
    freeSlotsPerSize.get(slot.getSize().getSizeCode()).push(slot);
    occupiedSlots.remove(p);
    return slot;
  }
}
