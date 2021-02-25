package com.maltsevve.crud2.repository;

import com.maltsevve.crud2.model.Label;

import java.util.List;

public interface LabelRepository extends GenericRepository<Label, Long> {
    @Override
    Label save(Label label);

    @Override
    Label update(Label label);

    @Override
    Label getById(Long aLong);

    @Override
    List<Label> getAll();

    @Override
    void deleteById(Long id);
}
