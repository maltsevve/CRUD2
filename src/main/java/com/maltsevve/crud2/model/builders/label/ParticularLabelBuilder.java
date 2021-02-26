package com.maltsevve.crud2.model.builders.label;

public class ParticularLabelBuilder extends LabelBuilder {
    String name;

    public ParticularLabelBuilder(String name) {
        this.name = name;
    }

    @Override
    public void buildName() {
        label.setName(name);
    }
}
