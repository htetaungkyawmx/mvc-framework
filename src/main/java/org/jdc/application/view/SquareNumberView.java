package org.jdc.application.view;

import org.jdc.framework.model.Model;
import org.jdc.framework.view.View;

public class SquareNumberView implements View {
    @Override
    public String render(Model model) {
        return "%s square is :: %s"
                .formatted(model.get("num"),
                model.get("result"));
    }
}
