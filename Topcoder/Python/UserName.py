class UserName:
  def newMember(self, existingNames, newName):
    existingNames = dict( (x, True) for x in existingNames)
    i = 1
    name = newName
    while name in existingNames:
      name = ''.join([newName, str(i)])
      i += 1
    return name
