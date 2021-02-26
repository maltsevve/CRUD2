package com.maltsevve.crud2.model.builder;

import com.maltsevve.crud2.model.Writer;

import java.util.ArrayList;

public class WriterBuilder {
    Writer writer;

    public void buildWriter() {
        writer = new Writer();
    }

    public void buildFirstName() {
        writer.setFirstName("");
    }

    public void buildLastName() {
        writer.setLastName("");
    }

    public void buildPosts() {
        writer.setPosts(new ArrayList<>());
    }

    public Writer getWriter() {
        return writer;
    }
}
