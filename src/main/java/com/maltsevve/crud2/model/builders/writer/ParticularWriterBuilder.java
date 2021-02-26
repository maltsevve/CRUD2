package com.maltsevve.crud2.model.builders.writer;

import com.maltsevve.crud2.model.Post;

import java.util.List;

public class ParticularWriterBuilder extends WriterBuilder{
    String firstName;
    String lastName;
    List<Post> posts;

    public ParticularWriterBuilder(String firstName, String lastName, List<Post> posts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
    }

    @Override
    public void buildFirstName() {
        writer.setFirstName(firstName);
    }

    @Override
    public void buildLastName() {
        writer.setLastName(lastName);
    }

    @Override
    public void buildPosts() {
        writer.setPosts(posts);
    }
}
