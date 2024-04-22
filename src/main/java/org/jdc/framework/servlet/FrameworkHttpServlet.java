package org.jdc.framework.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jdc.framework.controller.IController;
import org.jdc.framework.ds.ViewModel;
import org.jdc.framework.view.View;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "mvc-servlet", urlPatterns = "/*")
public class FrameworkHttpServlet extends HttpServlet {

    private Map<String, IController> maps = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        IController iController = maps.get(uri);

        if (iController != null) {
            ViewModel modelAndView = iController.handleRequest(req);
            Model model = (Model) modelAndView.getModel();
            View view = modelAndView.getView();

            String renderString = view.render((org.jdc.framework.model.Model) model);

            resp.setContentType("text/html");
            resp.getWriter().println(renderString);

        } else
            throw new ServletException("Controller not Found!");
    }
}
