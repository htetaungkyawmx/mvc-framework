package org.jdc.application.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.jdc.application.view.AddNumberView;
import org.jdc.framework.controller.ControllerMapping;
import org.jdc.framework.controller.IController;
import org.jdc.framework.ds.ViewModel;
import org.jdc.framework.model.Model;
import org.jdc.framework.model.SimpleModel;

@ControllerMapping("/addNumber")
public class AddNumberController implements IController {
    @Override
    public ViewModel handleRequest(HttpServletRequest request) {
        String  num1 = request.getParameter("num1");
        String  num2 = request.getParameter("num2");
        int result = Integer.parseInt(num1) + Integer.parseInt(num2);
        Model model = new SimpleModel();
        model.set("num1","num1");
        model.set("num2","num2");
        model.set("result",String.valueOf(result));
        return new ViewModel(
                new AddNumberView(),
                model
        );
    }
}
