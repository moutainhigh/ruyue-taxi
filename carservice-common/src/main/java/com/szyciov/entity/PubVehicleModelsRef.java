package com.szyciov.entity;

import java.util.Date;

public class PubVehicleModelsRef {
    /**
    主键
     */
    private String id;

    /**
    所属租赁,数据归属
     */
    private String companyid;

    /**
    租赁公司
     */
    private String leasecompanyid;

    /**
    车辆id
     */
    private String vehicleid;

    /**
    车型id
     */
    private String vehiclemodelsid;

    /**
    创建时间
     */
    private Date createtime;

    /**
    更新时间
     */
    private Date updatetime;

    /**
    创建人
     */
    private String creater;

    /**
    更新人
     */
    private String updater;

    /**
    数据状态
     */
    private Integer status;

    /**
     * get 主键
     */
    public String getId() {
        return id;
    }

    /**
     *
     * set 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * get 所属租赁,数据归属
     */
    public String getCompanyid() {
        return companyid;
    }

    /**
     *
     * set 所属租赁,数据归属
     */
    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }

    /**
     * get 租赁公司
     */
    public String getLeasecompanyid() {
        return leasecompanyid;
    }

    /**
     *
     * set 租赁公司
     */
    public void setLeasecompanyid(String leasecompanyid) {
        this.leasecompanyid = leasecompanyid == null ? null : leasecompanyid.trim();
    }

    /**
     * get 车辆id
     */
    public String getVehicleid() {
        return vehicleid;
    }

    /**
     *
     * set 车辆id
     */
    public void setVehicleid(String vehicleid) {
        this.vehicleid = vehicleid == null ? null : vehicleid.trim();
    }

    /**
     * get 车型id
     */
    public String getVehiclemodelsid() {
        return vehiclemodelsid;
    }

    /**
     *
     * set 车型id
     */
    public void setVehiclemodelsid(String vehiclemodelsid) {
        this.vehiclemodelsid = vehiclemodelsid == null ? null : vehiclemodelsid.trim();
    }

    /**
     * get 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     *
     * set 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * get 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     *
     * set 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * get 创建人
     */
    public String getCreater() {
        return creater;
    }

    /**
     *
     * set 创建人
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * get 更新人
     */
    public String getUpdater() {
        return updater;
    }

    /**
     *
     * set 更新人
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * get 数据状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * set 数据状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}