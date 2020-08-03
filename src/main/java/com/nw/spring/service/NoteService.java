package com.nw.spring.service;

import java.util.List;

import com.nw.spring.model.Note;

public interface NoteService {
	
	Note create(Note note);
	List<Note> findAll();
	List<Note> saveList(List<Note> notes);
	Note findById(long id);
	void deleteById(long id);
	Note updateById(Note note);
}
