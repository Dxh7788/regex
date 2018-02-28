package com.d.spider.entity;

import java.io.Serializable;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by regex
 *
 * @author xh.d
 * @since 2018/2/28 15:43
 */
public class Loan implements Serializable{
    private String id;  //id
    private String number;//编号
    private String name;//名称
    private Double rate;//利率
    private Integer deadline;//期限
    private Double process;//进度
    private Double money;//金额
    private Double rasingMoney;//在筹金额

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public Double getProcess() {
        return process;
    }

    public void setProcess(Double process) {
        this.process = process;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getRasingMoney() {
        return rasingMoney;
    }

    public void setRasingMoney(Double rasingMoney) {
        this.rasingMoney = rasingMoney;
    }
}
