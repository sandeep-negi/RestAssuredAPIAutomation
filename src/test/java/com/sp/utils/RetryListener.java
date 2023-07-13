package com.sp.utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation testAnnotation,
                          Class testClass,
                          Constructor testConstructor,
                          Method testMethod) {
        testAnnotation.setRetryAnalyzer(FailRetry.class); // Pass Class Name i.e FailRetry ClassName

    }
}
