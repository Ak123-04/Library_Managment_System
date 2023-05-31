package com.example.Library.management.system.Service;


import com.example.Library.management.system.DTO.RequestDtos.IssueBookRequestDto;
import com.example.Library.management.system.DTO.ResponseDtos.IssueBookResponseDto;
import com.example.Library.management.system.Entity.Book;
import com.example.Library.management.system.Entity.Card;
import com.example.Library.management.system.Entity.Transaction;
import com.example.Library.management.system.Enums.BookTransactionStatus;
import com.example.Library.management.system.Enums.CardStatus;
import com.example.Library.management.system.Exceptions.InvalidBookId;
import com.example.Library.management.system.Exceptions.InvalidCardId;
import com.example.Library.management.system.Repository.BookRepository;
import com.example.Library.management.system.Repository.CardRepository;
import com.example.Library.management.system.Repository.StudentRepository;
import com.example.Library.management.system.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

import java.util.UUID;

import static org.springframework.transaction.TransactionStatus.*;

@Service
public class TransactionService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

//    @Autowired
//    private JavaMailSender emailSender;

    public IssueBookResponseDto issueTheBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction=new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        Card card;//checking card is registered or not.
        try{
            card=cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }catch(Exception e){
            transaction.setBooktransactionStatus(BookTransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card does not exist in database");
        }
        transaction.setCard(card);

        Book book;//checking do we have book in records
                try{
                    book=bookRepository.findById(issueBookRequestDto.getBookId()).get();
                }catch(Exception e){
                    transaction.setBooktransactionStatus(BookTransactionStatus.FAILED);
                    transactionRepository.save(transaction);
                    throw new InvalidBookId("Invalid book id");
                }
                transaction.setBook(book);

                if(card.getCardStatus()!= CardStatus.ACTIVATED){//checking if card is registered then is it activated still or not
                    transaction.setBooktransactionStatus(BookTransactionStatus.FAILED);
                    transactionRepository.save(transaction);
                    throw new Exception("Card is not activated");
                }

                if(book.isIssued()==true){//checking if we have book in record is that issued already or not.
                    transaction.setBooktransactionStatus(BookTransactionStatus.FAILED);
                    transactionRepository.save(transaction);
                    throw new Exception("book is not available");
                }

                transaction.setBooktransactionStatus(BookTransactionStatus.SUCCESSFUL);
                book.setIssued(true);
                book.setCard(card);
                book.getTransactionList().add(transaction);

                card.getBookIssued().add(book);//adding issuing bookList of already issued by card.
                card.getTransactionList().add(transaction);//adding transaction to transactionList having card class which show the completed transaction using this card.

                cardRepository.save(card);//saving transaction,card and book


        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setCardId(card.getId());
        issueBookResponseDto.setBookName(book.getName());
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(transaction.getBooktransactionStatus());

//        String text = "Congrats! " + card.getStudent().getName() +  " You have been issued the book " + book.getName();
//
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("acciojobbackendapril@gmail.com");
//        message.setTo(card.getStudent().getMobNo());
//        message.setSubject("Issue book");
//        message.setText(text);
//        emailSender.send(message);

        return issueBookResponseDto;

    }
}
