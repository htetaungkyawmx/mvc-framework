package org.jdc.application.view;

import org.jdc.framework.model.Model;
import org.jdc.framework.view.View;

public class AddNumberView implements View {
    @Override
    public String render(Model model) {
        return "%s add %s = %s"
                .formatted(model.get("num1"),
                        model.get("num2"),
                        model.get("result"));
    }
}
