package com.example.Rewaya.Repository;

import com.example.Rewaya.Model.Novel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelRepository extends JpaRepository<Novel,Integer> {
    Novel findNovelById(Integer id);
}
