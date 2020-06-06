package edu.njust.hjj.asts.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TermProcUtil {

    /**
     * 获取项列表中的操作列表
     * @param termList
     * @return
     */
    public static List<String> getOptList(List<String> termList) {
        List<String> optList = new ArrayList<String>();
        for(String tempStr:termList){
            if(isOpt(tempStr)) {
                optList.add(new String(tempStr));
            }
        }
        return optList;
    }

    /**
     * 获取项列表中常量和变量列表
     * @param termList
     * @return
     */
    public static List<String> getCvList(List<String> termList) {
        List<String> cvList = new ArrayList<String>();
        for(String tempStr:termList){
            if(!isOpt(tempStr)) {
                cvList.add(new String(tempStr));
            }
        }
        return cvList;
    }

    //判断字符串是否是一个操作
    private static boolean isOpt(String term){
        String regex = "^[a-zA-Z_]+[0-9]*\\(.*\\)$";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(term);
        if(matcher.find()){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 获取操作的参数列表
     * @param opt
     * @return
     */
    public static List<String> getOptArgList(String opt){
        List<String> argList = new ArrayList<String>();
        Stack<Character> s = new Stack<Character>();
        String regex = "^[a-zA-Z_]+[0-9]*\\((.*)\\)$";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(opt);
        if(matcher.find()){
            char[] orgStr = matcher.group(1).toCharArray();
            String tempStr = "";
            for(int i = 0; i < orgStr.length; i++){
                if(s.isEmpty() && orgStr[i] == ','){
                    argList.add(tempStr);
                    tempStr = "";
                }else if (s.isEmpty() && i == orgStr.length-1){
                    tempStr += Character.toString(orgStr[i]);
                    argList.add(tempStr);
                    tempStr = "";
                }else {
                    tempStr += Character.toString(orgStr[i]);
                    if(orgStr[i] == '('){
                        s.push(orgStr[i]);
                    }
                    else if(orgStr[i] == ')'){
                        s.pop();
                    }
                }
            }
            if (s.isEmpty() && tempStr != ""){
                argList.add(tempStr);
            }
        }
        return argList;
    }

    /**
     * 获取操作名
     * @param opt
     * @return
     */
    public static String getOptName(String opt){
        String optName = new String();

        String regex = "^([a-zA-Z_]+[0-9]*)\\((.*)\\)$";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(opt);
        if(matcher.find()){
            optName = matcher.group(1);
        }
        return optName;
    }
}
