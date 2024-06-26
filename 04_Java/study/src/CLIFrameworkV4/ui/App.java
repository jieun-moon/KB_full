//package CLIFrameworkV04.ui;
//
//import CLIFrameworkV04.ui.ui.Menu;
//import CLIFrameworkV04.ui.ui.MenuItem;
//import CLIFrameworkV3.domain.command.*;
//
//public class App {
//    Menu menu;
//
//    public App(){
//    }
//
//    public void init(int menuSize) {
//        menu = new Menu(menuSize);
//        createMenu(menu);
//    }
//    //메뉴 클래스가 변경될 일은 없음
//    //기능이 추가될 경우 크기에 맞춰서 add만 하면 됨 => OCP 구현
//    //기능 추가한다고 다른 클래스가 변경되지 않음
//    public void createMenu(Menu menu) {
//        menu.add(0, new MenuItem("학생수", new InitScoresCommand()));
//        menu.add(1, new MenuItem("점수입력", new GetScoresCommand()));
//        menu.add(2, new MenuItem("점수리스트", new PrintScoreCommand()));
//        menu.add(3, new MenuItem("분석", new AnalizeCommand()));
//        menu.add(4, new MenuItem("종료", new ExitCommand()));
//    }
//    public void run() {
//        init(5);
//        while (true) {
//            menu.printMenu();
//            Command command = menu.getSelect();
//            command.execute();
//        }
//    }
//    public static void main(String[] args) {
//        App app = new App();
//        app.run();
//    }
//
//}
