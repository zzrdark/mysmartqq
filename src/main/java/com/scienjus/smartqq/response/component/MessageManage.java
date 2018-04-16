package com.scienjus.smartqq.response.component;

import com.scienjus.smartqq.model.GroupUser;
import com.scienjus.smartqq.response.domain.MessageRes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class  MessageManage {
    private  static  LinkedBlockingQueue<MessageRes> queue = new LinkedBlockingQueue<MessageRes>();
    private static List<GroupUser> users = null;
    private static Map<Long,Date> messMap = new HashMap<Long,Date>();
    private static Map<String,Long> groups = new HashMap<String,Long>();

    public static Map<Long, Date> getMessMap() {
        return messMap;
    }

    public static void setMessMap(Map<Long, Date> messMap) {
        MessageManage.messMap = messMap;
    }

    public static Map<String, Long> getGroups() {
        return groups;
    }

    public static void setGroups(Map<String, Long> groups) {
        MessageManage.groups = groups;
    }

    public static List<GroupUser> getUsers() {
        return users;
    }

    public static void setUsers(List<GroupUser> users) {
        MessageManage.users = users;
    }

    public static synchronized MessageRes updateQueue(String type, MessageRes msg ){
        if("insert".equals(type)){
            queue.add(msg);
            return null;
        }else if("poll".equals(type)){
            return queue.poll();
        }else{
            return null;
        }
    }
    public static synchronized Integer getQueueSize(){
        return queue.size();
    }

}
