package com.google.string;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UniqueEmailAddressTest {

    @Test
    public void numUniqueEmails() {
        // Given
        String[] emails = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();

        // When
        int numUniqueEmails = uniqueEmailAddress.numUniqueEmails(emails);

        // Then
        assertThat(numUniqueEmails, is(2));
    }
}