package com.example.demo1;

import com.example.demo1.Model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
    @GetMapping(value = "/")
    public String welcome(){
        return "Welcome to Book Store";
    }
    private List<Book> listBook = new ArrayList<>(Arrays.asList(
            new Book( 1,  "Lap trinh Windows",  "Nguyen Huy Cuong",  99999),
            new Book( 2,  "Lap trinh Web",  "Nguyen Huy Cuong",  12345),
            new Book( 3,  "Lap trinh ung dung Java",  "Nguyen Huy Cuong",  99999),
            new Book( 4,  "Thuong mai dien tu",  "Nguyen Dinh Anh",  99999)));

    @GetMapping(value = "/books")
    public List<Book> GetAll(){
        return listBook;
    }

    @GetMapping(value = "/books/{id}")
    public Book get(@PathVariable int id){
        var findBook = listBook.stream().filter(p->p.getId()==id).findFirst().orElse(null);
        if(findBook == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return findBook;
    }

    @PostMapping(value = "/books")
    public Book create(@RequestBody Book book){
        var maxId = listBook.stream().mapToInt(v -> v.getId()).max().orElse(0);
        book.setId(maxId+1);
        listBook.add(book);
        return book;
    }
    @DeleteMapping(value = "/books/{id}")
    public void delete(@PathVariable int id){
        var findBook = listBook.stream().filter(p->p.getId()==id).findFirst().orElse(null);
        if(findBook == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        listBook.remove(findBook);
    }

}
