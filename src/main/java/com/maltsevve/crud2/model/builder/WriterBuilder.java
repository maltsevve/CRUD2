package com.maltsevve.crud2.model.builder;

import com.maltsevve.crud2.model.Writer;

public abstract class WriterBuilder {
    Writer writer;

    public void buildWriter() {
        writer = new Writer();
    }

    public void buildFirstName() {
    }

    public void buildLastName() {
    }

    public void buildPosts() {
    }

    public Writer getWriter() {
        return writer;
    }
}
