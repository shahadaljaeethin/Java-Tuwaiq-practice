package com.example.Rewaya.Service;


import com.example.Rewaya.Model.Author;
import com.example.Rewaya.Model.Novel;
import com.example.Rewaya.Repository.AuthorRepository;
import com.example.Rewaya.Repository.NovelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NovelService {
private final NovelRepository novelRepository;
private final AuthorRepository authorRepository;


    public String createNovel(Novel novel){

        Author auth = authorRepository.findAuthorById(novel.getAuthorId());
        if(auth==null) return "Author not found";
        if(!auth.getActive()) return "Author is not approved yet :(";

        novel.setIsCompleted(false);
        novel.setPublishDate(LocalDate.now());
        novelRepository.save(novel);
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

//-----------------------E N D   OF  C R U Ds------------------------------------
}
