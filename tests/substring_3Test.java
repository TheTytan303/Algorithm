package tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import substing_3.*;
import static org.junit.jupiter.api.Assertions.*;

class substring_3Test {

    private String inputString1;
    private String inputString2;
    @BeforeEach
    void init(){
        inputString1 = "abcd";
        inputString2 = "cdabcdab";
    }
    @Test
    void substring_shouldThrownNullPointerException(){
        assertThrows(NullPointerException.class, () ->substring_3.substring(null, inputString2));
    }
    @Test
    void substring_AssertionEquals(){
        assertEquals(3,substring_3.substring(inputString1, inputString2));
    }
    @Test
    void substring_shouldReturn1(){
        assertEquals(-1,substring_3.substring(inputString1, "ghj"));
    }
}