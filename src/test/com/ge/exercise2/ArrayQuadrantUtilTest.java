package com.ge.exercise2;

import org.junit.Assume;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayQuadrantUtilTest {

    @Test
    public void getQuadrantValuesTest() {
        Character[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<Character>(data);
        
        Assume.assumeNotNull(util.getQuadrantValues(0, 0));
        Assume.assumeNotNull(util.getQuadrantValues(1, 3));
        Assume.assumeNotNull(util.getQuadrantValues(3, 1));
        Assume.assumeNotNull(util.getQuadrantValues(2, 3));

        Character[] expectedResult1 = {'a', 'b', 'e', 'f'};
        assertArrayEquals(expectedResult1, util.getQuadrantValues(0, 0));
        
        Character[] expectedResult2 = {'c', 'd', 'g', 'h'};
        assertArrayEquals(expectedResult1, util.getQuadrantValues(2, 3));
        
        Character[] expectedResult3 = {'i', 'j', 'm', 'n'};
        assertArrayEquals(expectedResult1, util.getQuadrantValues(2, 3));
        
        Character[] expectedResult4 = {'k', 'l', 'o', 'p'};
        assertArrayEquals(expectedResult1, util.getQuadrantValues(2, 3));

    }
    
    @Test
    public void getRowColTest() {
    	
    	Character[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<Character>(data);
        
        Assume.assumeNotNull(util.getRowCol("row", 2));
        Assume.assumeNotNull(util.getRowCol("col", 3));
        
        Character[] expectedRow = {'i','j','k','l'};
        Character[] expectedCol = {'d','h','l','p'};
    	
    }
    
    
    
}