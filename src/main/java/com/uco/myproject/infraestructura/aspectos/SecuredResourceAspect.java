package com.uco.myproject.infraestructura.aspectos;

import com.uco.myproject.infraestructura.aspectos.exception.ExceptionUserUnauthorized;
import com.uco.myproject.infraestructura.aspectos.servicio.AuthorizationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class SecuredResourceAspect {
    private static final String MESSAGE_USER_UNATHORIZED = "Forbidden!";

    private final AuthorizationService authorizationService;

    public SecuredResourceAspect(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Before("@annotation(SecuredResource)")
    public void processMethodsAnnotatedWithProjectSecuredAnnotation(JoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SecuredResource annotation = method.getAnnotation(SecuredResource.class);

        String resourceToAuthorized = annotation.name();

        boolean isUserAuthorized = this.authorizationService.isAuthorized(resourceToAuthorized);

        analyzeIfCanContinue(isUserAuthorized);
    }

    private void analyzeIfCanContinue(boolean isUserAuthorized) throws Throwable {
        if (!isUserAuthorized) {
            throw new ExceptionUserUnauthorized(MESSAGE_USER_UNATHORIZED);
        }
    }
}
