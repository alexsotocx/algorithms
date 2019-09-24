class ASeries:
  def longest(self, sorted_values):
    values = {}
    longest = 0
    diffs = {}
    for i in range(len(sorted_values)):
      current = sorted_values[i]
      values[current] = values[current] + 1 if current in values else 1
      for j in range(i + 1, len(sorted_values)):
        diffs[sorted_values[j] - current] = True

    for diff in diffs:
      for i in sorted_values:
        maxs = 1
        if diff == 0:
          maxs = values[i]
        else:
          j = i + diff
          while j in values:
            maxs += 1
            j += diff
        longest = max(longest, maxs)

    return longest

