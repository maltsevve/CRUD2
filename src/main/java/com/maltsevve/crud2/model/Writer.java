package com.maltsevve.crud2.model;

import lombok.*;

import java.util.List;

@Data
@Getter @Setter @NoArgsConstructor
public class Writer {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
}
