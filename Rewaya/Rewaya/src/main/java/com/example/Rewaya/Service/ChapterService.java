package com.example.Rewaya.Service;


import com.example.Rewaya.Model.Author;
import com.example.Rewaya.Model.Chapter;
import com.example.Rewaya.Model.Novel;
import com.example.Rewaya.Repository.AuthorRepository;
import com.example.Rewaya.Repository.ChapterRepository;
import com.example.Rewaya.Repository.NovelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChapterService {
    private final ChapterRepository chapterRepository;
    private final NovelRepository novelRepository;
    private final AuthorRepository authorRepository;

//====================================================

    public String publishChapter(Chapter ch){

        Novel nvl = novelRepository.findNovelById(ch.getNovelId());
        if(nvl==null) return "Novel not found";
        if(!authorRepository.findAuthorById(nvl.getAuthorId()).getActive()) return "Author is unActive currently";
//========================================

        ch.setPublishDate(LocalDate.now());
        Integer lastChap = chapterRepository.getLastChapterNumber(ch.getNovelId());
        if(lastChap == null) lastChap = 0;

       ch.setChapterNumber(lastChap+1);
       chapterRepository.save(ch);
       return "Published! :)";

    }

    public List<Chapter> getAll(){return chapterRepository.findAll();}


    public String updateChapter(Integer id,Chapter upd){

        Chapter chapter = chapterRepository.findChapterById(id);
        if(chapter==null) return "Chapter not found";

//        Novel novel = novelRepository.findNovelById(upd.getNovelId());
//        if(novel==null) return "Novel not found";

        //end of check
        chapter.setTitle(upd.getTitle());
        chapter.setContent(upd.getContent());
        chapterRepository.save(chapter);
        return "updated";

    }

    public boolean deleteChapter(Integer id){
        Chapter chapter = chapterRepository.findChapterById(id);
        if(chapter==null) return false;

        chapterRepository.delete(chapter);
        return true;
    }



}
