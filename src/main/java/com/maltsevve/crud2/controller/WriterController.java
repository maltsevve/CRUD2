package com.maltsevve.crud2.controller;

import com.maltsevve.crud2.model.Writer;
import com.maltsevve.crud2.repository.JavaIOWriterRepositoryImpl;
import com.maltsevve.crud2.repository.WriterRepository;

import java.util.List;

public class WriterController {
    WriterRepository wr = new JavaIOWriterRepositoryImpl();
    
    public WriterController() {

    }

    public Writer getByID(Long id) {
        if (id > 0 && wr.getById(id) != null) {
            return wr.getById(id);
        } else {
            return null;
        }
    }

    public List<Writer> getAll() {
        return wr.getAll();
    }

    public Writer save(Writer writer) {
        return wr.save(writer);
    }

    public Writer update(Writer writer) {
        if (writer.getId() > 0 && wr.getById(writer.getId()) != null) {
            return wr.update(writer);
        } else {
            return writer;
        }
    }

    public void deleteById(Long id) {
        if (wr.getById(id) != null) {
            wr.deleteById(id);
        }
    }
}
