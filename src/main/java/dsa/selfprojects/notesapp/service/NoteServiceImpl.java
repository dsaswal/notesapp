package dsa.selfprojects.notesapp.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;


import dsa.selfprojects.notesapp.entity.Note;
import dsa.selfprojects.notesapp.dao.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	public NoteServiceImpl(NoteRepository theNoteRepository) {
		noteRepository = theNoteRepository;
	}

	// @Transactional -- not required since spring data jpa provides out of the box
	public List<Note> findAll() {
		return noteRepository.findAll();
	}

	@Override
	public void save(Note theNote) {
		theNote.setCreatedBy(11);
		theNote.setCreatedDate(OffsetDateTime.now());
		if (theNote.getNxtReviewDays() > 0)
			theNote.setNxtReviewDt(OffsetDateTime.now().plusDays(theNote.getNxtReviewDays()));
		else
			theNote.setNxtReviewDt(OffsetDateTime.now().plusDays(3));
		noteRepository.save(theNote);

	}

	@Override
	@Cacheable("notes")
	public Note findById(long noteId) {
		Optional<Note> result = noteRepository.findById(noteId);
		
		Note theNote = null;
		
		if (result.isPresent()) {
			theNote = result.get();
		}
		else {
			// we didn't find the note
			throw new RuntimeException("Did not find note id - " + noteId);
		}
		return theNote;
	}

	@Override
	public void deleteById(long noteId) {
		noteRepository.deleteById(noteId);
	}

}

