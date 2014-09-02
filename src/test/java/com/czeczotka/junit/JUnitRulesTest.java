package com.czeczotka.junit;

import org.junit.Rule;
import org.junit.Test;
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

    @Test
    public void printTestMethodName() {
        System.out.println("Test method name: " + name.getMethodName());
    }

    @Test
    public void slowTestAskingForTrouble() throws InterruptedException {
        Thread.sleep(1000 * 60);
    }
}