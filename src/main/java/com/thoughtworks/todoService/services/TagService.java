package com.thoughtworks.todoService.services;

import com.thoughtworks.todoService.model.Tag;
import com.thoughtworks.todoService.model.User;
import com.thoughtworks.todoService.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tag addTag(Tag tag) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getId() != null){
            Tag tagExist = tagRepository.findOneByUserIdAndValue(user.getId(), tag.getValue());
            if (tagExist == null){
                tag.setUserId(user.getId());
                return tagRepository.save(tag);
            }else {
                return tag;
            }
        }
        return null;
    }

    public Page<Tag> getTagList(Pageable pageable) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null){
            return tagRepository.findAllByUserId(user.getId(),pageable);
        }
        return null;
    }


    public Page<Tag> getTagListByValueAndUserId(String value, Long id,Pageable pageable) {
        return tagRepository.findByValueAndUserId(value,id,pageable);
    }
}
