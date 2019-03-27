package com.google.graph;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimilarStringGroupTest {

    @Test
    public void numSimilarGroups() {
        // Given
        SimilarStringGroup similarStringGroup = new SimilarStringGroup();
        String[] A = new String[]{"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"};

        // When
        int res = similarStringGroup.numSimilarGroups(A);

        // Then
        assertThat(res, is(5));
    }
}