package gangz.purchase.api.data;

public class StatusNotAllowedException extends Exception {
    public StatusNotAllowedException(){
        super("status not allowed");
    }
}
