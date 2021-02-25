package com.maltsevve.crud2.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maltsevve.crud2.model.Label;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class JavaIOLabelRepositoryImpl implements LabelRepository {
    private final static String labels = "src/main/resources/files/labels.json";
    private final static Gson GSON = new Gson();

    public JavaIOLabelRepositoryImpl() {
    }

    public Label getById(Long id) {
        List<Label> labels = readToList();
        return labels.stream().filter((n) -> n.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Label> getAll() {
        return readToList();
    }

    public Label save(Label label) {
        label.setId(generateID());
        List<Label> labels = readToList() != null ? readToList() : new ArrayList<>();
        labels.add(label);
        writeFromList(labels);
        return label;
    }

    public Label update(Label label) {
        List<Label> labels = readToList();
        Label lb = labels.stream().filter((n) -> n.getId().equals(label.getId())).findFirst().orElse(null);
        if (lb == null) {
            System.out.println("Update is unavailable: no such ID in the file.");
        } else {
            labels.set(labels.indexOf(lb), label);
            writeFromList(labels);
        }
        return label;
    }

    public void deleteById(Long id) {
        List<Label> labels = readToList();
        if (labels.removeIf(label -> label.getId().equals(id))) {
            System.out.println("Label " + id + " deleted.");
        }
        writeFromList(labels);
    }


    private void writeFromList(List<Label> list) {
        try (FileWriter fw = new FileWriter(labels)) {
            if (!list.isEmpty()) {
                GSON.toJson(list, fw);
            } else {
                fw.write("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Label> readToList() {
        StringBuilder retrieved = new StringBuilder();
        try {
            Files.lines(Paths.get(labels), StandardCharsets.UTF_8).forEach(retrieved::append);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Type tLabels = new TypeToken<List<Label>>() {
        }.getType();
        return GSON.fromJson(retrieved.toString(), tLabels);
    }

    Long generateID() {
        List<Label> labels = readToList();
        if (labels != null) {
            return Objects.requireNonNull(labels.stream().max(Comparator.
                    comparing(Label::getId)).orElse(null)).getId() + 1;
        } else {
            return 1L;
        }
    }
}
