package com.scienjus.smartqq;

import com.scienjus.smartqq.callback.MessageCallback;
import com.scienjus.smartqq.client.SmartQQClient;
import com.scienjus.smartqq.model.*;
import com.scienjus.smartqq.response.component.GroupManage;
import com.scienjus.smartqq.response.component.MessageManage;
import com.scienjus.smartqq.response.content.GroupContent;
import com.scienjus.smartqq.response.domain.MessageRes;
import com.scienjus.smartqq.response.responseManage;

import java.io.IOException;
import java.util.List;

/**
 * @author ScienJus
 * @date 2015/12/18.
 */
public class Application {

    public static void main(String[] args) {
        //创建一个新对象时需要扫描二维码登录，并且传一个处理接收到消息的回调，如果你不需要接收消息，可以传null
        SmartQQClient client = new SmartQQClient(new MessageCallback() {
            @Override
            public void onMessage(Message message) {
                System.out.println(message.getContent());
            }

            @Override
            public void onGroupMessage(GroupMessage message) {
                //TODO 还有对群组的名称记录
                //TODO  增加对群组的管理
                    if(!message.getContent().contains("~")){
                        MessageRes mess = new MessageRes();
                        mess.setGroupid(message.getGroupId());
                        mess.setContent(message.getContent());
                        mess.setUserid(message.getUserId());
//                        System.out.println("onGroupMessage:"+mess.toString());
                        MessageManage.updateQueue("insert",mess);
                    }
            }

            @Override
            public void onDiscussMessage(DiscussMessage message) {
                System.out.println(message.getContent());
            }
        });
        //登录成功后便可以编写你自己的业务逻辑了
//        List<Category> categories = client.getFriendListWithCategory();
//        for (Category category : categories) {
//            System.out.println(category.getName());
//            for (Friend friend : category.getFriends()) {
//                System.out.println("————" + friend.getNickname());
//            }
//        }
        responseManage res = new responseManage();
        //针对对群组的信息录入
        GroupManage groupManage = new GroupManage(client);

        //获取到初见群main
        Long gid = groupManage.getGroupByName(GroupContent.chujian_main);


        List<GroupUser> users = client.getGroupInfo(gid).getUsers();
        MessageManage.setUsers(users);

        //录入群主发送消息的Id
        MessageManage.getGroups().put(GroupContent.chujian_main,gid);


        res.runThread(client);
        System.out.println(client.getGroupInfo(gid).toString());
//        GroupUser groupUser = new GroupUser();
//        groupUser.setUin(704900786);
//
//        client.getQQById(groupUser);
//        System.out.println(groupUser.toString());


        //使用后调用close方法关闭，你也可以使用try-with-resource创建该对象并自动关闭
//        try {
//            client.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
