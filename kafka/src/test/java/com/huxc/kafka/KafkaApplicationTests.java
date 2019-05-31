package com.huxc.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaApplicationTests {

    @Test
    public void compare() {
        try {
            String className = "com.adastragrp.hccn.hcpay.sapp.backend.integration.homesis.api.SellerPlaceUpdateInfo";
            String json = "{\n" +
                    "  \"HCPayBusiness\": true,\n" +
                    "  \"RPosBusiness\": true,\n" +
                    "  \"busStop\": \"string\",\n" +
                    "  \"businessAreaSize\": \"string\",\n" +
                    "  \"canReturnGoods\": 0,\n" +
                    "  \"commodity\": \"string\",\n" +
                    "  \"dsmPosPhoto\": \"string\",\n" +
                    "  \"eshopCooperationLetter\": \"string\",\n" +
                    "  \"goodsdeliveryService\": 0,\n" +
                    "  \"gpsLatitude\": 0,\n" +
                    "  \"gpsLongitude\": 0,\n" +
                    "  \"insidePosPhoto\": \"string\",\n" +
                    "  \"landmarkLocation\": \"string\",\n" +
                    "  \"managerEmail\": \"string\",\n" +
                    "  \"managerID\": \"string\",\n" +
                    "  \"managerIDScanBack\": \"string\",\n" +
                    "  \"managerIDScanFront\": \"string\",\n" +
                    "  \"managerMobileNumber\": \"string\",\n" +
                    "  \"managerName\": \"string\",\n" +
                    "  \"openingHours\": \"string\",\n" +
                    "  \"otherRequiredDocument\": \"string\",\n" +
                    "  \"outsidePosPhoto\": \"string\",\n" +
                    "  \"posBusinessLicence\": \"string\",\n" +
                    "  \"processId\": \"string\",\n" +
                    "  \"retailerAppLetter\": \"string\",\n" +
                    "  \"sellerplaceCode\": \"string\",\n" +
                    "  \"source\": \"SAPP\",\n" +
                    "  \"standardBusiness\": true,\n" +
                    "  \"subsidyConfirmationLetter\": \"string\",\n" +
                    "  \"userEmployeeCode\": \"string\"\n" +
                    "}";

            JSONObject object = new JSONObject(json);
            Iterator<String> keys = object.keys();
            List<String> homeSisFieldNameList = new ArrayList<>();
            while (keys.hasNext()) {
                String next = keys.next();
                homeSisFieldNameList.add(next);
            }

            Class<?> aClass = Class.forName(className);
            Field[] declaredFields = aClass.getDeclaredFields();
            List<String> localFiledNameList = Arrays.stream(declaredFields).map(f -> {
                JsonProperty annotation = f.getAnnotation(JsonProperty.class);
                if (annotation != null) {
                    String value = annotation.value();
                    return value;
                } else {
                    return f.getName();
                }
            }).collect(Collectors.toList());

            System.out.println("homeSis不包含:");
            localFiledNameList.forEach(l -> {
                if (!homeSisFieldNameList.contains(l)) {
                    System.out.println(l);
                }
            });

            System.out.println("本地代码不好含:");
            homeSisFieldNameList.forEach(h -> {
                if (!localFiledNameList.contains(h)) {
                    System.out.println(h);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
