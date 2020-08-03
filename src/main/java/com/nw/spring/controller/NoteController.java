package com.nw.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nw.spring.model.Note;
import com.nw.spring.service.NoteServiceImpl;

@RestController
@RequestMapping("/api/note")
public class NoteController {
	
	@Autowired
	private NoteServiceImpl noteService;
	
	@GetMapping("/all")
	public List<Note> getAll() {
		return noteService.findAll();
	}
	
	@PostMapping("/create")
	public Note createNote(@Valid @RequestBody Note note) {
		//List<Note>
		return noteService.create(note);
	}
	
	@PostMapping("/save")
	public List<Note> saveList(@Valid @RequestBody(required = false) List<Note> notes) {
		/*
		 * notes = Arrays.asList(new Note("Spring", "Spring Core", LocalDate.of(2019, 5,
		 * 2), LocalDate.of(2020, 7, 5)), new Note("Cloud", "Full Cloud",
		 * LocalDate.of(2009, 3, 1), LocalDate.of(2202, 9, 6)));
		 */
		return noteService.saveList(notes);
	}
	
	@GetMapping("/all/{id}")
	public Note findOneById(@PathVariable("id") long id) {
		return noteService.findById(id);
	}
	
	@DeleteMapping("/all/{id}")
	public List<Note> deleteOneById(@PathVariable("id") long id) {
		noteService.deleteById(id);
		return noteService.findAll();
	}
	
	@PutMapping("/all/{id}")
	public Note updateById(@PathVariable("id") long id, @Valid @RequestBody Note note) {
		Note n = noteService.findById(id);
		//n.setId(note.getId());
		n.setTitle(note.getTitle());
		n.setContent(note.getContent());
		n.setCreatedAt(note.getCreatedAt());
		n.setUpdatedAt(note.getUpdatedAt());
		return noteService.updateById(n);
	}

}
