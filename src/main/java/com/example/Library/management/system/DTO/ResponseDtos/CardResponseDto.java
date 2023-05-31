package com.example.Library.management.system.DTO.ResponseDtos;

import com.example.Library.management.system.Enums.CardStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CardResponseDto {
    private int id;
    private Date issueDate;


    private Date updateOn;//storing date on which card was updated.

    private CardStatus cardStatus;

    private String validTill;
}
