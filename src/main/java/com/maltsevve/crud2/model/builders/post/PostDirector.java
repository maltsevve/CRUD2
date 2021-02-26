package com.maltsevve.crud2.model.builders.post;

import com.maltsevve.crud2.model.Post;

public class PostDirector {
    PostBuilder postBuilder;

    public void setPostBuilder(PostBuilder postBuilder) {
        this.postBuilder = postBuilder;
    }

    public Post buildPost() {
        postBuilder.buildPost();
        postBuilder.buildContent();
        postBuilder.buildLabels();

        return postBuilder.getPost();
    }
}
