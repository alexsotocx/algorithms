from Queue import PriorityQueue


class OfficeParking:
  def spacesUsed(self, events):
    parking = []
    whereIsParked = {}
    slots = PriorityQueue()
    for event in events:
      name, action = event.split(" ")
      if action == "arrives":
        if slots.empty():
          parking.append(name)
          whereIsParked[name] = len(parking) - 1
        else:
          n = slots.get()
          parking[n] = name
          whereIsParked[name] = n
      else:
        n = whereIsParked.pop(name)
        parking[n] = None
        slots.put(n)

    return len(parking)


