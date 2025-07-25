package com.hollywood.planary.repository;

import com.hollywood.planary.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByUserUserId(Long userId);
}