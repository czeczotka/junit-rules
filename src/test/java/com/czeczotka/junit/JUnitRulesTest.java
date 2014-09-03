package com.czeczotka.junit;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.*;
import org.junit.runner.Description;

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

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            report.append("  FAILURE: ").append(description.getMethodName()).append("\n");
        }

        @Override
        protected void succeeded(Description description) {
            report.append("  Success: ").append(description.getMethodName()).append("\n");
        }
    };

    private static StringBuilder report = new StringBuilder();

    @Test
    public void printTestMethodName() {
        System.out.println("Test method name: " + name.getMethodName());
    }

    @Test
    public void slowTestAskingForTrouble() throws InterruptedException {
        Thread.sleep(1000 * 60);
    }

    @Test
    public void slowTestWithExpectedException() throws InterruptedException {
        thrown.expect(Exception.class);
        thrown.expectMessage("test timed out after 20 milliseconds");
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

    @Test
    public void errorCollectorExample() {
        collector.addError(new Throwable("trouble here"));
        collector.addError(new Throwable("trouble there"));
        collector.addError(new Throwable("trouble everywhere"));
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("@AfterClass report");
        System.out.println(report.toString ());
    }
}