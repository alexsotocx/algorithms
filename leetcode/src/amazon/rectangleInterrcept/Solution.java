package amazon.rectangleInterrcept;

class Solution {
  private class Point {
    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    boolean equal(Point p) {
      return x == p.x && y == p.y;
    }
  }

  private class Rectangle {
    Point leftBottom;
    Point rightUpper;

    double m, intercept;

    Rectangle(int[] rec) {
      leftBottom = new Point(rec[0], rec[1]);
      rightUpper = new Point(rec[2], rec[3]);
      m = (1.0 * (rightUpper.y - leftBottom.y)) / (1.0 * (rightUpper.x - leftBottom.x));
      intercept = leftBottom.y - m * leftBottom.x;
    }

    boolean overlap(Rectangle b) {
      for (Point p : b.getPoints()) {
        double x = p.x * 1.0;
        double y = m * x + intercept;
        boolean insideB = b.leftBottom.x <= x &&
          b.rightUpper.x >= x &&
          b.rightUpper.y >= y &&
          b.leftBottom.y <= y;
        boolean insideA = leftBottom.x < x &&
          rightUpper.x > x &&
          rightUpper.y > y &&
          leftBottom.y < y;
        if (insideA && insideB) return true;
      }


      return false;
    }

    Point[] getPoints() {
      return new Point[]{leftBottom, rightUpper};
    }


  }

  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    Rectangle a = new Rectangle(rec1);
    Rectangle b = new Rectangle(rec2);
    return a.overlap(b) || b.overlap(a);
  }
}

