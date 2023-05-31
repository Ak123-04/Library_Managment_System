package com.example.Library.management.system.Service;


import com.example.Library.management.system.DTO.RequestDtos.AuthorRequestDto;
import com.example.Library.management.system.DTO.RequestDtos.BookRequestDto;
import com.example.Library.management.system.Entity.Author;
import com.example.Library.management.system.Entity.Book;
import com.example.Library.management.system.Repository.AuthorRepository;
import com.example.Library.management.system.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;
    public String addBook(BookRequestDto bookRequestDto) throws Exception {

        Author author=new Author();
        try {
            author = authorRepository.findById(bookRequestDto.getAuthorId()).get();

        }
        catch (Exception e){
            throw new Exception("you are not registered as author");
        }
        Book book=new Book();
        book.setName(bookRequestDto.getBookName());
        book.setTotalPages(bookRequestDto.getTotalPages());
        book.setGenre(bookRequestDto.getGenre());

        author.getBookList().add(book);
        book.setAuthor(author);

        bookRepository.save(book);
        return "Book Added to Database";
    }
}
