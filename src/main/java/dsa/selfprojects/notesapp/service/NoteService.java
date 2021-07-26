package dsa.selfprojects.notesapp.service;

import java.util.List;

import dsa.selfprojects.notesapp.entity.Note;

public interface NoteService {
	
	public List<Note> findAll();

	public void save(Note theNote);

	public Note findById(long noteId);

	public void deleteById(long noteId); 
}

