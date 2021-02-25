package com.maltsevve.crud2.controller;

import com.maltsevve.crud2.model.Label;
import com.maltsevve.crud2.repository.JavaIOLabelRepositoryImpl;

import java.util.List;

public class LabelController {
    JavaIOLabelRepositoryImpl lr = new JavaIOLabelRepositoryImpl();

    public LabelController() {
    }

    public Label getByID(Long id) {
        if (id > 0 && lr.getById(id) != null) {
            return lr.getById(id);
        } else {
            return null;
        }
    }

    public List<Label> getAll() {
        return lr.getAll();
    }

    public Label save(Label label) {
        return lr.save(label);
    }

    public Label update(Label label) {
        if (label.getId() > 0 && lr.getById(label.getId()) != null) {
            return lr.update(label);
        } else {
            return label;
        }
    }

    public void deleteById(Long id) {
        if (lr.getById(id) != null) {
            lr.deleteById(id);
        }
    }
}
