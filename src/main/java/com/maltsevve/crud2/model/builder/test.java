package com.maltsevve.crud2.model.builder;

import com.maltsevve.crud2.model.Writer;
import com.maltsevve.crud2.repository.JavaIOPostRepositoryImpl;

class test {
    public static void main(String[] args) {
        JavaIOPostRepositoryImpl pr = new JavaIOPostRepositoryImpl();

        Director director = new Director();
        WriterBuilder writerBuilder = new ParticularWriterBuilder("AAA", "BBB", pr.getAll());

        director.setWriterBuilder(writerBuilder);

        Writer writer = director.buildWriter();


//        Writer writer = Writer.builder()
//                .firstName("AAAA")
//                .lastName("BBBB")
//                .posts(pr.getAll())
//                .build();

    }
}
