package com.example.Library.management.system.Controller;


import com.example.Library.management.system.DTO.RequestDtos.IssueBookRequestDto;
import com.example.Library.management.system.DTO.ResponseDtos.IssueBookResponseDto;
import com.example.Library.management.system.Repository.TransactionRepository;
import com.example.Library.management.system.Service.TransactionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue-book")
    public ResponseEntity issueTheBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {

        try{
            IssueBookResponseDto issueBookResponseDto=transactionService.issueTheBook(issueBookRequestDto);
            return new ResponseEntity(issueBookResponseDto, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
