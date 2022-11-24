package com.SFA.Utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

public class Testtransformer implements IAnnotationTransformer
{
	
	public void transform(ITestAnnotation Annotation, Constructor constructor, Method testmethod, Class testclass)
	{
		
		Annotation.setRetryAnalyzer(RetryAnalayzer.class);
		
	}

}

