package com.github.avarabyeu.jashing.core.eventsource;

import com.github.avarabyeu.jashing.core.JashingEvent;
import com.github.avarabyeu.jashing.core.eventsource.annotation.EventId;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.AbstractExecutionThreadService;

import javax.inject.Inject;

/**
 * @author Andrei Varabyeu
 */
public abstract class SimpleEventSource extends AbstractExecutionThreadService {


    /**
     * EventBus to send events
     */
    @Inject
    private EventBus eventBus;

    /**
     * ID of event this event source bound to
     */
    @EventId
    @Inject
    private String eventId;

    protected final void sendEvent(JashingEvent t) {
        if (null != t) {
            t.setId(eventId);
            this.eventBus.post(t);
        }
    }

    @Override
    protected void startUp() throws Exception {
        /* no any lifecycle-related logic */
    }

    @Override
    protected void shutDown() throws Exception {
        /* no any lifecycle-related logic */
    }

    @Override
    protected String serviceName() {
        return "SimpleEventSource[eventID=" + eventId + "]";
    }
}
