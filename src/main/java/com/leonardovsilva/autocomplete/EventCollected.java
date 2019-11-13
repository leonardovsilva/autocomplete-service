package com.leonardovsilva.autocomplete;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.CompletionField;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.completion.Completion;

@Document(indexName = "autocomplete", type = "events", shards = 1, replicas = 0,
refreshInterval = "-1")
public class EventCollected {
	
	@Id
	private String id;
	private String event;
    private String timestamp;
    
    //@CompletionField(maxInputLength = 100) private Completion suggest;
    
    public EventCollected() {
    }
    
    public EventCollected(String id) {
    	this.id = id;
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
	
	/*public Completion getSuggest() {
		return suggest;
	}

	public void setSuggest(Completion suggest) {
		this.suggest = suggest;
	}*/

    @Override
    public String toString() {
        return "EventCollected{" +
                "id='" + id + '\'' +
                ", event='" + event + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}