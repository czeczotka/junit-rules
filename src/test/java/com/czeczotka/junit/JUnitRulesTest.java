package com.czeczotka.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

/**
 * @author Jakub Czeczotka
 * @since 02/09/14
 */
public class JUnitRulesTest {

    @Rule
    public TestName name = new TestName();

    @Rule
    public Timeout timeout = new Timeout(20);

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void printTestMethodName() {
        System.out.println("Test method name: " + name.getMethodName());
    }

    @Test
    public void slowTestAskingForTrouble() throws InterruptedException {
        Thread.sleep(1000 * 60);
    }

    @Test (expected = IllegalArgumentException.class)
    public void exceptionExpected(){
        throw new IllegalArgumentException("catch me if you can");
    }

    @Test
    public void exceptionWithMessageExpected(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("catch me if you can");
        throw new IllegalArgumentException("catch me if you can");
    }
}