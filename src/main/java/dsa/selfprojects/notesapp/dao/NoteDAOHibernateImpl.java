package dsa.selfprojects.notesapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dsa.selfprojects.notesapp.entity.Note;

@Repository
public class NoteDAOHibernateImpl implements NoteDAO{
	
	@Autowired
	private SessionFactory sessionFact;
	private EntityManager entityManager;

	//constructor injection
	//entity manager is auto created by spring boot
	@Autowired
	public NoteDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	//Transactional manages transaction scope for commit/rollback
	@Override
	//@Transactional //should be at service level
	public List<Note> getNotes() {
		//Session dbSession = sessionFact.getCurrentSession();
		Session dbSession = entityManager.unwrap(Session.class);
		
		Query<Note> qryListNotes = dbSession.createQuery("from Note order by nxtReviewDt", Note.class);
		List<Note> allNotes = qryListNotes.getResultList();
		return allNotes;
	}

	@Override
	public void saveNote(Note theNote) {
		Session dbSession = entityManager.unwrap(Session.class);
		dbSession.saveOrUpdate(theNote);
	}

	@Override
	public Note getNote(long noteId) {
		Session dbSession = entityManager.unwrap(Session.class);
		Note noteToUpdate = dbSession.get(Note.class, noteId);		
//		Query<Note> qryGetNote = dbSession.createQuery("from Note where id = " + noteId, Note.class);
//			Note noteToUpdate = qryGetNote.getSingleResult();
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
