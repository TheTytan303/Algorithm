package tests;

import org.junit.jupiter.api.BeforeEach;
import solution_4.*;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class solution_4Test {
    private float[] inputArray ;
    @BeforeEach
    void init(){
        inputArray = new float[]{2, 7, 1, 15};
    }
    @Test
    void solution_ShouldReturn0and1(){
        assertArrayEquals(new int[] {0,1},solution_4.solution(inputArray, 9) );
    }
    @Test
    void solution_ShouldThrowException(){
        assertThrows(NoSuchElementException.class,()-> solution_4.solution(inputArray, 1) );
    }
    @Test
    void solution_ShouldThrowNullPointerException(){
        assertThrows(NullPointerException.class, ()->solution_4.solution(null, 1));
    }
}