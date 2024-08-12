package com.contact.manag.agenda.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ManagerAgendaAspect {

    private static final Logger logger = LoggerFactory.getLogger(ManagerAgendaAspect.class);

    // Se hace log para llamada de servicios en modo debug
    @Before("execution(* com.contact.manag.agenda.services..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        String logText = ">>> Se ejecuta servicio " + getMethodName(joinPoint);
        StringBuilder argsStr = new StringBuilder();

        for (Object arg : args) {
            String argStr = "";
            if (null == arg) {
                argStr = "null";
            }else{
                argStr = arg.toString();
            }
            argsStr.append(argStr).append(", ");
        }
        if (argsStr.length() > 0) {
            argsStr.setLength(argsStr.length() - 2);
            logText = logText + " con los parametros: " + argsStr;
        }
        logger.debug(logText);
    }

    // Se hace log para retorno de servicios en modo debug
    @AfterReturning(pointcut = "execution(* com.contact.manag.agenda.services..*.*(..))", returning = "result")
    public void logAfterRetur(JoinPoint joinPoint, Object result) {
        logger.debug("<<< " + getMethodName(joinPoint) + " retorna: " + result);
    }

    private String getMethodName(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod().getName();
    }
}
