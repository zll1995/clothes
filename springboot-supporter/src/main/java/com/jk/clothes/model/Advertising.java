package com.jk.clothes.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

public class Advertising implements Serializable {

    private static final long serialVersionUID = 7256270355868793045L;
    private Integer id;
    private String advName;
    private String advImg;
    private String advHref;
    private Integer statuss;
    private String startTime;
    private Integer  minutes;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdvName() {
        return advName;
    }

    public void setAdvName(String advName) {
        this.advName = advName;
    }

    public String getAdvImg() {
        return advImg;
    }

    public void setAdvImg(String advImg) {
        this.advImg = advImg;
    }

    public String getAdvHref() {
        return advHref;
    }

    public void setAdvHref(String advHref) {
        this.advHref = advHref;
    }

    public Integer getStatuss() {
        return statuss;
    }

    public void setStatuss(Integer statuss) {
        this.statuss = statuss;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }
}
