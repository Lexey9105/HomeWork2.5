package pro.sky.Employee_Servise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class EmployeeIncorrectDataExeption extends RuntimeException{
    public EmployeeIncorrectDataExeption(){
        super("ведены некорректные данные");
    }
}
