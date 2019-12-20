package com.monicseq.run.strategy.info;

/**
 * 控制器的配置信息
 *
 * @author Duyining
 * @date 2019/12/19
 */
public class ConfigInfo {
    /**
     * 服务响应时间上限
     */
    public static long MAXTIME = 5000L;
    /**
     * 保存最近几次的时间数据
     */
    public static int RECENT = 10;

    /**
     * 服务重新发送的上限次数
     */
    public static int MAXTIMES = 5;
    /**
     * 服务的拒绝访问率
     */
    public static double MAXREJECT = 0.95;


}
