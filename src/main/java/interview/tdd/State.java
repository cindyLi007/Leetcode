package interview.tdd;

/**
 * Created by Grace on 2/15/2017.
 */
public enum State {
  VA("Virginia"), TX("Texas"), MT("Montana"), OR("Oregon");
  private String description;

  State(String name) {
    this.description = name;
  }
}
