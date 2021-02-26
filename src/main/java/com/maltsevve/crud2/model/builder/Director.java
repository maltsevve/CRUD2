package com.maltsevve.crud2.model.builder;

import com.maltsevve.crud2.model.Writer;

public class Director {
    WriterBuilder writerBuilder;

    public void setWriterBuilder(WriterBuilder writerBuilder) {
        this.writerBuilder = writerBuilder;
    }

    public Writer buildWriter() {
        writerBuilder.buildFirstName();
        writerBuilder.buildLastName();
        writerBuilder.buildPosts();

        return writerBuilder.getWriter();
    }
}
