package com.maltsevve.crud2.model.builders.post;

import com.maltsevve.crud2.model.Post;

public abstract class PostBuilder {
    Post post;

    public void buildPost() {
        post = new Post();
    }

    public void buildContent() {
    }

    public void buildLabels() {
    }

    public Post getPost() {
        return post;
    }
}
