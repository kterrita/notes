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
	@Transactional
	@Query("select n from Note n where n.userId = ?1")
	List<Note> getNotes(Long id);

	/**
	 * @param id User Id
	 * @return favorite {@code List<Note>} with defined userId
	 */
	@Transactional
	@Query("select n from Note n where n.userId = ?1 and n.favorite = 1")
	List<Note> getFavoriteNotes(Long id);

	/**
	 * @param id User Id
	 * @return important {@code List<Note>} with defined userId
	 */
	@Transactional
	@Query("select n from Note n where n.userId = ?1 and n.important = 1")
	List<Note> getImportantNotes(Long id);

	/**
	 * @param id User Id
	 * @return deleted {@code List<Note>} with defined userId
	 */
	@Transactional
	@Query("select n from Note n where n.userId = ?1 and n.deleted = 1")
	List<Note> getDeletedNotes(Long id);
}
