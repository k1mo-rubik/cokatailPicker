package ru.cocktails.errors.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.cocktails.errors.model.ApplicationError;

@Getter
@AllArgsConstructor(staticName = "of")
public class ApplicationException extends RuntimeException {
    private ApplicationError error;


}

