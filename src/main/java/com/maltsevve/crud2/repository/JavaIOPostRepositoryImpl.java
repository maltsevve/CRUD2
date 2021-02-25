package com.maltsevve.crud2.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maltsevve.crud2.model.Post;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class JavaIOPostRepositoryImpl implements PostRepository {
    private final static String posts = "src/main/resources/files/posts.json";
    private final static Gson GSON = new Gson();

    public JavaIOPostRepositoryImpl() {

    }

    @Override
    public Post save(Post post) {
        post.setId(generateID());
        post.setCreated(new Date());
        List<Post> posts = readToList() != null ? readToList() : new ArrayList<>();
        posts.add(post);
        writeFromList(posts);
        return post;
    }

    @Override
    public Post update(Post post) {
        post.setUpdated(new Date());
        List<Post> posts = readToList();
        Post post1 = posts.stream().filter((n) -> n.getId().equals(post.getId())).findFirst().orElse(null);
        if (post1 == null) {
            System.out.println("Update is unavailable: no such ID in the file.");
        } else {
            posts.set(posts.indexOf(post1), post);
            writeFromList(posts);
        }
        return post;
    }

    @Override
    public Post getById(Long id) {
        List<Post> posts = readToList();
        return posts.stream().filter((n) -> n.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return readToList();
    }

    @Override
    public void deleteById(Long id) {
        List<Post> posts = readToList();
        if (posts.removeIf(post -> post.getId().equals(id))) {
            System.out.println("Post " + id + " deleted.");
        }
        writeFromList(posts);
    }

    private void writeFromList(List<Post> list) {
        try (FileWriter fw = new FileWriter(posts)) {
            if (!list.isEmpty()) {
                GSON.toJson(list, fw);
            } else {
                fw.write("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Post> readToList() {
        StringBuilder retrieved = new StringBuilder();
        try {
            Files.lines(Paths.get(posts), StandardCharsets.UTF_8).forEach(retrieved::append);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Type tLabels = new TypeToken<List<Post>>(){}.getType();
        return GSON.fromJson(retrieved.toString(), tLabels);
    }

    Long generateID() {
        List<Post> posts = readToList();
        if (posts != null) {
            return Objects.requireNonNull(posts.stream().max(Comparator.
                    comparing(Post::getId)).orElse(null)).getId() + 1;
        } else {
            return 1L;
        }
    }
}
