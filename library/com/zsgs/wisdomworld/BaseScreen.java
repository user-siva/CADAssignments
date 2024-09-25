package com.zsgs.wisdomworld;

public abstract class BaseScreen {
    protected boolean hasNetworkConnection() {
        return checkConnection();
    }

    private boolean checkConnection() {
        return true;
    }

    protected void showAlertMessage(String msg) {
        System.out.println(msg);
    }

}
