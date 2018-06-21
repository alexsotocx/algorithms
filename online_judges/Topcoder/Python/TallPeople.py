class TallPeople:
  def getPeople(self, people):
    people_height =  [map(int, list_height.split()) for list_height in people]
    smallest = [ 1001 for i in range(len(people_height))]
    tallest = [ 0 for i in range(len(people_height[0]))]
    for i in xrange(len(people_height)):
      for j in xrange(len(people_height[0])):
        smallest[i] = min(smallest[i], people_height[i][j])
        tallest[j] = max(tallest[j], people_height[i][j])
    return([max(smallest), min(tallest)])
