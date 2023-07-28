package com.bridgelabz.employeepayrollapp.exception;

import com.bridgelabz.employeepayrollapp.DTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class EmployeeExceptionHandler {
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
            List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
            List<String> errMsg = errorList.stream().map(objError -> objError.getDefaultMessage()).collect(Collectors.toList());
            ResponseDTO responseDTO = new ResponseDTO("Exception while performing REST API", errMsg);
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(CostumException.class)
        public ResponseEntity<ResponseDTO> handleCustomEmployeeException(CostumException exception) {
            ResponseDTO responseDTO = new ResponseDTO("Exception while performing REST API", exception.getMessage());
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ResponseDTO> handleDuplicateEmailException(DuplicateEmailException exception) {
        ResponseDTO responseDTO = new ResponseDTO("Exception while performing REST API", exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
