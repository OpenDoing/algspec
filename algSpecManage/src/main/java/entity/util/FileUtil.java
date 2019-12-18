package entity.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * 文件工具类
 *
 * @author Duyining
 * @date 2019/12/7
 */
@Slf4j
public class FileUtil {

    /**
     * 读取文件内容到String里
     *
     * @param filePath 文件路径
     * @return 读取到的文件内容
     * @throws IOException IO异常
     */
    public static String read(String filePath) throws IOException {
        File file = new File(filePath);//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
        }
        bReader.close();
        String str = sb.toString();
        return str;
    }

    /**
     * 讲结果写入文件
     *
     * @param fileName 文件名
     * @param str      写入内容
     * @throws IOException 异常
     */
    public static void write(String fileName, String str) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\毕设\\result\\" + fileName));
        out.write(str);
        out.close();
    }
}
