package com.scienjus.smartqq.response.running;

import com.scienjus.smartqq.client.SmartQQClient;
import com.scienjus.smartqq.response.action.chujianAction;
import com.scienjus.smartqq.response.component.GroupManage;
import com.scienjus.smartqq.response.component.MessageManage;
import com.scienjus.smartqq.response.content.ContentMode;
import com.scienjus.smartqq.response.content.GroupContent;
import com.scienjus.smartqq.response.content.ResContent;
import com.scienjus.smartqq.response.domain.MessageRes;

import java.util.Date;
import java.util.Map;

public class resThread implements Runnable {
    private SmartQQClient client;

    public SmartQQClient getClient() {
        return client;
    }

    public void setClient(SmartQQClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            chujianAction aciton = new chujianAction();
            MessageRes mess= null;
            if (MessageManage.getQueueSize() != 0) {
                mess= MessageManage.updateQueue("poll", null);
                Map<String,Long> maps = MessageManage.getGroups();
                for(Map.Entry<String,Long> map : maps.entrySet()){
                    if(map.getKey()==GroupContent.chujian_main){
                        Long gid = map.getValue();
                        if (gid!= null) {
                            if (gid.longValue()==mess.getGroupid().longValue()) {
                                if (mess.getContent()!=null) {
                                    //时间间隔检验
                                    if(MessageManage.getMessMap().get(gid.longValue())==null){
                                        MessageManage.getMessMap().put(gid.longValue(),new Date());
                                        //回复的策略
                                        aciton.reqChujian(mess,client);
                                    }else {
                                        if(new Date().getTime()-MessageManage.getMessMap().get(gid.longValue()).getTime() >= ContentMode.ever_mess_time*1000){
                                            MessageManage.getMessMap().put(gid.longValue(),new Date());
                                            //回复的策略
                                            aciton.reqChujian(mess,client);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

//        for(Group group : listGroup){
//            System.out.println(group.toString());
//            if("初见ヾ村雨撒娇冠".equals(group.getName())){
//                client.sendMessageToGroup(group.getId(),"无感是个大傻子，奶猫最可爱，最帅");
//            }
//      }
        }


    }
}
