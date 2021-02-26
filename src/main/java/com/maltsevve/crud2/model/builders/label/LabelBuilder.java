package com.maltsevve.crud2.model.builders.label;

import com.maltsevve.crud2.model.Label;

public abstract class LabelBuilder {
    Label label;

    public void buildLabel() {
        label = new Label();
    }

    public void buildName() {

    }

    public Label getLabel() {
        return label;
    }

}
