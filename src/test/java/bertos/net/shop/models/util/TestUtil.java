package bertos.net.shop.models.util;

public class TestUtil {

    public static TypeOS getOsType() {

        String osName = System.getProperty("os.name");
        TypeOS typeOS = null;

        if(osName.contains("Mac"))
            typeOS = TypeOS.MAC_OS;
        else if(osName.contains("Windows"))
            typeOS = TypeOS.WINDOWS;

        return typeOS;
    }
}
