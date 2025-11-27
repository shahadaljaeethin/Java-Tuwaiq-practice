package com.example.Rewaya.Repository;

import com.example.Rewaya.Model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter,Integer> {
    Chapter findChapterById(Integer ID);
}
