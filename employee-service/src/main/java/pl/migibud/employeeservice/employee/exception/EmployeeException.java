package pl.migibud.employeeservice.employee.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EmployeeException extends RuntimeException{
    private final EmployeeError employeeError;
    private final String message;
}
