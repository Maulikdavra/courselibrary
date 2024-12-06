package com.md.courselibrary.repository;

import com.md.courselibrary.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findPublisherByName(String name);
}
