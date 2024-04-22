package org.jdc.framework.ds;

import org.jdc.framework.model.Model;
import org.jdc.framework.view.View;

public class ViewModel {
    private View view;
    private Model model;

    public ViewModel(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public Model getModel() {
        return model;
    }
}
