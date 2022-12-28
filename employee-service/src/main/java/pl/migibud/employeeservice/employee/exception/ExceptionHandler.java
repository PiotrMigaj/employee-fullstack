package pl.migibud.employeeservice.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = EmployeeException.class)
    ResponseEntity<ErrorInfo> handleEmployeeException(EmployeeException e){
        HttpStatus status = null;
        if (EmployeeError.EMPLOYEE_NOT_FOUND.equals(e.getEmployeeError())){
            status = HttpStatus.NOT_FOUND;
        }
        ErrorInfo errorInfo = new ErrorInfo(LocalDateTime.now(),status, e.getMessage());
        return ResponseEntity.status(status).body(errorInfo);
    }

}
