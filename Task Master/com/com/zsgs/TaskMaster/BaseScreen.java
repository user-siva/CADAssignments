package com.com.zsgs.TaskMaster;

public class BaseScreen {

    public boolean hasNetworkConnection() {
        return checkConnection();
    }

    private boolean checkConnection() {
        return true;
    }

    public void showAlertMessage(String message) {
        System.out.println("Alert: " + message);
    }

    public void showInfoMessage(String message) {
        System.out.println("Info: " + message);
    }

}
