class Solution:
    def simplifyPath(self, path: str) -> str:
        actions = path.split("/")
        q = []
        for a in actions:
            if a == "":
                continue
            elif a == ".":
                continue
            elif a == "..":
                if len(q) > 0:
                    q.pop()
            else:
                q.append(a)

        return f"/{'/'.join(q)}"

