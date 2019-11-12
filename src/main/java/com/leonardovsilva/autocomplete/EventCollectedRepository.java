package com.leonardovsilva.autocomplete;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EventCollectedRepository extends ElasticsearchRepository<EventCollected, String> {

    Page<EventCollected> findByEvent(String event, Pageable pageable);

    List<EventCollected> findByEvent(String event);

}
