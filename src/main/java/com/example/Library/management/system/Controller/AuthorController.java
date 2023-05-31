package com.example.Library.management.system.Controller;


import com.example.Library.management.system.DTO.RequestDtos.AuthorRequestDto;
import com.example.Library.management.system.DTO.ResponseDtos.AuthorResponseDto;
import com.example.Library.management.system.Repository.AuthorRepository;
import com.example.Library.management.system.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {


    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto){

        return authorService.addAuthor(authorRequestDto);
    }

    @GetMapping("/get_author")
    public AuthorResponseDto getAuthorById(@RequestParam("authorId")Integer id){
        return authorService.getAuthorById(id);
    }

}
