import java.util.Collections;
import java.util.HashSet;

public class UserName {

  public String newMember(String[] existingNames, String newName) {
    HashSet<String> names = new HashSet<String>();
    Collections.addAll(names, existingNames);
    String copyNewName = newName;
    int con = 1;
    while (names.contains(copyNewName)) {
      copyNewName = newName + "" + (con++);
    }
    return copyNewName;
  }
}
