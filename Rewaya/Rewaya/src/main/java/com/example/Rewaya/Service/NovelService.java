package com.example.Rewaya.Service;


import com.example.Rewaya.Model.Author;
import com.example.Rewaya.Model.Chapter;
import com.example.Rewaya.Model.Novel;
import com.example.Rewaya.Model.User;
import com.example.Rewaya.Repository.AuthorRepository;
import com.example.Rewaya.Repository.ChapterRepository;
import com.example.Rewaya.Repository.NovelRepository;
import com.example.Rewaya.Repository.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NovelService {
private final NovelRepository novelRepository;
private final AuthorRepository authorRepository;
private final ChapterRepository chapterRepository;
private final UserRepository userRepository;



    public String createNovel(Novel novel){

        Author auth = authorRepository.findAuthorById(novel.getAuthorId());
        if(auth==null) return "Author not found";
        if(!auth.getActive()) return "Author account is not approved yet :(";
        novel.setLikes(new ArrayList<>()); //no user made like yet
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
       novel.setCategories(upd.getCategories());
       novel.setIsCompleted(upd.getIsCompleted());
       novelRepository.save(novel);
        return "updated";

    }

    public boolean deleteAuthor(Integer id){
        Novel novel = novelRepository.findNovelById(id);
        if(novel==null) return false;

        //delete all chapters of this novel if any
        List<Chapter> chapters = chapterRepository.findChapterByNovelId(id);
        if(!chapters.isEmpty()){
            for(Chapter ch: chapters) chapterRepository.delete(ch);
        }

        //now delete the novel
        novelRepository.delete(novel);
        return true;
    }

//-----------------------E N D   OF  C R U Ds------------------------------------

    public String toggleLike(Integer userId, Integer novelId){
        Novel novel = novelRepository.findNovelById(novelId);
        if(novel==null) return "novel not found";
        User user = userRepository.findUserById(userId);
        if(user==null) return "user not found";
   //====================================================

        ArrayList<Integer> likes = novel.getLikes();

        if(likes.contains(userId))
        {
            likes.remove(userId);
            novel.setLikes(likes);
            novelRepository.save(novel);
            return "Like removed";
        }
       else
        {
            likes.add(userId);
            novel.setLikes(likes);
            novelRepository.save(novel);
            return "Liked :)";
        }
    }

    public List<Novel> getMyFavNovels(Integer userId){return novelRepository.findAll().stream().filter(novel -> novel.getLikes().contains(userId)).toList();}
    public List<Novel> getCompletedNov(){return novelRepository.findAllByIsCompleted(true);}
    public List<Novel> getNonCompletedNov(){return novelRepository.findAllByIsCompleted(false);}
    public List<Novel> filterCategories(List<String> categories){return novelRepository.filterCategories(categories);}
    public List<Novel> getTop3Novels() {
        return novelRepository.findAll().stream().sorted((a, b) -> b.getLikes().size() - a.getLikes().size()).limit(3).toList();
                                         }


}
