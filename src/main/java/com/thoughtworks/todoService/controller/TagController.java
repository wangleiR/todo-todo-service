package com.thoughtworks.todoService.controller;

import com.thoughtworks.todoService.model.Tag;
import com.thoughtworks.todoService.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired private TagService tagService;

    @PostMapping
    public Tag addTag(@RequestBody Tag tag){
        return tagService.addTag(tag);
    }

    @GetMapping
    public Page<Tag> getTagList(Pageable pageable){
        return tagService.getTagList(pageable);
    }


}