package dev.n45.journal.service.journal;

import dev.n45.journal.datatype.request.JournalRequest;
import dev.n45.journal.entity.journal.Journal;
import dev.n45.journal.repository.journal.JournalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Override
    public Journal createJournal(JournalRequest journalRequest, String userId) {

        var journal = Journal.builder()
                .title(journalRequest.getTitle())
                .content(journalRequest.getContent())
                .userId(userId)
                .build();

        log.info("Journal created: {}", journal);

        journalRepository.save(journal);

        return journal;
    }

    @Override
    public Journal getJournalById(String id) {
        return journalRepository.findJournalByExternalId(id);
    }

    @Override
    public Iterable<Journal> getAllJournals(String userId) {
        return journalRepository.getJournalsByUserId(userId);
    }
}
