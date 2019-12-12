/*
package com.panda;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

*/
/**
 * 创建一个二维码
 * Title: CreateCode
 * Description:
 *
 * @author gxder
 * @date 2018年9月19日
 * <p>
 * 定义二维码的参数
 *//*

public class CreateCode {
    private static final long serialVersionUID = -1041892182251890527L;
    //二维码颜色
    private static final int BLACK = 0xFF000000;
    //二维码颜色
    private static final int WHITE = 0xFFFFFFFF;

    public  String getCodePath(String str) {
        int width = 300; // 图片的宽度
        int height = 300; // 图片的高度
        String format = "jpg"; // 图片的格式
        */
/**
 * 定义二维码的参数
 *//*

        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 指定字符编码为“utf-8”
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); // 指定二维码的纠错等级为中级
        hints.put(EncodeHintType.MARGIN, 2); // 设置图片的边距
        File outPutImage = new File("/image."+format);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, width, height, hints);
            //本地测试start
        String property = System.getProperty("user.dir");
            new File(property+"/code").mkdirs();
            long time = System.currentTimeMillis();
            String path = property + "/code/"  + "二维码" + time + ".png";
            Path file = new File(path).toPath();// 在磁盘生成二维码图片
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);

            //本地测试end
           //2、获取二维码宽高
         */
/*   int codeWidth = bitMatrix.getWidth();
            int codeHeight = bitMatrix.getHeight();
            //3,图片格式

            //4、将二维码放入缓冲流
            BufferedImage image = new BufferedImage(codeWidth, codeHeight, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < codeWidth; i++) {
                for (int j = 0; j < codeHeight; j++) {
                    //4、循环将二维码内容定入图片
                    image.setRGB(i, j, bitMatrix.get(i, j) ? BLACK : WHITE);
                }
            }
            //如果图片不存在创建图片
            if(!outPutImage.exists())
                outPutImage.createNewFile();
            //5、将二维码写入图片
            ImageIO.write(image, format, outPutImage);
            //文件上传并把数据保存到数据库
            FileInputStream inputStream = new FileInputStream(outPutImage);
            byte[] file_buff = new byte[(int) outPutImage.length()];
            inputStream.read(file_buff);
            long time = new Date().getTime();*//*

 */
/*      String  path = FastDFSUtils.uploadToFastDFS(file_buff, "二维码"+time+"."+format);*//*

           return path;
        } catch (Exception e) {
            System.out.println("程序出错,请联系系统维护人员!");
            e.printStackTrace();
        }
        return null;


    }

    public static void main(String[] args) {
        CreateCode createCode = new CreateCode();
        String nihaoma = createCode.getCodePath("委托单号:210983210938" +
                                                    "仪器编号:318349843142131" +
                                                        "仪器名称:ph酸度计" +
                                                            "检定项目:检测" +
                                                     "导送地点:新店所/18楼201室");
        System.out.println(nihaoma);
    }

}
*/
