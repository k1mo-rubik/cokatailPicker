package ru.cocktails.errors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@ApiModel
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class ApplicationError {



    @ApiModelProperty(notes = "Тип ошибки", required = true)
    private ErrorType errorType;

    @ApiModelProperty(notes = "Сообщение об ошибке", example = "Обработчик не найден", required = true)
    private String message;

    @ApiModelProperty(notes = "Время возникновения", example = "2022-11-18T12:46:16.575817", required = true)
    private LocalDateTime time;

    @ApiModelProperty(notes = "HTTP статус ошибки", example = "404", required = true)
    private HttpStatus status;

    /**
     * Создание ошибки.
     *
     * @param message   текст ошибки.
     * @param errorType тип ошиби.
     * @param status    статус ошибки.
     */

    public ApplicationError(String message, ErrorType errorType, HttpStatus status) {
        this.message = message;
        this.errorType = errorType;
        this.status = status;
        this.time = LocalDateTime.now();
    }
}
