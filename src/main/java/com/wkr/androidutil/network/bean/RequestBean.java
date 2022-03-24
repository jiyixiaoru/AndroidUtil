package com.wkr.androidutil.network.bean;

public class RequestBean {
    private String deviceId;
    private String transTicketNo;
    private String startDate;
    private String endDate;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTransTicketNo() {
        return transTicketNo;
    }

    public void setTransTicketNo(String transTicketNo) {
        this.transTicketNo = transTicketNo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "RequestBean{" +
                "deviceId='" + deviceId + '\'' +
                ", transTicketNo='" + transTicketNo + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
