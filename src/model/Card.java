package model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor


public class Card extends BaseModel {

    private String name;
    @NonNull
    private String cardNum;
    private Double amount;
    private UUID userId;

}
