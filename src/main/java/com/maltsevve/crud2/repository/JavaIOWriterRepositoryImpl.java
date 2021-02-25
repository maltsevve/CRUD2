package com.maltsevve.crud2.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maltsevve.crud2.model.Writer;

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

public class JavaIOWriterRepositoryImpl implements WriterRepository {
    private final String writers = "src/main/resources/files/writers.json";
    private final static Gson GSON = new Gson();

    public JavaIOWriterRepositoryImpl() {
    }

    @Override
    public Writer save(Writer writer) {
        writer.setId(generateID());
        List<Writer> writers = readToList() != null ? readToList() : new ArrayList<>();
        writers.add(writer);
        writeFromList(writers);
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        List<Writer> writers = readToList();
        Writer writer1 = writers.stream().filter((n) -> n.getId().equals(writer.getId())).findFirst().orElse(null);
        if (writer1 == null) {
            System.out.println("Update is unavailable: no such ID in the file.");
        } else {
            writers.set(writers.indexOf(writer1), writer);
            writeFromList(writers);
        }
        return writer;
    }

    @Override
    public Writer getById(Long id) {
        List<Writer> writers = readToList();
        return writers.stream().filter((n) -> n.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Writer> getAll() {
        return readToList();
    }

    @Override
    public void deleteById(Long id) {
        List<Writer> writers = readToList();
        if (writers.removeIf(writer -> writer.getId().equals(id))) {
            System.out.println("Writer " + id + " deleted.");
        }
        writeFromList(writers);
    }

    private void writeFromList(List<Writer> list) {
        try (FileWriter fw = new FileWriter(writers)) {
            if (!list.isEmpty()) {
                GSON.toJson(list, fw);
            } else {
                fw.write("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Writer> readToList() {
        StringBuilder retrieved = new StringBuilder();
        try {
            Files.lines(Paths.get(writers), StandardCharsets.UTF_8).forEach(retrieved::append);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Type tLabels = new TypeToken<List<Writer>>(){}.getType();
        return GSON.fromJson(retrieved.toString(), tLabels);
    }


    Long generateID() {
        List<Writer> writers = readToList();
        if (writers != null) {
            return Objects.requireNonNull(writers.stream().max(Comparator.
                    comparing(Writer::getId)).orElse(null)).getId() + 1;
        } else {
            return 1L;
        }
    }
}
