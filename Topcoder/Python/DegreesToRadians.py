from math import pi

class DegreesToRadians:
  def convertToRadians(self, degrees, minutes, seconds):
    degrees += minutes/60.0 + seconds/3600.0
    return(degrees * pi / 180.0)