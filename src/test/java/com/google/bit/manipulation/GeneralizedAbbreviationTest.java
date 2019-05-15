package com.google.bit.manipulation;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GeneralizedAbbreviationTest {

    @Test
    public void generateAbbreviations() {
        // Given
        GeneralizedAbbreviation generalizedAbbreviation = new GeneralizedAbbreviation();

        // When
        List<String> res = generalizedAbbreviation.generateAbbreviations("word");

    }
}