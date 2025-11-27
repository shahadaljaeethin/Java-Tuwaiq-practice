package com.example.Rewaya.Repository;

import com.example.Rewaya.Model.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipRepository extends JpaRepository<Tip,Integer> {
    Tip findTipById(Integer id);
}
