package org.scoula.todo.command;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.dao.TodoDao;

//메뉴5. 삭제 Command 클래스
public class DeleteTodoCommand implements Command {
    TodoDao dao = TodoDao.getInstance();

    @Override
    public void execute(){
        //사용자에게 삭제할 todo의 아이디 입력 받기
        int id = Input.getInt("삭제할 Todo Id: ");
        //해당하는 id의 todo를 목록에서 삭제
        dao.delete(id);

        System.out.println();
    }
}
