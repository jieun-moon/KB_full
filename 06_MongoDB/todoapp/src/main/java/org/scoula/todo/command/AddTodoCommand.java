package org.scoula.todo.command;

public class AddTodoCommand implements Command{
    @Override
    public void execute(){
        System.out.println("Todo 추가");
    }
}
