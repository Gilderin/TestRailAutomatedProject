package org.techmeskills.aqa5.auf.models;

import lombok.*;

@Data
@Getter
@Setter
@ToString(exclude = "isActive")
@Builder(toBuilder = true)
public class ProjectLombok {
    private String name;
    private String announcement;
    private boolean show_announcement;
    private int suite_mode;
    private boolean is_completed;
    private String job;
    private String password;
    private String email;
}
