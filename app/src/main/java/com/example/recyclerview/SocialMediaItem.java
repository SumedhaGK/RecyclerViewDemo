package com.example.recyclerview;

import android.util.Log;

public class SocialMediaItem {

    private int platformLogo;
    private String platformName;
    private String platformMAU;
    private String platformDetails;
    private String[] details;
    private final String tag = "Logging Message";
    private PlatformDetailsHolder platformDet = new PlatformDetailsHolder();

    public SocialMediaItem(String platformName) {
        this.platformName = platformName;
        details = platformDet.getPlatformDetails(platformName);
        this.platformLogo = Integer.parseInt(details[3]);
        this.platformMAU = details[1];
        this.platformDetails = details[2];
    }

    public int getPlatformLogo() {
        return platformLogo;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getPlatformMAU() {
        return platformMAU;
    }

    public String getPlatformDetails() {
        return platformDetails;
    }
}
