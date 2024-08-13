package org.scoula.todo.service;

import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.TodoListDao;
import org.scoula.todo.domain.Todo;

public class TodoService {
    TodoListDao dao = TodoDao.getInstance();

    //메뉴1. 목록 메소드
    public void printTodoList(){
        for(Todo todo: dao.getList()){
            String line = "%2d] %s".formatted(todo.getId(), todo.getTitle());
            System.out.println(line);
        }
        System.out.println();
    }

    //메뉴2. 상세 메소드
    public void detailTodo(){
        int id = Input.getInt("Todo Id: ");
        Todo todo = dao.getTodo(id);

        System.out.println("[Todo 상세보기]-----------------------------");
        System.out.println("ID: " + todo.getId());
        System.out.println("제목: " + todo.getTitle());
        System.out.println("설명: " + todo.getDescription());
        System.out.println("완료여부: " + todo.isDone());
        System.out.println("등록일: " + todo.getRegDate());
        System.out.println("------------------------------------------");
        System.out.println();
    }

    //메뉴3. 추가 메소드
    public void addTodo(){
        System.out.println("[새 Todo 추가]-----------------------------");
        String title = Input.getLine("제목: ");
        String description = Input.getLine("설명: ");
        System.out.println("------------------------------------------");

        Todo todo = Todo.builder()
                .title(title)
                .description(description)
                .done(false)
                .build();
        dao.add(todo);

        System.out.println();
    }

    //메뉴4. 수정 메소드
    public void updateTodo(){
        int id = Input.getInt("수정할 Id: ");
        Todo todo = dao.getTodo(id);

        System.out.println("[Todo 수정하기]-----------------------------");
        System.out.println("ID: " + todo.getId());
        String title = Input.getLine("제목", todo.getTitle());
        String description = Input.getLine("설명", todo.getDescription());
        Boolean done = Input.confirm("완료여부", todo.isDone());
        System.out.println("------------------------------------------");
        System.out.println();

        Todo updateTodo = (Todo)todo.clone();
        updateTodo.setTitle(title);
        updateTodo.setDescription(description);
        updateTodo.setDone(done);

        dao.update(updateTodo);
    }

    //메뉴5. 삭제 메소드
    public void deleteTodo(){
        int id = Input.getInt("삭제할 Todo Id: ");
        dao.delete(id);

        System.out.println();
    }
}
