package ru.itmo.wp.model.service;

import ru.itmo.wp.model.domain.Talk;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.repository.TalkRepository;
import ru.itmo.wp.model.repository.impl.TalkRepositoryImpl;

import java.util.List;

public class TalkService {
    TalkRepository talkRepository = new TalkRepositoryImpl();

    public List<Talk> findMessages(User user) {
        return talkRepository.findMessages(user);
    }

    public void save(Talk talk) {
        talkRepository.save(talk);
    }
}
