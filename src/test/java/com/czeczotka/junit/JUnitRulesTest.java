package com.czeczotka.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * @author Jakub Czeczotka
 * @since 02/09/14
 */
public class JUnitRulesTest {

    @Rule
    public TestName name = new TestName();

    @Test
    public void printTestMethodName() {
        System.out.println("Test method name: " + name.getMethodName());
    }
}