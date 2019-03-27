package com.google.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BestTimeBuySellStockIIITest {

    @Test
    public void maxProfit() {
        // Given
        BestTimeBuySellStockIII bestTimeBuySellStockIII = new BestTimeBuySellStockIII();
        int[] stock = new int[]{3,3,5,0,0,3,1,4};
//        int[] stock = new int[]{3, 9, 8, 15};

        // When
        int maxProfit = bestTimeBuySellStockIII.maxProfit(stock);

        // Then
        assertThat(maxProfit, is(6));
    }
}