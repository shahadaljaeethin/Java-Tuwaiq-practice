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
       //how can I find it?
       int lastChapter = 1;
       ch.setChapterNumber(lastChapter+1);
       return "Published! :)";

    }

    public List<Novel> getAll(){return novelRepository.findAll();}


    public String updateNovel(Integer id,Novel upd){

        Author author = authorRepository.findAuthorById(upd.getAuthorId());
        if(author==null) return "Author not found";

        if(!author.getActive()) return "Author is unActive";

        Novel novel = novelRepository.findNovelById(id);
        if(novel==null) return "Novel not found";
        //end of check


        novel.setTitle(upd.getTitle());
        novel.setOverview(upd.getOverview());
        novel.setCategory(upd.getCategory());
        novelRepository.save(novel);
        return "updated";

    }

    public boolean deleteAuthor(Integer id){
        Novel novel = novelRepository.findNovelById(id);
        if(novel==null) return false;

        //delete all chapters of this novel if any

        //now delete the novel
        novelRepository.delete(novel);
        return true;
    }



}
