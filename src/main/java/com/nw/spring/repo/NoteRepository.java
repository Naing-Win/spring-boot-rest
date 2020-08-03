package com.nw.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nw.spring.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
