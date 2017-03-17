package com.google.array;

import java.util.Arrays;

import org.junit.Test;

/**
 * Created by ychang on 3/15/2017.
 */
public class RotateImageTest {

  @Test
  public void rotate() throws Exception {
    // Given
    RotateImage rotateImage = new RotateImage();
    int[][] array = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    System.out.println(Arrays.deepToString(array));
    // or System.out.println(Arrays.toString(doubleArray)); for 1-d array
    System.out.println("************************************");
    printArray(array);
    System.out.println("Clockwise ************************************");

    // When
    rotateImage.rotate(matrix);
    printArray(matrix);
    System.out.println("Anti-Clockwise ************************************");

    // When
    rotateImage.rotate_antiClockwise(array);
    printArray(array);
  }

  private void printArray(int[][] array) {
    Arrays.stream(array).forEach(nums -> {
      Arrays.stream(nums).forEach(num -> System.out.printf("%1$3s", num + " "));
      System.out.println();
    });
  }

}