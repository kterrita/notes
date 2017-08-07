package ru.beleychev.notes.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.beleychev.notes.server.domain.Note;

import java.util.List;

/**
 * Yeap. My Project)
 * Created by ilya on 05.08.2017.
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
	/**
	 * @param id User Id
	 * @return {@code List<Note>} with defined userId
	 */
	@Query("select n from Note n where n.userId = ?1")
	@Transactional
	List<Note> getNotes(Long id);
}
