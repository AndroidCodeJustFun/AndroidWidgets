package com.xiao.demo.retrofit.own.request;

/**
 * 基本请求类
 *
 * @author rh-max
 */
public class BaesRequest {
    /**
     * 请求ID
     */
    private int actId;

    /**
     * 患者id
     */
    private int patientId;

    /**
     * 医生ID
     */
    private int doctorId;

    /**
     * 用户类型
     */
    private int userType;

    private String clientsn;

    public BaesRequest() {
        setClientsn("patient");
        setDoctorId(0);
    }

    public int getActId() {
        return actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getClientsn() {
        return clientsn;
    }

    public void setClientsn(String clientsn) {
        this.clientsn = clientsn;
    }

    @Override
    public String toString() {
        return "BaesRequest [actId=" + actId + ", patientId=" + patientId
                + ", userType=" + userType + "]";
    }

}
