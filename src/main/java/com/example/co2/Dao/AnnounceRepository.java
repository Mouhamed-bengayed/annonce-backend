package com.example.co2.Dao;

import com.example.co2.Entite.Announce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnounceRepository extends JpaRepository<Announce,Long> {

    List<Announce> findAllByUserco2Id(long id);
}
