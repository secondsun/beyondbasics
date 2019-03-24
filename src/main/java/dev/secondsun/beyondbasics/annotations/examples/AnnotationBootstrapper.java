package dev.secondsun.beyondbasics.annotations.examples;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class AnnotationBootstrapper {
    public <T> T bootstrap(Class<T> clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {

        List<Method> annotatedMethods = getAnnotatedMethods(clazz, AnnotateMe.class);

        T instance = attachAnnotations(clazz, annotatedMethods);


        return instance;
    }

    private <T> T attachAnnotations(Class<T> clazz, List<Method> annotatedMethods) {

        T enhanced = (T) Enhancer.create(clazz, new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if (annotatedMethods.contains(method)) {
                    System.out.println("I'm a running annotation!");
                }
                return methodProxy.invokeSuper(object, args);
            }
        });

        return enhanced;
    }

    private <T> List<Method> getAnnotatedMethods(Class<T> clazz, Class annotationClass) {
        var annotatedMethods = new ArrayList<Method>();
        var classMethods= clazz.getDeclaredMethods();

        for (Method method : classMethods) {
            method.setAccessible(true);
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                if (annotation.annotationType().equals(annotationClass)) {
                    annotatedMethods.add(method);
                    break;
                }
            }
        }

        return annotatedMethods;
    }
}
