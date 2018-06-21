class CCipher:
  def decode(self, cipherText, shift):
    voc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    ans = []
    m = len(voc)
    for i in cipherText:
      val = ((ord(i) - ord('A'))  - shift + m) % m
      ans.append(voc[val])
    return(''.join(ans))
