/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class UtilsTest {
    
    public UtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("* UtilsJUnit3Test: setUp() method");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("* UtilsJUnit3Test: tearDown() method");
    }

    /**
     * Test of computeFactorial method, of class Utils.
     * @throws java.lang.InterruptedException
     * @throws java.util.concurrent.TimeoutException
     */
    @Test
    public void testWithTimeout() throws InterruptedException, TimeoutException {
        System.out.println("* UtilsJUnit3Test: test method 2 - testWithTimeout()");
        final int factorialOf = 1 + (int) (30000 * Math.random());
        System.out.println("computing " + factorialOf + '!');

        Thread testThread = new Thread() {
            @Override
            public void run() {
                System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
            }


        };

        testThread.start();
        Thread.sleep(1000);
        testThread.interrupt();

        if (testThread.isInterrupted()) {
            throw new TimeoutException("the test took too long to complete");
        }
    }
    
    /**
     *
     */
    @Test
    public void testExpectedException() {
    System.out.println("* UtilsJUnit3Test: test method 3 - testExpectedException()");
    try {
        final int factorialOf = -5;
        System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
        fail("IllegalArgumentException was expected");
    } catch (IllegalArgumentException ex) {
    }
}
    
    /**
     * Test of normalizeWord method, of class Utils.
     * @throws java.lang.Exception
     */
    @Test
    public void DISABLED_testTemporarilyDisabled() throws Exception {
        System.out.println("* UtilsJUnit3Test: test method 4 - checkExpectedException()");
        assertEquals("Malm\u00f6", Utils.normalizeWord("Malmo\u0308"));
    }
    
    @Test
    public void testHelloWorld() {
        System.out.println("* UtilsJUnit3Test: test method 1 - testHelloWorld()");
        assertEquals("Hello, world!", Utils.concatWords("Hello", ", ", "world", "!"));
    }
    
}
