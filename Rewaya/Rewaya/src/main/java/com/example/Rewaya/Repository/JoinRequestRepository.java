package com.example.Rewaya.Repository;

import com.example.Rewaya.Model.JoinRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinRequestRepository extends JpaRepository<JoinRequest,Integer> {
    JoinRequest findJoinRequestById(Integer id);
}
