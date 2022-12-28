package pl.migibud.employeeservice.employee.exception;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
class ErrorInfo {
    private final LocalDateTime localDateTime;
    private final HttpStatus status;
    private final String message;
}
