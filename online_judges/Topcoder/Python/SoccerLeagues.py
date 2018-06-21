class SoccerLeagues:
  h_score = {'W': 3, 'D': 1, 'L': 0, '-': 0}
  v_score = {'W': 0, 'D': 1, 'L': 3, '-': 0}

  def points(self, matches):
    teams = len(matches)
    points = [0 for _ in xrange(teams)]
    for i in xrange(teams):
      for j in xrange(teams):
        points[i] += self.h_score[matches[i][j]]
        points[j] += self.v_score[matches[i][j]]
    return points
