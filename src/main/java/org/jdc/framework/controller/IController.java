package org.jdc.framework.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.jdc.framework.ds.ViewModel;

public interface IController {

    ViewModel handleRequest(HttpServletRequest request);
}
