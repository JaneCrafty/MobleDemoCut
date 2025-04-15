package com.example.JMobile.framework.environment;

import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Plugin(name = "CustomAppender",
        category = Core.CATEGORY_NAME,
        elementType = Appender.ELEMENT_TYPE,
        printObject = true)
public class CustomAppender extends AbstractAppender {
    static boolean isLocal = false;
    static ThreadLocal<List<String>> threadLocal = new ThreadLocal<>();

    protected CustomAppender(String name,
                             Filter filter,
                             Layout<? extends Serializable> layout) {
        super(name, filter, layout, false, null);
    }

    @PluginFactory
    public static CustomAppender createAppender(@PluginAttribute("name") String name,
                                                @PluginElement("Layout") Layout<? extends Serializable> layout,
                                                @PluginElement("Filter") final Filter filter) {
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }

        return new CustomAppender(name, filter, layout);
    }

    public static void getEvents() {
        if (!isLocal) {
            System.out.println(String.join("", threadLocal.get()));
        }
        clearEvents();
    }

    public static void clearEvents() {
        threadLocal.remove();
    }

    @Override
    public void append(LogEvent event) {
        List<String> events = threadLocal.get();
        if (events == null) {
            events = new ArrayList<>();
            threadLocal.set(events);
        }

        try {
            final byte[] bytes = getLayout().toByteArray(event);
            events.add(new String(bytes));
            if (isLocal) {
                System.out.println(new String(bytes).trim());
            }

        } catch (Exception ex) {
            throw new AppenderLoggingException(ex);
        }
    }
}
