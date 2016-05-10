package cn.edu.tongji.ranger.model;

/**
 * Created by wangdechang on 2016/5/7.
 */
public class ProductsInfo {
    private String name;
    private String brief;
    private String detail;
    private String startloc;
    private String targetloc;
    private int duration;
    private String startdate;
    private double adultprice;
    private double childprice;
    private String tag;
    private String setoffway;
    private String backway;
    private String hotelname;
    private String hoteldesc;
    private String hotelname1;
    private String hoteldesc1;
    private String hotelname2;
    private String hoteldesc2;
    private String hotelname3;
    private String hoteldesc3;
    private String postcode;
    private String receiver;
    private String postphone;
    private String postaddress;

    public ProductsInfo() {
    }

    public ProductsInfo(String name, String brief, String detail, String startloc,
                        String targetloc, int duration, String startdate, double adultprice,
                        double childprice, String tag, String setoffway, String backway,
                        String hotelname, String hoteldesc, String hotelname1, String hoteldesc1,
                        String hotelname2, String hoteldesc2, String hotelname3, String hoteldesc3,
                        String postcode, String receiver, String postphone, String postaddress) {
        this.name = name;
        this.brief = brief;
        this.detail = detail;
        this.startloc = startloc;
        this.targetloc = targetloc;
        this.duration = duration;
        this.startdate = startdate;
        this.adultprice = adultprice;
        this.childprice = childprice;
        this.tag = tag;
        this.setoffway = setoffway;
        this.backway = backway;
        this.hotelname = hotelname;
        this.hoteldesc = hoteldesc;
        this.hotelname1 = hotelname1;
        this.hoteldesc1 = hoteldesc1;
        this.hotelname2 = hotelname2;
        this.hoteldesc2 = hoteldesc2;
        this.hotelname3 = hotelname3;
        this.hoteldesc3 = hoteldesc3;
        this.postcode = postcode;
        this.receiver = receiver;
        this.postphone = postphone;
        this.postaddress = postaddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStartloc() {
        return startloc;
    }

    public void setStartloc(String startloc) {
        this.startloc = startloc;
    }

    public String getTargetloc() {
        return targetloc;
    }

    public void setTargetloc(String targetloc) {
        this.targetloc = targetloc;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public double getAdultprice() {
        return adultprice;
    }

    public void setAdultprice(double adultprice) {
        this.adultprice = adultprice;
    }

    public double getChildprice() {
        return childprice;
    }

    public void setChildprice(double childprice) {
        this.childprice = childprice;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSetoffway() {
        return setoffway;
    }

    public void setSetoffway(String setoffway) {
        this.setoffway = setoffway;
    }

    public String getBackway() {
        return backway;
    }

    public void setBackway(String backway) {
        this.backway = backway;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getHoteldesc() {
        return hoteldesc;
    }

    public void setHoteldesc(String hoteldesc) {
        this.hoteldesc = hoteldesc;
    }

    public String getHotelname1() {
        return hotelname1;
    }

    public void setHotelname1(String hotelname1) {
        this.hotelname1 = hotelname1;
    }

    public String getHoteldesc1() {
        return hoteldesc1;
    }

    public void setHoteldesc1(String hoteldesc1) {
        this.hoteldesc1 = hoteldesc1;
    }

    public String getHotelname2() {
        return hotelname2;
    }

    public void setHotelname2(String hotelname2) {
        this.hotelname2 = hotelname2;
    }

    public String getHoteldesc2() {
        return hoteldesc2;
    }

    public void setHoteldesc2(String hoteldesc2) {
        this.hoteldesc2 = hoteldesc2;
    }

    public String getHotelname3() {
        return hotelname3;
    }

    public void setHotelname3(String hotelname3) {
        this.hotelname3 = hotelname3;
    }

    public String getHoteldesc3() {
        return hoteldesc3;
    }

    public void setHoteldesc3(String hoteldesc3) {
        this.hoteldesc3 = hoteldesc3;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPostphone() {
        return postphone;
    }

    public void setPostphone(String postphone) {
        this.postphone = postphone;
    }

    public String getPostaddress() {
        return postaddress;
    }

    public void setPostaddress(String postaddress) {
        this.postaddress = postaddress;
    }

    @Override
    public String toString() {
        return "ProductsController{" +
                "name='" + name + '\'' +
                ", brief='" + brief + '\'' +
                ", detail='" + detail + '\'' +
                ", startloc='" + startloc + '\'' +
                ", targetloc='" + targetloc + '\'' +
                ", duration=" + duration +
                ", startdate='" + startdate + '\'' +
                ", adultprice=" + adultprice +
                ", childprice=" + childprice +
                ", tag='" + tag + '\'' +
                ", setoffway='" + setoffway + '\'' +
                ", backway='" + backway + '\'' +
                ", hotelname='" + hotelname + '\'' +
                ", hoteldesc='" + hoteldesc + '\'' +
                ", hotelname1='" + hotelname1 + '\'' +
                ", hoteldesc1='" + hoteldesc1 + '\'' +
                ", hotelname2='" + hotelname2 + '\'' +
                ", hoteldesc2='" + hoteldesc2 + '\'' +
                ", hotelname3='" + hotelname3 + '\'' +
                ", hoteldesc3='" + hoteldesc3 + '\'' +
                ", postcode='" + postcode + '\'' +
                ", receiver='" + receiver + '\'' +
                ", postphone='" + postphone + '\'' +
                ", postaddress='" + postaddress + '\'' +
                '}';
    }
}
