import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    private static final Object[] getNumbers(){
        return $(
                $(10, 20, 30),
                $(20, 30, 50),
                $(-1, 10, 9),
                $(5, -16, -11)
        );
    }

    @Test
    @Parameters(method = "getNumbers")
    public void canAddTwoNumbers(int first, int second, int result){
        Assert.assertEquals(result, new Calculator().add(first,second));
    }
}
