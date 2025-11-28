package com.example.Rewaya.Repository;

import com.example.Rewaya.Model.Novel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NovelRepository extends JpaRepository<Novel,Integer> {

    Novel findNovelById(Integer id);

    @Query("select distinct n from Novel n join n.categories c where lower(c) in ?1")
    List<Novel> filterCategories(List<String> categories);
//    Query("select n from Novel n where :userId member of n.likes")
//    List<Novel> findAllNovelsLikedByUser(Integer userId);  crashed :(
    List<Novel> findAllByIsCompleted(Boolean completed);


}
