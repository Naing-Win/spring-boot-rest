package com.nw.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nw.spring.exception.ResourceNotFoundException;
import com.nw.spring.model.Note;
import com.nw.spring.repo.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteRepository noteRepository;

	@Override
	public Note create(Note note) {
		// TODO Auto-generated method stub
		return noteRepository.save(note);
	}

	@Override
	public List<Note> findAll() {
		// TODO Auto-generated method stub
		return noteRepository.findAll();
	}

	@Override
	public List<Note> saveList(List<Note> notes) {
		// TODO Auto-generated method stub
		return noteRepository.saveAll(notes);
	}

	@Override
	public Note findById(long id) {
		// TODO Auto-generated method stub
		return noteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		noteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));
		noteRepository.deleteById(id);
	}

	@Override
	public Note updateById(Note note) {
		// TODO Auto-generated method stub
		return noteRepository.saveAndFlush(note);
	}

}
