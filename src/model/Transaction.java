package model;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Transaction extends BaseModel {
    private UUID senderId;
    private UUID receiverId;
    private Double amount;
    private Date date;
}
