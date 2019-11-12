package com.leonardovsilva.autocomplete;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "autocomplete", type = "events")
public class EventCollected {
	
	@Id
	private String id;
	private String event;
    private String timestamp;
    
    public EventCollected() {
    }

    public EventCollected(String id, String event, String timestamp) {
        this.id = id;
        this.event = event;
        this.timestamp = timestamp;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

    @Override
    public String toString() {
        return "EventCollected{" +
                "id='" + id + '\'' +
                ", event='" + event + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}