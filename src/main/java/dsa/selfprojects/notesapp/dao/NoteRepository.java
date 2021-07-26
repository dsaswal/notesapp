package dsa.selfprojects.notesapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import dsa.selfprojects.notesapp.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
	//no code required. CRUD code provided by spring-data-jpa
}
