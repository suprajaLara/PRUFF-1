package com.google.pruffap;

public class UserDetails {

    String phone,email;
    String profession,high,stream,field;
    String gender,name,mobile,city,tongue,frequent,imei;
    String android,root,finger,backup,pass;

    public UserDetails() {
    }

    public UserDetails(String name, String gender, String city, String tongue, String mobile,String frequent,String imei,String profession,String high,String stream,String field,String android,String root,String finger,String backup,String phone,String email,String pass) {

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
        this.android = android;
        this.root = root;
        this.finger = finger;
        this.backup = backup;
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

    public String getAndroid() {
        return android;
    }

    public void setAndroid(String android) {
        this.android = android;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getFinger() { return finger; }

    public void setFinger(String finger) {
        this.finger = finger;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}

