package com.google.string;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

/**
 * Created by ychang on 3/31/2017.
 */
public class LicenseKeyFormattingTest {
  @Test
  public void licenseKeyFormatting() throws Exception {
    // Given
    LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();

    // When
    String keyFormatting = licenseKeyFormatting.licenseKeyFormatting("a-a-a-a-", 1);

    // Then
    assertThat(keyFormatting, is("24A0-R74K"));
  }

}