package com.bridgelabz.assignment.Exception;

import com.bridgelabz.assignment.DTO.ProjectResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class ProjectExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProjectResponseDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO("Exception while performing api", errMsg);
        return new ResponseEntity<>(projectResponseDTO, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CostumException.class)
    public ResponseEntity<ProjectResponseDTO> handleCudtomException(CostumException exception) {
        ProjectResponseDTO projectResponseDTO = new ProjectResponseDTO("Exception While perform api", exception.getMessage());
        return new ResponseEntity<>(projectResponseDTO, HttpStatus.BAD_REQUEST);
    }
}