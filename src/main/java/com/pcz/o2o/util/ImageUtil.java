package com.pcz.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author picongzhi
 */
public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random RANDOM = new Random();
    private static final String WATERMARK_PATH = basePath + "watermark.png";

    public static String generateThumbnail(InputStream inputStream, String fileName, String targetAddr) {
        String realFileName = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);

        String relativeAddr = targetAddr + realFileName + extension;
        File file = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(inputStream)
                    .size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT,
                            ImageIO.read(new File(WATERMARK_PATH)),
                            0.25f)
                    .outputQuality(0.8f)
                    .toFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return relativeAddr;
    }

    /**
     * 创建目标路径目录
     *
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     *
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名
     *
     * @return
     */
    public static String getRandomFileName() {
        return DATE_FORMAT.format(new Date()) + RANDOM.nextInt(89999) + 10000;
    }

    public static void main(String[] args) throws IOException {
        File thumb = new File(WATERMARK_PATH);
        BufferedImage bufferedImage = ImageIO.read(thumb);
        Thumbnails.of(new File("/Users/picongzhi/workspace/java/idea/o2o/src/main/resources/cat.jpeg"))
                .size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT,
                        bufferedImage,
                        0.8f)
                .outputQuality(0.8f)
                .toFile("/Users/picongzhi/workspace/java/idea/o2o/src/main/resources/cat_thumb.jpeg");
    }

    public static void deleteFileOrPath(String filePath) {
        File fileOrPath = new File(PathUtil.getImgBasePath() + filePath);
        if (!fileOrPath.exists()) {
            return;
        }

        if (fileOrPath.isDirectory()) {
            File[] files = fileOrPath.listFiles();
            for (int i = 0; i < files.length; i++) {
                files[i].delete();
            }
        }
        fileOrPath.delete();
    }
}
