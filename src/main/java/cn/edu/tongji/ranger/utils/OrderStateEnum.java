package cn.edu.tongji.ranger.utils;

/**
 * Created by LiaoShanhe on 2016/6/6.
 */
public enum OrderStateEnum {
    待确认(1), 待提交确认单(11), 待回执确认单(12), 待付款(2), 已付定金(3), 已付款(4), 已完成(5), 已评价(6), 已取消(7);

    private int value;

    public int getValue() {
        return value;
    }

    OrderStateEnum(int i) {
        this.value = i;
    }

    public static void main(String[] args) {
        System.out.println(OrderStateEnum.已完成.getValue());
    }
}
