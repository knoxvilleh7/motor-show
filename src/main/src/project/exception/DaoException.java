package project.exception;

public class DaoException extends Exception{

    private String error;

    public DaoException(String message) {
        error = message;
    }


    public String getErrs(){
        return error;
    }

}
