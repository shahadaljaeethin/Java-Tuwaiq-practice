package com.example.Rewaya.Service;

import com.example.Rewaya.Model.Author;
import com.example.Rewaya.Model.Chapter;
import com.example.Rewaya.Model.Novel;
import com.example.Rewaya.Model.Tip;
import com.example.Rewaya.Repository.AuthorRepository;
import com.example.Rewaya.Repository.TipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TipService {
    private final TipRepository tipRepository;
    private final AuthorRepository authorRepository;
//==============================================================


    public String postTip(Tip tip){

        Author author = authorRepository.findAuthorById(tip.getAuthorId());
        if(author==null) return "author not found";
        if(!author.getActive()) return "Author is unActive currently";

        tip.setPublishDate(LocalDate.now());
        tipRepository.save(tip);
        return "Posted :) thank you for helping novelist community!";

    }

    public List<Tip> getAll(){return tipRepository.findAll();}


    public String updateTip(Integer id,Tip upd){

        Tip tip = tipRepository.findTipById(id);
        if(tip==null) return "tip not found";


       tip.setContent(upd.getContent());
        return "updated";

    }

    public boolean deleteChapter(Integer id){
        Tip tip = tipRepository.findTipById(id);
        if(tip==null) return false;
        tipRepository.delete(tip);
        return true;
    }

/*=========================================================================================================

    Extra end points:

===========================================================================================================
 */


}
