package com.maltsevve.crud2.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Getter @Setter @NoArgsConstructor
public class Post {
    private Long id;
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labels;
    private PostStatus postStatus;
}
