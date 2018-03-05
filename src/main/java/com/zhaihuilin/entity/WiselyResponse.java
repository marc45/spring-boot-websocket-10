package com.zhaihuilin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 服务端向浏览器发送的消息
 * Created by zhaihuilin on 2018/2/8  11:41.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WiselyResponse {

    private  String reMessage;
}
