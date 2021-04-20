package easy;

import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {
  public int getImportance(List<Employee> employees, int id) {
    HashMap<Integer, Employee> maps = new HashMap<>();
    for (Employee x : employees) {
      maps.put(x.id, x);
    }
    if (!maps.containsKey(id)) return 0;
    return dfs(maps, id);
  }

  private int dfs(HashMap<Integer, Employee> maps, int start) {
    Employee e = maps.get(start);
    int sum = e.importance;
    for (int i : e.subordinates) {
      sum += dfs(maps, i);
    }
    return sum;
  }
}

class Employee {
  public int id;
  public int importance;
  public List<Integer> subordinates;
};

