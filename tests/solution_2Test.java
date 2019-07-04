package tests;

import org.junit.jupiter.api.*;
import solution_2.solution_2;

import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class solution_2Test {
    private List<Integer> inputList;

    @BeforeEach
    void init(){
        inputList= new ArrayList<>();
    }
    @Test
    void outOfRangeExceptionTest(){
        for(int i=0 ;i<10001; i++){
            inputList.add(i);
        }
        assertThrows(SizeLimitExceededException.class, () -> solution_2.solution(inputList));
    }
    @Test
    void solution_ShouldReturn16_Test(){
        for(int i=0 ;i<16; i++){
            inputList.add(i);
        }
        for(int i=17 ;i<20; i++){
            inputList.add(i);
        }
        try{
            assertEquals(16, solution_2.solution(inputList));
        }catch(Exception e){
            fail("should not throw, but thrown");
        }
    }
    @Test
    void solution_ShouldNotReturnNull_Test(){
        try{
            assertNotNull(solution_2.solution(null));
        }catch(Exception e){
            fail("should not throw, but thrown");
        }
    }
    @Test
    void solution_shouldNotThrow_Test(){
        inputList= new ArrayList<>();
        try{
            assertDoesNotThrow(()->solution_2.solution(inputList));
        }catch(Exception e){
            fail("should not throw, but thrown on empty list");
        }
        try{
            assertDoesNotThrow(()->inputList.add(1000000));
            assertDoesNotThrow(()->inputList.add(-1000000));
        }catch(Exception e){
            fail("should not throw, but thrown at 1 000 000 element");
        }
    }

}