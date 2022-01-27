package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void findPairs() {
        PairFinder pairFinder = new PairFinder();
        int[] array = {7,1,2,4,6,7,4,7,8,9,2,7,9};
        assertEquals(5,pairFinder.findPairs(array));
    }
}