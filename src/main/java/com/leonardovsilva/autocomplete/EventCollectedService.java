package com.leonardovsilva.autocomplete;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventCollectedService {
	
	EventCollected save(EventCollected event);

    void delete(EventCollected event);

    Optional<EventCollected> findOne(String id);

    Iterable<EventCollected> findAll();

    Page<EventCollected> findByEvent(String event, Pageable pageable);

    List<EventCollected> findByEvent(String event);
}
