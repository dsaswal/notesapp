package dsa.selfprojects.notesapp.service;

import java.time.OffsetDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsa.selfprojects.notesapp.dao.NoteDAO;
import dsa.selfprojects.notesapp.entity.Note;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteDAO noteDAO;

	@Autowired
	public NoteServiceImpl(NoteDAO theNoteDAO) {
		noteDAO = theNoteDAO;
	}

	@Transactional
	public List<Note> getNotes() {
		List<Note> notesList = noteDAO.getNotes();
		return notesList;
	}

	@Override
	@Transactional
	public void saveNote(Note theNote) {
		theNote.setCreatedBy(11);
		theNote.setCreatedDate(OffsetDateTime.now());
		if (theNote.getNxtReviewDays() > 0)
			theNote.setNxtReviewDt(OffsetDateTime.now().plusDays(theNote.getNxtReviewDays()));
		else
			theNote.setNxtReviewDt(OffsetDateTime.now().plusDays(3));
		noteDAO.saveNote(theNote);

	}

	@Override
	@Transactional
	public Note getNote(long noteId) {
		Note noteToUpdate = noteDAO.getNote(noteId);
		return noteToUpdate;
	}

	@Override
	@Transactional
	public void updateNote(Note theNote) {
		Note noteToUpdate = noteDAO.getNote(theNote.getId());
		noteToUpdate.setModifiedDate(OffsetDateTime.now());
		if(theNote.getNxtReviewDays() > 0) {
			noteToUpdate.setNxtReviewDt(OffsetDateTime.now().plusDays(theNote.getNxtReviewDays()));
			noteToUpdate.setNxtReviewDays(theNote.getNxtReviewDays());
		}
		else {
			noteToUpdate.setNxtReviewDt(OffsetDateTime.now().plusDays(3));
			noteToUpdate.setNxtReviewDays(theNote.getNxtReviewDays());
			}
		noteToUpdate.setNote(theNote.getNote());
		noteToUpdate.setPoints(theNote.getPoints());
		noteToUpdate.setCtgry(theNote.getCtgry());
		noteDAO.updateNote(noteToUpdate);		
	}

	@Override
	@Transactional
	public void deleteNote(long noteId) {
		noteDAO.deleteNote(noteId);
	}

}

