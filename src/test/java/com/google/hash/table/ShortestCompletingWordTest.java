package com.google.hash.table;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ShortestCompletingWordTest {

    @Test
    public void shortestCompletingWord() {
        // Given
        ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();

        // When
        String completingWord = shortestCompletingWord.shortestCompletingWord("1s3 PSt",
                new String[]{"step", "steps", "stripe", "stepple"});

        // Then
        assertThat(completingWord, is("steps"));
    }
}