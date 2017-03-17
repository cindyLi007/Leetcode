package interview.tdd;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by ychang on 2/15/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeCreatorTest {
  @Mock
  IDb mockIDb;
  @Mock
  Employee mockEmployee;
  EmployeeCreator instance;

  @Before
  public void setUp() throws Exception {
    instance = new EmployeeCreator(mockIDb);
  }

  @Test
  public void test_create_setTrue() throws Exception {
    // Given
    when(mockEmployee.getState()).thenReturn(State.MT);

    // When
    instance.create(mockEmployee);

    // Then
    verify(mockIDb,  times(1)).insert(mockEmployee);
    verify(mockEmployee, times(1)).setTaxExempt(true);
  }

  @Test
  public void test_create_setFalse() throws Exception {
    // Given
    when(mockEmployee.getState()).thenReturn(State.VA);

    // When
    instance.create(mockEmployee);

    // Then
    verify(mockIDb,  times(1)).insert(mockEmployee);
    verify(mockEmployee, never()).setTaxExempt(anyBoolean());
  }

}