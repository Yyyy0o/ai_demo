package org.example.ai_demo;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhou yao
 * @date 2025/6/12
 * @desc
 **/
@Configuration
public class Config {

    @Bean
    public ChatModel dashScopeChatModel() {
        return DashScopeChatModel.builder()
                .dashScopeApi(DashScopeApi.builder()
                       .apiKey(System.getenv("AI_DASHSCOPE_API_KEY"))
                       .build())
                .build();
    }

    @Bean
    public ChatClient chatClient(ChatModel chatModel, ToolCallbackProvider toolCallbackProvider) {
        return ChatClient.builder(chatModel)
                .defaultToolCallbacks(toolCallbackProvider)
                .build();
    }

    @Bean
    public ToolCallbackProvider toolCallbackProvider() {
        return new ToolCallbackProvider();
    }


}
