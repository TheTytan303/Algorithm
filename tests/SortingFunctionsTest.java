package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SortingFunctions.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SortingFunctionsTest {
    private int[] inputTab;
    private int[] expectedResultTab;

    @BeforeEach
    void init(){
        inputTab = new int[] {2,1,6,3,4,9,5,8,10,7};
        expectedResultTab = new int[]{1,2,3,4,5,6,7,8,9,10};
    }


    @Test
    void selectSortTest(){
        assertTimeout(Duration.ofMillis(100), ()-> SortingFunctions.selectSort(inputTab));
        assertArrayEquals(expectedResultTab, inputTab);
    }
    @Test
    void bubbleSortTest(){
        assertTimeout(Duration.ofMillis(100), ()->SortingFunctions.bubbleSort(inputTab));
        assertArrayEquals(expectedResultTab, inputTab);
    }
    @Test
    void heapSortTest(){
        assertTimeout(Duration.ofMillis(100), ()->SortingFunctions.heapSort(inputTab));
        assertArrayEquals(expectedResultTab, inputTab);
    }
    @Test
    void shellSortTest(){
        assertTimeout(Duration.ofMillis(100), ()->SortingFunctions.shellSort(inputTab));
        assertArrayEquals(expectedResultTab, inputTab);
    }
    @Test
    void cocktailSortTest(){
        assertTimeout(Duration.ofMillis(100), ()->SortingFunctions.cocktailSort(inputTab));
        assertArrayEquals(expectedResultTab, inputTab);
    }
}