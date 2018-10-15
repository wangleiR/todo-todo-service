package com.thoughtworks.todoService.repository;

import com.thoughtworks.todoService.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Repository
public interface TodoRepository  extends JpaRepository<Todo,Long> {

    Page<Todo> findAllByUserId(Long userId, Pageable pageable);

    Todo findByIdAndUserId(Long id, Long userId);

    @Modifying
    @Transactional
    @Query("delete from Todo t where t.id = ?1 and t.userId = ?2")
    void deleteByIdAndUserId(Long id, Long userId);

    Page<Todo> findByUserIdAndNameContains(Long userId, String name, Pageable pageable);

    Page<Todo> findByUserIdAndDueDateIsBetweenAndNameContains(Long userId, Date from, Date to, String name, Pageable pageable);

    Page<Todo> findByUserIdAndTags_Value(Long userId, String value, Pageable pageable);
}
