package org.scoula.ex05.domain;
//domain은 VO객체
//VO객체: DAO. 필요하면 DTO간 변환하는 객체 마련해야함
//DTO: Controller, service

public class Member {
    private String name;
    private String userid;

    public Member() {
    }

    public Member(String name, String userid) {
        this.name = name;
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
