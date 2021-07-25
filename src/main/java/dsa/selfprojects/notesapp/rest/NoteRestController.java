package dsa.selfprojects.notesapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import dsa.selfprojects.notesapp.entity.Note;
import dsa.selfprojects.notesapp.dao.NoteDAO;

@RestController
@RequestMapping("/api")
public class NoteRestController {
	private NoteDAO noteDAO;

	@Autowired
	public NoteRestController(NoteDAO theNoteDAO) {
		noteDAO = theNoteDAO;
	}

	@GetMapping("/notes")
	public List<Note> getNotes() {
		return noteDAO.getNotes();
	}

}

