package org.jdc.application.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.jdc.application.view.SquareNumberView;
import org.jdc.framework.controller.ControllerMapping;
import org.jdc.framework.controller.IController;
import org.jdc.framework.ds.ViewModel;
import org.jdc.framework.model.Model;
import org.jdc.framework.model.SimpleModel;

@ControllerMapping("/squareNumber")
public class SquareNumberController implements IController {
    @Override
    public ViewModel handleRequest(HttpServletRequest request) {
        int num = Integer.parseInt(request.getParameter("num"));
        int result = num * num;
        Model model = new SimpleModel();
        model.set("num",String.valueOf(num));
        model.set("result",String.valueOf(result));
        return new ViewModel(
                new SquareNumberView(),
                model
        );
    }
}
