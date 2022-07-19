from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == word[0] and self.util(board, word, i, j, 0):
                    return True

        return False

    def util(self, board: List[List[str]], word: str, i: int, j: int, pos: int) -> bool:
        if not (0 <= i < len(board) and 0 <= j < len(board[i])):
            return False
        if pos == len(word) - 1:
            return True
        if word[pos] != board[i][j]:
            return False

        temp, board[i][j] = board[i][j], "#"
        tx = [0, 1, 0, -1]
        ty = [1, 0, -1, 0]
        for k in range(4):
            if (self.util(board, word, i + tx[k], j + ty[k], pos + 1)):
                return True

        board[i][j] = temp
        return False


assert Solution().exist(
    [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "ABCCED")
