package ShowTime.com.zsgs.showtime;

public abstract class BaseScreen {

    public void showAlertMessage(String message) {
        System.out.println("Alert: " + message);
    }

    public void showInfoMessage(String message) {
        System.out.println("Info: " + message);
    }
}
