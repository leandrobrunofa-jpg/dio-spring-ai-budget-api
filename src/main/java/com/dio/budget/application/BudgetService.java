package com.dio.budget.application;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi.TranscriptResponseFormat;
import org.springframework.ai.audio.transcription.TranscriptionPrompt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BudgetService {

    private final OpenAiAudioTranscriptionModel speechModel;
    private final ChatClient chatClient;

    public BudgetService(OpenAiAudioTranscriptionModel speechModel, ChatClient.Builder builder) {
        this.speechModel = speechModel;
        this.chatClient = builder
                .defaultSystem("Você mapeia comandos de voz para transações. Use a ferramenta registerTransaction para salvar.")
                .build();
    }

    public String processAudio(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Arquivo vazio");
        }

        var options = OpenAiAudioTranscriptionOptions.builder()
                .withResponseFormat(TranscriptResponseFormat.TEXT)
                .build();
                
        var prompt = new TranscriptionPrompt(file.getResource(), options);
        String text = speechModel.call(prompt).getResult().getOutput();

        return chatClient.prompt()
                .user(text)
                .functions("registerTransaction")
                .call()
                .content();
    }
}
