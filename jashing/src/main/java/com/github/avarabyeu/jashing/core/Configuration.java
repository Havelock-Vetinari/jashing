package com.github.avarabyeu.jashing.core;

import java.util.List;
import java.util.Map;

/**
 * Events and event sources configuration
 *
 * @author avarabyeu
 */
public class Configuration {

    /**
     * application-scope properties, might be injected into event source beans
     */
    private Map<String, String> properties;

    /**
     * events configuration
     */
    private List<EventConfig> events;

    public List<EventConfig> getEvents() {
        return events;
    }

    public void setEvents(List<EventConfig> events) {
        this.events = events;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }


    public static class EventConfig {
        private String id;
        private String source;
        private Long frequency;

        /**
         * Event-scope properties. Might be injected into event source bean related to this particular event
         */
        private Map<String, Object> properties;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }


        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public Long getFrequency() {
            return frequency;
        }

        public void setFrequency(Long frequency) {
            this.frequency = frequency;
        }

        public Map<String, Object> getProperties() {
            return properties;
        }

        public void setProperties(Map<String, Object> properties) {
            this.properties = properties;
        }
    }


}
