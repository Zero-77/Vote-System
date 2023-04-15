package votesystem.model;

public class ResponseFormat<T> {

    private String return_message;

    private T return_data;

    public ResponseFormat(){};
    public ResponseFormat(String return_message, T return_data) {
        this.return_message = return_message;
        this.return_data = return_data;
    }

    public String getReturn_message() {
        return return_message;
    }

    public void setReturn_message(String return_message) {
        this.return_message = return_message;
    }

    public T getReturn_data() {
        return return_data;
    }

    public void setReturn_data(T return_data) {
        this.return_data = return_data;
    }
}

