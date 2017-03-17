package interview.tdd;

/**
 * Created by Grace on 2/15/2017.
 */
public class Employee {
  private boolean taxExempt;
  private State state;

  public boolean isTaxExempt() {
    return taxExempt;
  }

  public void setTaxExempt(boolean taxExempt) {
    this.taxExempt = taxExempt;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }
}
