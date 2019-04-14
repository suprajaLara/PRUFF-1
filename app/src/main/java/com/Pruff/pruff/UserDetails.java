package com.Pruff.pruff;

public class UserDetails {

    String phone,email;
    String profession,high,stream,field;
    String gender,name,mobile,city,tongue,frequent,imei;
    String s1,s2,s3,s4,pass;

    public UserDetails() {
    }

    public UserDetails(String name, String gender, String city, String tongue, String mobile,String frequent,String imei,String profession,String high,String stream,String field,String s1,String s2,String s3,String s4,String phone,String email,String pass) {

        this.name = name;
        this.gender = gender;
        this.city = city;
        this.tongue = tongue;
        this.mobile = mobile;
        this.frequent = frequent;
        this.imei = imei;
        this.profession = profession;
        this.high = high;
        this.stream = stream;
        this.field = field;
        this.phone = phone;
        this.email = email;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.pass = pass;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTongue() {
        return tongue;
    }

    public void setTongue(String tongue) {
        this.tongue = tongue;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFrequent() {
        return frequent;
    }

    public void setFrequent(String frequent) {
        this.frequent = frequent;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) { this.high = high;  }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public String getS3() { return s3; }

    public void setS3(String s3) {
        this.phone = s3;
    }

    public String getS4() {
        return s4;
    }

    public void setS4(String s4) {
        this.s4 = s4;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

