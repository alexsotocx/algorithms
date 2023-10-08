from typing import List
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


def inbounds(x: int, bound: (int, int)) -> bool:
    return bound[0] <= x <= bound[1]


def flood(matrix: List[List[int]], x: int, y: int) -> int:
    sumS = 1
    matrix[x][y] = 2
    for i in range(4):
        xc = dx[i] + x
        yc = dy[i] + y
        if inbounds(xc, (0, len(matrix) - 1)) and inbounds(yc, (0, len(matrix[0]) - 1)):
            if matrix[xc][yc] == 1:
                sumS += flood(matrix, xc, yc)
    return sumS


def riverSizes(matrix: List[List[int]]) -> List[int]:
    response: list[int] = []

    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if matrix[i][j] == 1:
                response.append(flood(matrix, i, j))

    return response
