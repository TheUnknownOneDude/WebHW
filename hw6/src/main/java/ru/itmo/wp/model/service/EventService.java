package ru.itmo.wp.model.service;

import ru.itmo.wp.model.domain.Event;
import ru.itmo.wp.model.domain.Type;
import ru.itmo.wp.model.domain.User;

import ru.itmo.wp.model.repository.EventRepository;
import ru.itmo.wp.model.repository.impl.EventRepositoryImpl;

public class EventService {
    EventRepository eventRepository = new EventRepositoryImpl();

    public void Enter(User user) {
        eventRepository.save(user, new Event(Type.ENTER));
    }

    public void Logout(User user) {
        eventRepository.save(user, new Event(Type.LOGOUT));
    }
}
