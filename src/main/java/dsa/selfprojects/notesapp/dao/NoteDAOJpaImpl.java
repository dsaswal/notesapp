package dsa.selfprojects.notesapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dsa.selfprojects.notesapp.entity.Note;

@Repository
public class NoteDAOJpaImpl implements NoteDAO{
	
	@Autowired
	private EntityManager entityManager;

	//constructor injection
	//entity manager is auto created by spring boot
	@Autowired
	public NoteDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	//Transactional manages transaction scope for commit/rollback
	@Override
	//@Transactional //should be at service level
	public List<Note> getNotes() {
		javax.persistence.Query qryListNotes = entityManager.createQuery("from Note order by nxtReviewDt");
		List<Note> allNotes = qryListNotes.getResultList();
		return allNotes;
	}

	@Override
	public void saveNote(Note theNote) {
		Note newNote = entityManager.merge(theNote);
		theNote.setId(newNote.getId());
	}

	@Override
	public Note getNote(long noteId) {
		Note noteToUpdate = entityManager.find(Note.class, noteId);		
		return noteToUpdate;
	}

	@Override
	public void updateNote(Note theNote) {
		Session dbSession = entityManager.unwrap(Session.class);
//		Note noteToUpdate = dbSession.get(Note.class, theNote.getId());
//		noteToUpdate.setNote(theNote.getNote());
//		noteToUpdate.setNxtReviewDays(theNote.getNxtReviewDays());
		dbSession.update(theNote);
	}

	@Override
	public void deleteNote(long noteId) {
		Session dbSession = entityManager.unwrap(Session.class);
		Note noteToDelete = dbSession.get(Note.class, noteId);		
		dbSession.delete(noteToDelete);		
		return;
	}

}
