package com.thoughtworks.todoService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Todo {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String status;
    private Date dueDate;
    private Long userId;

    @ManyToMany
    @JoinTable(name = "todo_tag",
        joinColumns = @JoinColumn(name = "todo_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();


}
