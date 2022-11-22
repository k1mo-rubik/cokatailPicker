package ru.cocktails.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.cocktails.errors.exception.ApplicationException;
import ru.cocktails.errors.model.ApplicationError;

import javax.servlet.http.HttpServletResponse;

public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(ApplicationException.class)
    public ApplicationError applicationException(ApplicationException ex, HttpServletResponse response) {
        response.setStatus(ex.getError().getStatus().value());
        return ex.getError();
    }

}
