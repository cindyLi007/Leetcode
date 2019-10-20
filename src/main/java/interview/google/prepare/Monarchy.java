package interview.google.prepare;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Person {
  public String name;
  public List<Person> children;
  public Boolean isDead;

  public Person (String aName) {
    name = aName;
    isDead = false;
    children = new ArrayList<>();
  }
}

public class Monarchy {
  HashMap<String, Person> personMap;
  Person root;

  public Monarchy (String king) {
    personMap = new HashMap<>();
    root = new Person(king);
    personMap.put(king, root);
  }

  public void birth (String child, String parent) {
    Person parentObj = personMap.get(parent);
    Person childObj = new Person(child);
    parentObj.children.add(childObj);
    personMap.put(child, childObj);
  }

  public void death (String name) {
    personMap.get(name).isDead = true;
  }

  public String getNext(String name) {
    Person person = getNext(name, root);
    return person == null ? "not found" : person.name;
  }

  private Person getNext(String name, Person root) {
    if (root.name.equals(name)) {
      if (root.children.size() > 0) return root.children.get(0);
      // we find the person, but this person does not have children, we its next should be its sibling
      else return new Person("");
    } else {
      for (int i=0; i<root.children.size(); i++) {
        Person child = root.children.get(i);
        Person p = getNext(name, child);
        if (p!=null) {
          if (StringUtils.isNotEmpty(p.name)) return p;
          if (i<root.children.size()-1) return root.children.get(i+1);
          // it is the last child of its parent, so should return to its' uncle
          return p;
        }
      }
      return null;
    }
  }

  public List<String> getOrderOfSuccession() {
    List<String> res = new ArrayList();
    getOrderOfSuccession(root, res);
    return res;
  }

  private void getOrderOfSuccession(Person root, List<String> succession) {
    succession.add(root.name);
    for (Person child : root.children) {
      getOrderOfSuccession(child, succession);
    }
  }

  // should be [King, Andy, Matthew, Bob, Alex, Asha, Catherine]
  public static void main(String[] args) {
    Monarchy m = new Monarchy("king");
    m.birth("andy", "king");
    m.birth("bob", "king");
    m.birth("cath", "king");
    m.birth("matt", "andy");
    m.birth("alex", "bob");
    m.birth("asha", "bob");
    List<String> list = m.getOrderOfSuccession();
    System.out.println(m.getNext("Catherine"));
    System.out.println(list.toString());
  }

}
