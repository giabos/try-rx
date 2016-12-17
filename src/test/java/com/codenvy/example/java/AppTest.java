package com.codenvy.example.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import rx.Observable;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName
     *         name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }


    public void testApp() {

        final List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,5,8,13,21));
        Observable<Integer> obs = Observable.from(list);
        
        List<Integer> expectedData = (List<Integer>)((ArrayList)list).clone();
        
        obs.subscribe(i -> {
            int expected = expectedData.remove(0);
            assertEquals(expected, (int)i);
        }, e -> fail(e.toString()));
        
        
    }
}
