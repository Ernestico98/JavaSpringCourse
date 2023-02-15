package com.harbourspace.HW7.aspects;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.stream.Stream;

@Aspect
@Component
public class AuthAspect {

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object checkAuthTokenValue(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) joinPoint.getStaticPart().getSignature();
        var annotations = Arrays.stream(methodSignature.getMethod().getAnnotations()).map(Annotation::toString).toList();

        var isGetEndpoint = annotations.stream().map(item -> item.contains("GetMapping")).findAny();
        var isPostEndpoint = annotations.stream().map(item -> item.contains("PostMapping")).findAny();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();

        String token = request.getHeader("x-harbour-auth");

        if (isPostEndpoint.isPresent() && isGetEndpoint.get() && !"read".equals(token))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        if (isPostEndpoint.isPresent() && isPostEndpoint.get() && !"write".equals(token))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        return joinPoint.proceed();
    }




}

