package com.leonardovsilva.autocomplete;

import org.springframework.data.elasticsearch.core.completion.Completion;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

class SuggestionEntityBuilder {

	private EventCollected result;

	public SuggestionEntityBuilder(String id) {
		result = new EventCollected(id);
	}

	public SuggestionEntityBuilder event(String event) {
		result.setEvent(event);
		return this;
	}

	public SuggestionEntityBuilder suggest(String[] input) {
		return suggest(input, null);
	}

	public SuggestionEntityBuilder suggest(String[] input, Integer weight) {
		Completion suggest = new Completion(input);
		suggest.setWeight(weight);

		//result.setSuggest(suggest);
		return this;
	}

	public EventCollected build() {
		return result;
	}

	public IndexQuery buildIndex() {
		IndexQuery indexQuery = new IndexQuery();
		indexQuery.setId(result.getId());
		indexQuery.setObject(result);
		return indexQuery;
	}
}
