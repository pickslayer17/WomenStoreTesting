import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

//TestClass
public class JustTest1 {


    @Test
    public void testingTest() {
        System.out.println();
        System.out.println();
        System.out.println("Oh my GOD!!!!!");
        System.out.println();
        System.out.println();
        System.out.println(UUID.randomUUID().toString());


        step1();
    }
    @Step
    private void step1() {
        System.out.println("Hi! im very tired step 2");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    @Test
    public void simpleTest2() {
        checkSumStep(3, 2, 5);
        checkSumStep(5, 4, 9);
    }
    @Step
    public static void checkSumStep(int num1, int num2, int expectedSum) {
        Assertions.assertTrue(num1 + num2 == expectedSum, "Сумма слагаемых не соответствует ожидаемому значению");
    }
}
