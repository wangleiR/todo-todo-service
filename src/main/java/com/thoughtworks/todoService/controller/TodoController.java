package com.thoughtworks.todoService.controller;

import com.thoughtworks.todoService.exception.HttpStateCode404Exception;
import com.thoughtworks.todoService.model.Todo;
import com.thoughtworks.todoService.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired  private TodoService todoService;


    @GetMapping
    public Page<Todo> getTodo(Pageable pageable){
        return todoService.getTodoLists(pageable);
    }


    @GetMapping(value = "/{id}")
    public Todo getListById(@PathVariable(value = "id") Long id) throws HttpStateCode404Exception {
        return todoService.getTodoById(id);
    }

    @PostMapping
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @PutMapping
    public Todo editTodo(@RequestBody Todo todo){
         return todoService.editTodo(todo);
    }

    @DeleteMapping(value = "/{id}")
    public Map<String,Long> deleteTodo(@PathVariable(value = "id") Long id){
        return todoService.deleteTodo(id);
    }


    @GetMapping("/search")
    public  Page<Todo> getListWithSearch(@RequestParam(required = false)  String from,
                                         @RequestParam(required = false)  String to,
                                         @RequestParam(required = false)  String searchNameOrTagsValue,
                                         Pageable pageable){

            return todoService.getListWithSearchCondintion(from,to,searchNameOrTagsValue,pageable);

    }


}
