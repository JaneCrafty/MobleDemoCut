package com.example.JMobile.framework.environment;

import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;

public class CustomParallelStrategy implements ParallelExecutionConfiguration, ParallelExecutionConfigurationStrategy {
    private final int threadCount = Integer.parseInt(System.getProperty("threadCount", "1"));

    @Override
    public int getParallelism() {
        return threadCount;
    }

    @Override
    public int getMinimumRunnable() {
        return threadCount;
    }

    @Override
    public int getMaxPoolSize() {
        return threadCount;
    }

    @Override
    public int getCorePoolSize() {
        return threadCount;
    }

    @Override
    public int getKeepAliveSeconds() {
        return 30;
    }

    @Override
    public ParallelExecutionConfiguration createConfiguration(final ConfigurationParameters configurationParameters) {
        return this;
    }
}
