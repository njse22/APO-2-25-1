package util;

public interface IDefaulth {

    String getMessage();

    default String echo(){
        return "Hola";
    }
}
