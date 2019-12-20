package com.monicseq.run.strategy.info;

import java.util.List;

/**
 * 服务状态信息
 *
 * @author Duyining
 * @date 2019/12/20
 */
public class StateInfo {
    /**
     * 吞吐量，在单位时间内客户端和服务器成功传送数据的数量
     */
    private double throughput;
    /**
     * 服务已经重发的次数
     */
    private int alrtimes;
    /**
     * 服务响应时间,保存的最近几次的请求数据
     */
    private List<Long> resTime;
    /**
     * 服务的拒绝访问率
     */
    private double reject;

    public StateInfo() {
        this.alrtimes = 0;
        this.reject = 0;
    }

    public double getThroughput() {
        return throughput;
    }

    public void setThroughput(double throughput) {
        this.throughput = throughput;
    }

    public int getAlrtimes() {
        return alrtimes;
    }

    public void setAlrtimes(int alrtimes) {
        this.alrtimes = alrtimes;
    }

    public List<Long> getResTime() {
        return resTime;
    }

    public void setResTime(List<Long> resTime) {
        this.resTime = resTime;
    }

    public double getReject() {
        return reject;
    }

    public void setReject(double reject) {
        this.reject = reject;
    }
}
