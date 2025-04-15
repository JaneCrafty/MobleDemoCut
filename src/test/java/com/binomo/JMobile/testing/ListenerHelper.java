package com.example.JMobile.testing;

import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

public class ListenerHelper extends SummaryGeneratingListener {
    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        //This method is invoked after all tests in all containers is finished
        super.testPlanExecutionFinished(testPlan);
        try {
            afterAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void afterAll() throws InterruptedException {
        Watcher.AfterAll();
    }
}
