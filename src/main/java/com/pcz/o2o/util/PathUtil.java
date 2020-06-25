package com.pcz.o2o.util;

import java.io.File;

/**
 * @author picongzhi
 */
public class PathUtil {
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            // TODO
        } else {
            basePath = "/Users/picongzhi/Pictures/o2o";
        }

        return basePath.replace("/", File.separator);
    }

    public static String getShopImagePath(String shopId) {
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", File.separator);
    }
}
