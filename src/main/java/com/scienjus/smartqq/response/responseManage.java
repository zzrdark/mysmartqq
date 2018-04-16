package com.scienjus.smartqq.response;

import com.scienjus.smartqq.client.SmartQQClient;
import com.scienjus.smartqq.response.component.MessageManage;
import com.scienjus.smartqq.response.content.ContentMode;
import com.scienjus.smartqq.response.content.ResContent;
import com.scienjus.smartqq.response.running.resThread;

import java.util.List;
import java.util.Map;

public class responseManage {
    //需要一个对消息多一些处理的，我们需要进行缓存10分钟读取过的消息list

    //读取该群的人员名单 map<Long,list>
    //Map<Long,List<String>> mapfriend;

    //增加一个 resContent策略库  目前我们以一个class形式去保存
    //增加一个ContentMode 主要用来控制 回复策略的总开关




    public  void runThread(SmartQQClient client){
        resThread r1 = new resThread();
        r1.setClient(client);
        Thread t1 = new Thread(r1);
        t1.start();
    }


}
