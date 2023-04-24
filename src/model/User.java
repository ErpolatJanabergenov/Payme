package model;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor


@ToString
public class User extends BaseModel {
    @NonNull
    private String name;
    @NonNull
    private String username;
    @NonNull
    private String password;
    private UserRole role;



}
