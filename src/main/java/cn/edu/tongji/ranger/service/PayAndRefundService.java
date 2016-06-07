package cn.edu.tongji.ranger.service;

import cn.edu.tongji.ranger.beans.PayDetails;
import cn.edu.tongji.ranger.utils.ReturnWrapper;

/**
 * Created by LiaoShanhe on 2016/6/7.
 */
public interface PayAndRefundService {

    public ReturnWrapper<String> pay(PayDetails payDetails);

}
