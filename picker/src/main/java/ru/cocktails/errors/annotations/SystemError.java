package ru.cocktails.errors.annotations;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ru.cocktails.errors.model.ApplicationError;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Возникла ошибка при работе с данными запроса",
                response = ApplicationError.class),
        @ApiResponse(code = 404, message = "Обработчик не найден",
                response = ApplicationError.class)
})
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemError {
}
