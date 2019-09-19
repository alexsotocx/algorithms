class ASeries:
   def longest(self, values):
     sorted_values = sorted(values)
     longest = 0
     diff = 0
     new_serie = True
     ac = 0
     i = 0
     while i < len(sorted_values) - 1:
       current = sorted_values[i]
       next = sorted_values[i + 1]
       if new_serie or (diff == next - current):
         diff = next - current
         new_serie = False
         ac += 1
       else:
         diff = 0
         i -= 1
         new_serie = True
         ac = 0
       i += 1
       longest = ac if longest < ac else longest
  
     return longest + 1
     
t = (1, 1, 1, 1)
print(ASeries().longest(t))
          
