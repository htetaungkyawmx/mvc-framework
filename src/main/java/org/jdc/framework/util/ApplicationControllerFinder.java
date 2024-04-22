package org.jdc.framework.util;

import javassist.tools.reflect.Reflection;
import org.jdc.framework.controller.ControllerMapping;
import org.jdc.framework.controller.IController;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ApplicationControllerFinder {

    public Map<String, IController> findControllers() {
        return new Reflections()
                .getTypesAnnotatedWith(ControllerMapping.class)
                .stream()
                .map(this::getAsControllerClass)
                .map(this::getControllerInstance)
                .collect(Collectors.toMap(this::getUri, Function.identity()));
    }
    private Class<IController> getAsControllerClass(Class<?> aClass) {
        return (Class<IController>) aClass;
    }

    private IController getControllerInstance(Class<IController> iControllerClass) {
        try {
            return iControllerClass.getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
    private String getUri(IController iController){
        return iController.getClass()
                .getAnnotation(ControllerMapping.class)
                .value();
    }
}
