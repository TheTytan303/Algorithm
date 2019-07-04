import macierze.*;
import  solution_2.*;
import solution_4.*;
import substing_3.*;
import SortingFunctions.*;

import javax.naming.SizeLimitExceededException;
import java.util.*;
public class Main {


    public static void main(String[] args) {

//*-------------------------------------------------------------- AD1
        Matrix<Integer> m1 = new Matrix<>((a, b) -> a+b);
        Matrix<Integer> m2 = new Matrix<>((a, b) -> a+b);
        Integer[][] tab = new Integer[7][8];
        System.out.println(tab.length+"x"+tab[1].length);
        Integer[][] tab2 = new Integer[7][8];
        for(int i=0; i<7; i++){
            for(int j=0;j<8;j++){
                tab[i][j] = i+j;
                tab2[i][j] = 7+8-i-j;
            }
        }
        System.out.println(tab2[0][0].toString()+"\n");
        m1.buildMatrix(tab);
        m2.buildMatrix(tab2);
        System.out.println(m1.toString()+"\n");
        System.out.println(m2.toString()+"\n");
        Matrix<Integer> m3 = m1.addElements(m2);
        System.out.println(m3.toString());

        Matrix<String> m4 = new Matrix<>((a, b)-> a+" "+b);
        Matrix<String> m5 = new Matrix<>((a, b)-> a+" "+b);

        String[][] tab3 = new String[2][2];
        String[][] tab4 = new String[2][2];

        tab3[0][0] = "Real - Ajax";
        tab3[0][1] = "Borrusa - Tottenham";
        tab3[1][0] = "Bayern - Liverpool";
        tab3[1][1] = "Juventus - Atletico";

        tab4[0][0] = "3:5";
        tab4[0][1] = "0:4";
        tab4[1][0] = "1:3";
        tab4[1][1] = "3:2";

        m4.buildMatrix(tab3);
        m5.buildMatrix(tab4);

        System.out.println(m4.addElements(m5));
//*/
//*-------------------------------------------------------------- AD2
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(7);
        list1.add(3);
        list1.add(5);
        list1.add(4);
        list1.add(1);
        try{
            System.out.println(solution_2.solution(list1));
        }
        catch (OutOfRange e){
            System.err.println("out of range");
        }
        catch(SizeLimitExceededException ignored){

        }

//*/
//*-------------------------------------------------------------- AD3
        System.out.println("SS: " + substring_3.substring("abcd", "cdabcdab"));
        System.out.println("SS: " + substring_3.substring("cdabcdab", "abc"));
        System.out.println("SS: " + substring_3.substring("abcd", "cdabcdabcdabcdab"));



// */
//*-------------------------------------------------------------- AD4
        float[] tab5 = new float[12];
        tab5[0] = 0;
        tab5[1] = 1;
        tab5[2] = 2;
        tab5[3] = 3;
        tab5[4] = -2;
        tab5[5] = 0.75F;
        tab5[6] = 0.25F;
        tab5[7] = -0.25F;
        tab5[8] = 3;
        tab5[9] = -7;
        tab5[10] = 8;
        tab5[11] = 3;

        try{
            for (Float i: tab5) {
                System.out.print(i + "\t");
            }
            System.out.println("\n "+ solution_4.solution(tab5, 0.5F)[0]+" + " + solution_4.solution(tab5, 0.5F)[1]);
        }
        catch (NoSuchElementException e){
            System.out.println("nie da się");
        }
//*/
//*-------------------------------------------------------------- AD5
    SortingFunctions.SortingFunctions(100000);
//*/
    }
}