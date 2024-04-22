package org.jdc.application.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.jdc.application.view.IndexView;
import org.jdc.framework.controller.ControllerMapping;
import org.jdc.framework.controller.IController;
import org.jdc.framework.ds.ViewModel;
import org.jdc.framework.model.SimpleModel;

@ControllerMapping("/")
public class IndexController implements IController {

    @Override
    public ViewModel handleRequest(HttpServletRequest request) {
        return new ViewModel(
                new IndexView(),
                new SimpleModel()
        );
    }
}
