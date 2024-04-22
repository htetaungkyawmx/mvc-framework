package org.jdc.application.view;

import org.jdc.framework.model.Model;
import org.jdc.framework.view.View;

public class IndexView implements View {
    @Override
    public String render(Model model) {
        return """  
                <h1> Welcome Page </h1>
                <p> Please click the following links </p>
                <ul>
                  <li><a href="/addNumber?num1=5&num2=7">/addNumber?num1=5&num2=7</a></li>
                  <li><a href="/squareNumber?num = 6>/squareNumber?num = 6</a></li>
                </ul>
                """;
    }
}
