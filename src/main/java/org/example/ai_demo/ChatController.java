package org.example.ai_demo;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhou yao
 * @date 2025/6/12
 * @desc
 **/
@RestController
public class ChatController {

    @Resource
    private ChatClient chatClient;

    @RequestMapping("/chat")
    public String chat(@RequestParam("input")String input) {
        return chatClient.prompt().user(input).call().content();
    }


}
