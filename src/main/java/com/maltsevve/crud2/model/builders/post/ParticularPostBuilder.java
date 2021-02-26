package com.maltsevve.crud2.model.builders.post;

import com.maltsevve.crud2.model.Label;

import java.util.List;

public class ParticularPostBuilder extends PostBuilder {
    String content;
    List<Label> labels;

    public ParticularPostBuilder(String content, List<Label> labels) {
        this.content = content;
        this.labels = labels;
    }

    @Override
    public void buildContent() {
        post.setContent(content);
    }

    @Override
    public void buildLabels() {
        post.setLabels(labels);
    }
}
