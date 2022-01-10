package practice2.chat.service;

import org.springframework.stereotype.Service;
import practice2.chat.mapper.MessageMapper;
import practice2.chat.model.ChatForm;
import practice2.chat.model.ChatMessage;

import java.util.List;


@Service
public class MessageService {
    //in-memory
//    private List<ChatMessage> chatMessages;
//
//    @PostConstruct
//    public void postConstruct() {
//        System.out.println("Creating MessageService bean");
//        this.chatMessages = new ArrayList<>();
//    }
    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        if (chatForm.getMessageType().equals("Say")) {
            newMessage.setMessageText(chatForm.getMessageText());
        }
        else if (chatForm.getMessageType().equals("Shout")) {
            newMessage.setMessageText(chatForm.getMessageText().toUpperCase());
        }
        else if (chatForm.getMessageType().equals("Whisper")) {
            newMessage.setMessageText(chatForm.getMessageText().toLowerCase());
        }
        //using in-memory table
//        this.chatMessages.add(newMessage);
        messageMapper.addMessage(newMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return this.messageMapper.getAllMessages();
    }
}
