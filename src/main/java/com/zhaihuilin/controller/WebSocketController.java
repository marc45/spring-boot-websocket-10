package com.zhaihuilin.controller;

import com.zhaihuilin.entity.WiselyMessage;
import com.zhaihuilin.entity.WiselyResponse;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * WebSocket 控制器
 * Created by zhaihuilin on 2018/2/8  11:43.
 */
@Controller
@Log4j
public class WebSocketController {


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/welcome") //当浏览器向服务端发送请求时，通过@MessageMapping映射/welcome这个地址，类似于@RequestMapping
    @SendTo("/topic/getResponse")//当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
    public WiselyResponse send(WiselyMessage wiselyMessage) throws  Exception{
        log.info("我进来了！");
        Thread.sleep(3000);//休眠
        return  new WiselyResponse("欢迎," + wiselyMessage.getName()+"!");
    }



    /**
     *
     * 在Spring MVC，可以直接在参数中获得principal，pinciple中包含当前用户的的信息
     * @param principal
     * @param msg
     */
    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        /**
         * 下面是一段硬编码，如果发送人是jack1则发送给jack2，如果发送人是jack2则发送给jack1，
         * 可以根据项目实际需要编写此处代码
         */
        if (principal.getName().equals("jack1")) {

            log.info("我是jack1 我进来了");
            /**
             * 通过 messagingTemplate.convertAndSendToUser向用户发送消息，第一个参数是接收消息的用户，
             * 第二个是浏览器订阅的地址，第三个是消息本身
             */
            simpMessagingTemplate.convertAndSendToUser("jack2",
                    "/queue/notifications",
                    principal.getName() + ":" + msg);
        }else {
            log.info("我是jack2 我进来了");
            simpMessagingTemplate.convertAndSendToUser("jack1",
                    "/queue/notifications",principal.getName()+":"+msg);
        }
    }











}
