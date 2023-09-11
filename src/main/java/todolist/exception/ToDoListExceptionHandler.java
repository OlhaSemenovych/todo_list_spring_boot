package todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ToDoListExceptionHandler {
    @ExceptionHandler(value
                      = NoSuchElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse
    handleException(NoSuchElementException ex)
    {
        return new ErrorResponse(
            HttpStatus.NOT_FOUND.value(), "Note with such id does not found!");
    }

    @ExceptionHandler(value
            = MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse
    handleException(MethodArgumentTypeMismatchException ex)
    {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), "Letters in Note Id not allowed!");
    }

}

