package edu.miu.waaassignment3.springAop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface ExecutionTime {
}
