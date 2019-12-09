package com.rl.mes.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rl.mes.dao.BurnMapper;
import com.rl.mes.dao.LicenseMapper;
import com.rl.mes.pojo.Burn;
import com.rl.mes.util.AES;
import com.rl.mes.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 授权service
 *
 */
@Service
public class LicenseService {

    @Autowired
    private BurnMapper burnMapper;
    @Autowired
    private LicenseMapper licenseMapper;


    /**
     * 授权验证
     *
     * @return
     */
    public void valid() throws Exception {

        String license = licenseMapper.findOne();
        if (StringUtils.isEmpty(license)) {
            throw new Exception("软件尚未授权！");
        }
        //校验授权是否超期
        Burn burn = burnMapper.findLastData();
        Date dataDateTime = new Date();
        if (burn != null) {
            dataDateTime = burn.getTestTime();
        }
        String aesLicense;
        Date licenseDate;
        try {
            aesLicense = AES.decrypt2(license);
            JSONObject licenseObj = JSON.parseObject(aesLicense);
            if ("max".equals(licenseObj.get("licenseDate"))) {
                return;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            licenseDate = formatter.parse(licenseObj.getString("licenseDate"));
        } catch (Exception e) {
            throw new Exception("授权码异常！");
        }

        Boolean valid = licenseDate.getTime() >= System.currentTimeMillis();
        if (!valid) {
            throw new Exception("当前日期[" + DateUtil.formatDate(new Date()) + "]已超过授权日期[" + DateUtil.formatDate(licenseDate) + "]！");
        }
        Boolean valid2 = licenseDate.getTime() >= dataDateTime.getTime();
        if (!valid2) {
            throw new Exception("最大数据日期[" + DateUtil.formatDate(dataDateTime) + "]已超过授权日期[" + DateUtil.formatDate(licenseDate) + "]！");
        }

    }

}
