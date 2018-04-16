package com.scienjus.smartqq.response.action;

import com.scienjus.smartqq.client.SmartQQClient;
import com.scienjus.smartqq.response.content.ResContent;
import com.scienjus.smartqq.response.domain.MessageRes;

public class chujianAction {

    public void reqChujian(MessageRes mess , SmartQQClient client){

        System.out.println(mess.toString());
        if (mess.getContent().contains(ResContent.maopao)) {
            System.out.println(mess.toString());
            client.sendMessageToGroup(Long.valueOf(mess.getGroupid()), "戳泡");
        } else if (mess.getContent().contains(ResContent.req_wanan_s[0]) ||
                mess.getContent().contains(ResContent.req_wanan_s[1]) ||
                mess.getContent().equals(ResContent.req_wanan_s[2])) {
            System.out.println(mess.toString());
            client.sendMessageToGroup(Long.valueOf(mess.getGroupid()), ResContent.res_wanan);
        } else if (mess.getContent().contains(ResContent.req_wuan)) {
            System.out.println(mess.toString());
            client.sendMessageToGroup(Long.valueOf(mess.getGroupid()), ResContent.res_wuan);
        } else if (mess.getContent().contains(ResContent.req_qiandao)) {
            System.out.println(mess.toString());
            client.sendMessageToGroup(Long.valueOf(mess.getGroupid()), ResContent.res_qiandao);
        } else if (mess.getContent().contains(ResContent.req_shuile)) {
            System.out.println(mess.toString());
            client.sendMessageToGroup(Long.valueOf(mess.getGroupid()), ResContent.res_shuile);
        } else if (mess.getContent().contains(ResContent.req_baji)) {
            System.out.println(mess.toString());
            client.sendMessageToGroup(Long.valueOf(mess.getGroupid()), ResContent.res_baji);
        } else if (mess.getContent().contains(ResContent.req_qinqin)) {
            System.out.println(mess.toString());
            client.sendMessageToGroup(Long.valueOf(mess.getGroupid()), ResContent.res_qinqin);
        } else if (mess.getContent().contains(ResContent.req_qiqi[0]) && mess.getContent().contains(ResContent.req_qiqi[1])) {
            System.out.println(mess.toString());
            client.sendMessageToGroup(Long.valueOf(mess.getGroupid()), ResContent.res_qiqi);
        } else if (mess.getContent().contains(ResContent.req_yuer[0]) && mess.getContent().contains(ResContent.req_yuer[1])) {
            System.out.println(mess.toString());
            client.sendMessageToGroup(Long.valueOf(mess.getGroupid()), ResContent.res_yuer);
        } else if (mess.getContent().contains(ResContent.req_wanshanghao[0]) || mess.getContent().contains(ResContent.req_wanshanghao[1])) {
            System.out.println(mess.toString());
            client.sendMessageToGroup(Long.valueOf(mess.getGroupid()), ResContent.res_wanshanghao);
        } else if (mess.getContent().contains(ResContent.req_zaoshanghao[0]) || mess.getContent().contains(ResContent.req_zaoshanghao[1])) {
            System.out.println(mess.toString());
            client.sendMessageToGroup(Long.valueOf(mess.getGroupid()), ResContent.res_zaoshanghao);
        }
    }
}
