package pro.sky.Employee_Servise;

public class DeptEmptyException extends RuntimeException {
    public DeptEmptyException(){
        super("В отделе нет сотрудников");
    }
}
