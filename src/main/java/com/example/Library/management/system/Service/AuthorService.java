package com.example.Library.management.system.Service;

import com.example.Library.management.system.DTO.RequestDtos.AuthorRequestDto;
import com.example.Library.management.system.DTO.ResponseDtos.AuthorResponseDto;
import com.example.Library.management.system.Entity.Author;
import com.example.Library.management.system.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(AuthorRequestDto authorRequestDto){
        Author author=new Author();
        author.setAuthorName(authorRequestDto.getAuthorName());
        author.setAuthorAge(authorRequestDto.getAuthorAge());
        author.setAuthorEmail(authorRequestDto.getAuthorEmail());

        authorRepository.save(author);
        return "Author added";
    }

    public AuthorResponseDto getAuthorById(Integer id){
        Author author=authorRepository.findById(id).get();//accessing author from author repository;

        AuthorResponseDto authorResponseDto=new AuthorResponseDto();
        authorResponseDto.setAuthorName(author.getAuthorName());
        authorResponseDto.setAge(author.getAuthorAge());
        authorResponseDto.setAuthorEmail(author.getAuthorEmail());

        return authorResponseDto;
    }
}

