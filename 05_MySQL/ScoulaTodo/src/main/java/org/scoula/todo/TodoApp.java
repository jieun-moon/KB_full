package org.scoula.todo;

import org.scoula.lib.cli.App;
import org.scoula.lib.cli.ui.Input;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;
import org.scoula.todo.Context.Context;
import org.scoula.todo.service.AccountService;
import org.scoula.todo.service.LoginService;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public class TodoApp extends App {
    //로그인한 상태의 메뉴
    Menu userMenu;
    //로그아웃한 상태의 메뉴
    Menu annonymousMenu;
    LoginService loginService = new LoginService();
    AccountService accountService = new AccountService();

    @Override
    public void init() {
        //메소드 참조를 통해서 메뉴 생성
        annonymousMenu = new Menu();
        annonymousMenu.add(new MenuItem("로그인", this::login));
        annonymousMenu.add(new MenuItem("가입", accountService::join));
        annonymousMenu.add(new MenuItem("종료", this::exit));

        userMenu = new Menu();
        userMenu.add(new MenuItem("로그아웃", this::logout));
        userMenu.add(new MenuItem("종료", this::exit));

        //처음에는 로그아웃한 상태로 메뉴 보여주기
        setMenu(annonymousMenu);
    }

    private void logout() {
        //사용자가 y와 n을 입력함에 따라 true/false 반환
        if(Input.confirm("로그아웃 할까요?")){
            Context.getContext().setUser(null);
            //사용자가 y를 입력할 시 로그아웃되면서 메뉴 교체
            setMenu(annonymousMenu);
        }
    }

    private void exit() {
    }

    private void login() {
        try{
            loginService.login();
            //로그인 후에는 메뉴 교체
            setMenu(userMenu);
        } catch (SQLException e){
            throw new RuntimeException(e);
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }
    }

    private void join() {
    }

    public static void main(String[] args) {
        //final: 변경이 되지 않는 상수 선언
        final TodoApp app = new TodoApp();
        app.run();
    }
}
