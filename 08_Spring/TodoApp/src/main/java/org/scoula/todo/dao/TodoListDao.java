package org.scoula.todo.dao;

import org.scoula.todo.domain.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private static TodoDao instance = new TodoDao();

    public static TodoDao getInstance() {
        return instance;
    }

    private List<Todo> List;

    private TodoDao() {
        list = new ArrayList<>();
        for(int i = 0; i < 10; i++){ //임시 테스트 데이터 구성
            Todo todo = Todo.builder().title("Todo " + i).description("Description " + i).done(false).build();
            List.add(todo);

        }
    }

    public List<Todo> getList() {
        return List;
    }

    public Todo getTodo(int id) {
        for(Todo todo : List){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

    //index 찾아내는 코드 중복
    public void add(Todo todo){
        list.add(todo);
    }

    public void update(Todo todo){
        for(int i = 0; i < List.size(); i++){
            if(todo.getId() == list.get(i).getId()){
                List.set(i, todo);
            }
        }
    }

    public void delete(int id){
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getId()==id){
                list.remove(i);
                return;
            }
        }
    }

}
