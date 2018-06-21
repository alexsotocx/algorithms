
class grafixClick:
  def checkSaveButton(self, mouseRows, mouseCols):
    total = []
    for i in xrange(len(mouseCols)):
      if self.clickInside(mouseRows[i], mouseCols[i]): total.append(i)
    return total

  def clickInside(self, x, y):
    return (20 <= x <= 39) and (50 <= y <= 99)