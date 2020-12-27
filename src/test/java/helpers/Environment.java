package helpers;

public class Environment {
    public static final String
        demoqaUrl = System.getProperty("url","https://ruskino.ru/art/groups/actors?page=1"),
        remoteDriverUrl = System.getProperty("remote_driver_url"), //"http://192.168.1.123:4444/wd/hub/"
        videoStorageUrl = System.getProperty("video_storage_url");
    public static boolean
        isRemoteDriver = remoteDriverUrl != null,
        isVideoOn = videoStorageUrl != null;
}

