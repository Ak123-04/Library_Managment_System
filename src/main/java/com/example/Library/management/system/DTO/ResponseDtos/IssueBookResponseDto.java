package com.example.Library.management.system.DTO.ResponseDtos;

import com.example.Library.management.system.Enums.BookTransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {

    private int cardId;

    private String bookName;

    private String transactionNumber;

     private BookTransactionStatus transactionStatus;

}
