package com.github.avarabyeu.jashing.core.eventsource;

import com.github.avarabyeu.jashing.core.EventSource;
import com.github.avarabyeu.jashing.core.JashingEvent;
import com.google.inject.Inject;

import javax.inject.Named;

/**
 * @author Andrei Varabyeu
 */
@EventSource("test")
public class TestEventSource extends ScheduledEventSource<JashingEvent> {

    @Inject
    @Named("propertyString")
    private String propertyString;

    @Inject(optional = true)
    @Named("propertyInt")
    private Double propertyInt;


    public String getPropertyString() {
        return propertyString;
    }

    public void setPropertyString(String propertyString) {
        this.propertyString = propertyString;
    }

    public Double getPropertyInt() {
        return propertyInt;
    }

    public void setPropertyInt(Double propertyInt) {
        this.propertyInt = propertyInt;
    }

    @Override
    protected JashingEvent produceEvent() {
        return new JashingEvent();
    }

    @Override
    public String toString() {
        return "TestEventSource{" +
                "propertyString='" + propertyString + '\'' +
                ", propertyInt=" + propertyInt +
                '}';
    }
}
