package com.maltsevve.crud2.model.builders.label;

import com.maltsevve.crud2.model.Label;

public class LabelDirector {
    LabelBuilder labelBuilder;

    public void setLabelBuilder(LabelBuilder labelBuilder) {
        this.labelBuilder = labelBuilder;
    }

    public Label buildLabel() {
        labelBuilder.buildLabel();
        labelBuilder.buildName();

        return labelBuilder.getLabel();
    }
}
