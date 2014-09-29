package com.github.avarabyeu.jashing.eventsource;

import com.github.avarabyeu.jashing.events.JashingEvent;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.time.Duration;

/**
 * Created by andrey.vorobyov on 12/06/14.
 */
@HandlesEvent("test")
public class TestEventSource extends ScheduledEventSource<JashingEvent> {

    @Inject
    @Named("propertyString")
    private String propertyString;

    @Inject(optional = true)
    @Named("propertyInt")
    private Double propertyInt;

    public TestEventSource(String eventId, Duration period) {
        super(eventId, period);
    }


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