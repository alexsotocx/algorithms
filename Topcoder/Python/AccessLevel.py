class AccessLevel:
  def has_access(self, min_r, right):
    return 'A' if right >= min_r else 'D'
  def canAccess(self, rights, minPermission):
   ans = [ self.has_access(minPermission, right) for right in rights ]
   return "".join(ans)
