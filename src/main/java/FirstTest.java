import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FirstTest {
//КРАТНО 3 И 5, ВОЗВРАЩАТЬ 'S'
//КРАТНО 5, ВОЗВРАЩАТЬ 'M'
//КРАТНО 3, ВОЗВРАЩАТЬ 'T'
//ВОЗВРАЩАТЬ 'FAIL'

    public String trialCode(int number) {
       if (number % 3 == 0 && number % 5 == 0){
           return "S";
       } else if (number % 5 == 0) {
           return "M";
       } else if (number % 3 == 0){
           return "T";
       } else return "Fail";
    }

    @Test
    public void  checkMethod() {
        String actualResult = trialCode(9);
        assertEquals("T", actualResult);
    }

    @Test
    public void  checkMethod1() {
        String actualResult = trialCode(25);
        assertEquals("M", actualResult);
    }

    @Test
    public void  checkMethod2() {
        String actualResult = trialCode(15);
        assertEquals("S", actualResult);
    }

    @Test
    public void  checkMethod3() {
        String actualResult = trialCode(1);
        assertEquals("Fail", actualResult);
    }
}