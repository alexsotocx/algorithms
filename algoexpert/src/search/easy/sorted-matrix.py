def searchInSortedMatrix(matrix, target):
    i = 0
    j = len(matrix[0]) -1

    while i >= 0 and j >= 0:
        t = matrix[i][j]
        if t == target:
            return [i, j]
        elif t > target:
            j -= 1
        else:
            i += 1
    return [-1, -1]
