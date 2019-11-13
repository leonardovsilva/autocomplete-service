package com.leonardovsilva.autocomplete;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventCollectedServiceImpl implements  EventCollectedService{

	private EventCollectedRepository eventRepository;

	@Autowired
    public void setBookRepository(EventCollectedRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
	
	@Override
	public EventCollected save(EventCollected event) {
		return eventRepository.save(event);
	}

	@Override
	public void delete(EventCollected event) {
		eventRepository.delete(event);
	}

	@Override
	public Optional<EventCollected> findOne(String id) {
		return eventRepository.findById(id);
	}

	@Override
	public Iterable<EventCollected> findAll() {
		 return eventRepository.findAll();
	}

	@Override
	public Page<EventCollected> findByEvent(String event, Pageable pageable) {
		return eventRepository.findByEvent(event, pageable);
	}

	@Override
	public List<EventCollected> findByEvent(String event) {
		return eventRepository.findByEvent(event);
	}

	@Override
	public List<EventCollected> findDistinctByEventContaining(String event, Pageable pageable) {
		return eventRepository.findDistinctByEventContaining(event, pageable);
	}

}
