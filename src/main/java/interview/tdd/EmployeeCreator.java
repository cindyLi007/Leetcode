package interview.tdd;

import static interview.tdd.State.MT;
import static interview.tdd.State.OR;

/**
 * Created by Grace Chang on 2/15/2017.
 */
public class EmployeeCreator {
  private IDb idb;

  public Employee create(Employee employee) {
    if (employee.getState().equals(MT) || employee.getState().equals(OR)) {
      employee.setTaxExempt(true);
    }

    idb.insert(employee);

    return employee;
  }

  EmployeeCreator(IDb idb) {
    this.idb = idb;
  }
}
