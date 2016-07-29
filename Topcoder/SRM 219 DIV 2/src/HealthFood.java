import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HealthFood {

  public int[] selectMeals(int[] protein, int[] carbs, int[] fat, String[] dietPlans) {
    List<Meal> allMeals = new ArrayList<Meal>();
    for (int i = 0; i < carbs.length; i++)
      allMeals.add(new Meal(carbs[i], fat[i], protein[i], i));
    int[] ans = new int[dietPlans.length];
    for (int i = 0; i < dietPlans.length; i++) {
      //System.out.println(">>>>>>>>>>>>>>>>");
      String dietPlan = dietPlans[i];
      List<Meal> meals = allMeals;
      if (dietPlan.length() > 0) {
        for (char d : dietPlan.toCharArray()) {
          meals = orderMeals(d, meals);
          //System.out.println("Evaluating meals with " + d + " \n " + meals);
          if (meals.size() == 1) break;
        }
        if(meals.size() > 1) meals.sort(new Comparator<Meal>() {
          public int compare(Meal o1, Meal o2) {
            return Integer.compare(o1.i, o2.i);
          }
        });
        ans[i] = meals.get(0).i;
      }
    }
    return ans;

  }

  public List<Meal> orderMeals(char d, List<Meal> meals) {
    List<Meal> returMeals = new ArrayList<Meal>();
    switch (d) {
      case 'C':
        meals.sort(new Comparator<Meal>() {
          public int compare(Meal o1, Meal o2) {
            return Integer.compare(o1.c, o2.c) * -1;
          }
        });
        break;
      case 'F':
        meals.sort(new Comparator<Meal>() {
          public int compare(Meal o1, Meal o2) {
            return Integer.compare(o1.f, o2.f) * -1;
          }
        });
        break;
      case 'P':
        meals.sort(new Comparator<Meal>() {
          public int compare(Meal o1, Meal o2) {
            return Integer.compare(o1.p, o2.p) * -1;
          }
        });
        break;
      case 'T':
        meals.sort(new Comparator<Meal>() {
          public int compare(Meal o1, Meal o2) {
            return Integer.compare(o1.t, o2.t) * -1;
          }
        });
        break;
      case 'c':
        meals.sort(new Comparator<Meal>() {
          public int compare(Meal o1, Meal o2) {
            return Integer.compare(o1.c, o2.c);
          }
        });
        break;
      case 'f':
        meals.sort(new Comparator<Meal>() {
          public int compare(Meal o1, Meal o2) {
            return Integer.compare(o1.f, o2.f);
          }
        });
        break;
      case 'p':
        meals.sort(new Comparator<Meal>() {
          public int compare(Meal o1, Meal o2) {
            return Integer.compare(o1.p, o2.p);
          }
        });
        break;
      case 't':
        meals.sort(new Comparator<Meal>() {
          public int compare(Meal o1, Meal o2) {
            return Integer.compare(o1.t, o2.t);
          }
        });
        break;
    }
    d = Character.toUpperCase(d);
    Meal initialMeal = meals.get(0);
    switch (d) {
      case 'P':
        for (Meal meal : meals) {
          if (meal.p == initialMeal.p)
            returMeals.add(meal);
          else
            break;
        }
        break;
      case 'C':
        for (Meal meal : meals) {
          if (meal.c == initialMeal.c)
            returMeals.add(meal);
          else
            break;
        }
        break;
      case 'F':
        for (Meal meal : meals) {
          if (meal.f == initialMeal.f)
            returMeals.add(meal);
          else
            break;
        }
        break;
      case 'T':
        for (Meal meal : meals) {
          if (meal.t== initialMeal.t)
            returMeals.add(meal);
          else
            break;
        }
        break;
    }
    return returMeals;
  }

  public class Meal {
    public int c, f, p, i, t;

    public Meal(int c, int f, int p, int i) {
      this.c = c;
      this.f = f;
      this.p = p;
      this.t = 9 * f + 5 * c + 5*p;
      this.i = i;
    }

    @Override
    public String toString() {
      return "C => " + c + " F => " + f + " P => " + p + " I => " + i ;
    }
  }
}
