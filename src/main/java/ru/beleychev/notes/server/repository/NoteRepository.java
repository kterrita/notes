package ru.beleychev.notes.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.beleychev.notes.server.domain.Note;

/**
 * Yeap. My Project)
 * Created by ilya on 05.08.2017.
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
}
