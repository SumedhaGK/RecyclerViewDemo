package com.example.recyclerview;

import android.util.Log;

/*
Class PlatformDetailsHolder holds details of 6 social media platforms. All its member variables are
Private. Hence, getter method is provided. ALl the details are initialised in the constructor
 */
public class PlatformDetailsHolder {
    private final String instagramPlatformName = "Instagram";
    private final String facebookPlatformName = "Facebook";
    private final String whatsAppPlatformName = "WhatsApp";
    private final String youTubePlatformName = "YouTube";
    private final String messangerPlatformName = "Messanger";
    private final String tumblrPlatformName = "Tumblr";
    private String[] platformDetailsArray;
    private final String tag = "Logging Message";

    public String getInstagramPlatformName() {
        return instagramPlatformName;
    }

    public String getFacebookPlatformName() {
        return facebookPlatformName;
    }

    public String getWhatsAppPlatformName() {
        return whatsAppPlatformName;
    }

    public String getYouTubePlatformName() {
        return youTubePlatformName;
    }

    public String getMessangerPlatformName() {
        return messangerPlatformName;
    }

    public String getTumblrPlatformName() {
        return tumblrPlatformName;
    }

    public String[] getPlatformDetails(String platformName){
        platformDetailsArray = new String[4];
        switch (platformName){
            case instagramPlatformName:
                platformDetailsArray[0] = platformName;
                platformDetailsArray[1] = "1 billion MAUs";
                platformDetailsArray[2] = "Instagram is a photo and video sharing social media app. It allows you to share a wide range of content such as photos, videos, Stories, and live videos. It has also recently launched IGTV for longer-form videos.";
                platformDetailsArray[3] = Integer.toString( R.drawable.instagram);
                return platformDetailsArray;
            case facebookPlatformName:
                platformDetailsArray[0] = platformName;
                platformDetailsArray[1] = "2.23 billion MAUs";
                platformDetailsArray[2] = "Facebook is the biggest social media site around, with more than two billion people using it every month. That’s almost a third of the world’s population! There are more than 65 million businesses using Facebook Pages and more than six million advertisers actively promoting their business on Facebook, which makes it a pretty safe bet if you want to have a presence on social media.";
                platformDetailsArray[3] = Integer.toString( R.drawable.facebookfb);
                return platformDetailsArray;
            case youTubePlatformName:
                platformDetailsArray[0] = platformName;
                platformDetailsArray[1] = "1.9 billion MAUs";
                platformDetailsArray[2] = "YouTube is a video-sharing platform where users watch a billion hour of videos every day. To get started, you can create a YouTube channel for your brand where you can upload videos for your subscribers to view, like, comment, and share.";
                platformDetailsArray[3] = Integer.toString( R.drawable.youtube);
                return platformDetailsArray;
            case tumblrPlatformName:
                platformDetailsArray[0] = platformName;
                platformDetailsArray[1] = "642 million MUVs";
                platformDetailsArray[2] = "Tumblr is a microblogging and social networking site for sharing text, photos, links, videos, audios, and more. People share a wide range of things on Tumblr from cat photos to art to fashion.";
                platformDetailsArray[3] = Integer.toString( R.drawable.tumblr);
                return platformDetailsArray;
            case messangerPlatformName:
                platformDetailsArray[0] = platformName;
                platformDetailsArray[1] = "642 million MUVs";
                platformDetailsArray[2] = "Messenger used to be a messaging feature within Facebook, and since 2011, Facebook has made Messenger into a standalone app by itself and greatly expanded on its features";
                platformDetailsArray[3] = Integer.toString( R.drawable.messenger);
                return platformDetailsArray;
            case whatsAppPlatformName:
                platformDetailsArray[0] = platformName;
                platformDetailsArray[1] = "1.5 billion MAUs";
                platformDetailsArray[2] = "WhatsApp is a messaging app used by people in over 180 countries. Initially, WhatsApp was only used by people to communicate with their family and friends";
                platformDetailsArray[3] = Integer.toString( R.drawable.whatsapp);
                return platformDetailsArray;
            default: return null;
        }
    }

}
