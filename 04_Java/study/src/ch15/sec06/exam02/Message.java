package ch15.sec06.exam02;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class Message {
    public String command;
    public String to;

//    public Message(String command, String to) {
//        this.command = command;
//        this.to = to;
//    }
}