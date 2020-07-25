package org.techmeskills.aqa5.auf.models;

import lombok.*;

@Data
@Getter
@Setter
@ToString(exclude = "isActive")
@Builder(toBuilder = true)
public class UsersOriginal {
    private String email;
    private String password;
    private String name;
    private String surname;
    private boolean isActive;
    private int  id;
}
