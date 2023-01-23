package edu.miu.waaassignment3.springAop;

import edu.miu.waaassignment3.entity.Exception;
import edu.miu.waaassignment3.entity.Logger;
import edu.miu.waaassignment3.entity.Users;
import edu.miu.waaassignment3.repo.ExceptionRepo;
import edu.miu.waaassignment3.repo.LoggerRepo;
import edu.miu.waaassignment3.repo.UserRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Aspect
public class ExecutionTimeAspect {

    @Autowired
    private LoggerRepo loggerRepo;

   @Autowired
   private static Users users;

   @Autowired
   private static ExceptionRepo exceptionRepo;










    @Pointcut("@annotation(edu.miu.waaassignment3.springAop.ExecutionTime)")
    public void executionTimeAnnotation(){

    }



    @Around("executionTimeAnnotation()")

    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start= System.nanoTime();
        var result= proceedingJoinPoint.proceed();
        long finish= System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName()+ " It takes=>" + (finish-start));
       // users.setName("Kidus");
        Logger a = new Logger();
        a.setDate(LocalDate.now());
        a.setTime(LocalTime.now());
        a.setPrinciple("Kidus");
        a.setOperation("READ");
        loggerRepo.save(a);
        return result;
    }


    @AfterThrowing(value = "executionTimeAnnotation()", throwing = "exception")

    public Object saveException(JoinPoint joinPoint, Throwable exception){
        long start= System.nanoTime();
        var result= joinPoint.getSignature().getName();
        long finish= System.nanoTime();
       // System.out.println(proceedingJoinPoint.getSignature().getName()+ " It takes=>" + (finish-start));
        // users.setName("Kidus");
        Exception a = new Exception();

        a.setDate(LocalDate.now());
        a.setTime(LocalTime.now());
        a.setPrinciple("Kidus");
        a.setOperation("READ");
        a.setExceptionType(exception.getMessage());
        exceptionRepo.save(a);
        return result;
    }


}
