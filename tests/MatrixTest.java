package tests;

import static org.junit.jupiter.api.Assertions.*;

import macierze.Matrix;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Iterator;

class MatrixTest {
    @Test
    void addElements_forIntegersTest(){
        System.out.println("adding test... ints");
        Matrix<Integer> integerMatrix1   = new Matrix<>((a ,b )-> a+b);
        Matrix<Integer> integerMatrix2   = new Matrix<>((a ,b )-> a+b);
        Integer[][] tab = new Integer[3][4];
        Integer[][] tab2 = new Integer[3][4];
        Integer[][] tab3 = new Integer[3][4];
        for(int i=0; i<3; i++){
            for(int j=0;j<4;j++){
                tab[i][j] = i+j;
                tab2[i][j] =3+4-i-j;
                tab3[i][j] =i+j+3+4-i-j;
            }
        }
        integerMatrix1.buildMatrix(tab);
        integerMatrix2.buildMatrix(tab2);

        Matrix<Integer> result = integerMatrix1.addElements(integerMatrix2);

        assertTimeout(Duration.ofMillis(250),() -> integerMatrix1.addElements(integerMatrix2));
        Matrix<Integer> integerMatrix3 = new Matrix<>((a,b)->a+b);
        integerMatrix3.buildMatrix(tab3);


        Iterator iter = integerMatrix1.iterator();
        for(int i=0; i<3; i++){
            for(int j=0;j<4;j++){
                Integer actual = (Integer)((Matrix.IteratorMatrix) iter).get();
                assertEquals(tab[i][j], actual, "at element: " + i+j);
                iter.next();
            }
        }
        iter = result.iterator();
        Iterator j = integerMatrix3.iterator();

    while(iter.hasNext()){
        Integer actual = (Integer)((Matrix.IteratorMatrix) iter).get();
        //System.out.println(actual);
        Integer expected = (Integer)((Matrix.IteratorMatrix) j).get();
        assertEquals(expected, actual);
        iter.next();
        j.next();
    }
        //fail("adding failed");
    }
    @Test
    void addElements_forStringsTest(){
        System.out.println("adding test... Strings");
        Matrix<String> stringrMatrix1   = new Matrix<>(String::concat);
        Matrix<String> stringrMatrix2   = new Matrix<>(String::concat);
        Matrix<String> stringrMatrix3   ;
        int W = 1200;
        int H = 600;
        String[][] tab  = new String[W][H];
        String[][] tab2 = new String[W][H];
        String[][] tab3 = new String[W][H];
        for(int i=0; i<W; i++){
            for(int j=0;j<H;j++){
                tab[i][j] = "this "+ i;
                tab2[i][j] =j + " is";
                tab3[i][j] ="this " + i+ j+ " is";
            }
        }
        stringrMatrix1.buildMatrix(tab);
        stringrMatrix2.buildMatrix(tab2);

        assertTimeout(Duration.ofMillis(250),() -> stringrMatrix1.addElements(stringrMatrix2));

        stringrMatrix3 = stringrMatrix1.addElements(stringrMatrix2);
        Matrix<String> result = new Matrix<>(String::concat);
        result.buildMatrix(tab3);
        Iterator i = result.iterator();
        Iterator j = stringrMatrix3.iterator();

        while(i.hasNext()){
            String actual = (String)((Matrix.IteratorMatrix) i).get();
            //System.out.println(actual);
            String expected = (String) ((Matrix.IteratorMatrix) j).get();
            assertEquals(expected, actual);
            i.next();
            j.next();
        }

        //fail("adding failed");
    }
    @Test
    void setNodeTest(){
        System.out.println("setNode test... ints");
        Matrix<Integer> integerMatrix1   = new Matrix<>((a ,b )-> a+b);
        Integer[][] tab = new Integer[3][4];
        for(int i=0; i<3; i++){
            for(int j=0;j<4;j++){
                tab[i][j] = i+j;
            }
        }
        integerMatrix1.buildMatrix(tab);

        Integer expected = 5;
        integerMatrix1.setNode(2, 1, expected);

        assertEquals(expected, integerMatrix1.getNode(2, 1));




        //fail("adding failed");
    }
    @Test
    void outOfArrayExceptionTest(){
        System.out.println("outOfArray test... ints");
        Matrix<Integer> integerMatrix1   = new Matrix<>((a ,b )-> a+b);
        Integer[][] tab = new Integer[5][6];
        for(int i=0; i<5; i++){
            for(int j=0;j<6;j++){
                tab[i][j] = i+j;
            }
        }
        integerMatrix1.buildMatrix(tab);

        assertThrows(ArrayIndexOutOfBoundsException.class ,() -> integerMatrix1.getNode(7, 0));

}

}