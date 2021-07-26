package dsa.selfprojects.notesapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import dsa.selfprojects.notesapp.entity.Note;
import dsa.selfprojects.notesapp.service.NoteService;

@RestController
@RequestMapping("/api")
public class NoteRestController {
	private NoteService noteService;

	@Autowired
	public NoteRestController(NoteService theNoteService) {
		noteService = theNoteService;
	}

	@GetMapping("/notes")
	public List<Note> getNotes() {
		return noteService.getNotes();
	}

	@GetMapping("/notes/{noteId}")
	public Note getNote(@PathVariable long noteId) {
		return noteService.getNote(noteId);
	}

        @PostMapping("/notes")
        public Note saveNote(@RequestBody Note theNote) {
                theNote.setId(0);
		noteService.saveNote(theNote);
		return theNote;
        }

        @PutMapping("/notes")
        public Note updateNote(@RequestBody Note theNote) {
		noteService.updateNote(theNote);
		return theNote;
        }

        @DeleteMapping("/notes/{noteId}")
        public String updateNote(@PathVariable long noteId) {
		//todo - validate if note exists
			
		noteService.deleteNote(noteId);
		return "Note deleted successfully, note id - " + noteId;
        }

}

