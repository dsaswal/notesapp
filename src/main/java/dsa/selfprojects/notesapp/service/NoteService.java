package dsa.selfprojects.notesapp.service;

import java.util.List;

import dsa.selfprojects.notesapp.entity.Note;

public interface NoteService {
	
	public List<Note> getNotes();

	public void saveNote(Note theNote);

	public Note getNote(long noteId);

	public void updateNote(Note theNote);

	public void deleteNote(long noteId); 
}

