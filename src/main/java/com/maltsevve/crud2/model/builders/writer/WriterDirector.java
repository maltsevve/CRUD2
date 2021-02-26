package com.maltsevve.crud2.model.builders.writer;

import com.maltsevve.crud2.model.Writer;

public class WriterDirector {
    WriterBuilder writerBuilder;

    public void setWriterBuilder(WriterBuilder writerBuilder) {
        this.writerBuilder = writerBuilder;
    }

    public Writer buildWriter() {
        writerBuilder.buildWriter();
        writerBuilder.buildFirstName();
        writerBuilder.buildLastName();
        writerBuilder.buildPosts();

        return writerBuilder.getWriter();
    }
}
