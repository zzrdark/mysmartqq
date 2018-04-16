package com.scienjus.smartqq.response.component;

import com.scienjus.smartqq.client.SmartQQClient;
import com.scienjus.smartqq.model.Group;

import java.util.List;
import java.util.Map;

public class GroupManage {
    private SmartQQClient client;
    public GroupManage(SmartQQClient client){
        this.client = client;
    }

    public SmartQQClient getClient() {
        return client;
    }

    public void setClient(SmartQQClient client) {
        this.client = client;
    }

    public List<Group> getGroupInfo(){
        return client.getGroupList();
    }


    public Long getGroupByName(String name){
        List<Group> groups =  getGroupInfo();
        for(Group g : groups){
            if(g.getName().equals(name)){
                return g.getId();
            }
        }
        return null;
    }



}
