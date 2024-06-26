//package CLIFrameworkV05;
////동작의 메서드를 부모가 결정
////template 패턴
////자식 클래스는 커스트마이징을 통해 수정 운영 가능
//
//import cli.command.Command;
//
//import java.awt.*;
//
//public abstract class App {
//    Menu menu;
//
//    public App() { }
//    public void init(int menuSize) {
//        menu = new Menu(menuSize);
//        createMenu(menu);
//    }
//
//    //createMenu가 중요
//    //아무것도 안함
//    //부모는 형태만 잡아줄 뿐
//    //아무일도 안하기 때문에 아래를 abstract로 해도 상관 없음
//    //자식이 커스트마이징
//    public void createMenu(Menu menu) {
//    }
//
//    public void run() {
//        //init(5); 제거
//        while (true) {
//            menu.printMenu();
//            Command command = menu.getSelect();
//            command.execute();
//        }
//    }
//}
