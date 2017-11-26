package com.example.mohamed.merinal;

/**
 * Created by Mohamed on 11/26/2017.
 */

public class Content {
    int imageRes;
    String medName;
    String addInfo;

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public Content(int imageRes, String medName, String addInfo) {
        this.imageRes = imageRes;
        this.medName = medName;
        this.addInfo = addInfo;
    }
}
