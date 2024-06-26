//package CLIFrameworkV05;
//
//import CLIFrameworkV3.domain.command.*;
//
//import java.awt.*;
//
//public class MyApp extends App{
//    @Override
//    public void createMenu(Menu menu) {
//        super.createMenu(menu);
//
//        menu.add(0, new MenuItem("학생수", new InitScoresCommand()));
//        menu.add(1, new MenuItem("점수입력", new GetScoresCommand()));
//        menu.add(2, new MenuItem("점수리스트", new PrintScoreCommand()));
//        menu.add(3, new MenuItem("분석", new AnalizeCommand()));
//        menu.add(4, new MenuItem("종료", new ExitCommand()));
//    }
//
//    public static void main(String[] args) {
//        App app = new MyApp();
//
//        //부모쪽에서 운영해야하는데 과정이 추가가 됨
//        //배열을 써서 관리해야하기 때문에
//        //배열에 준하는 관리하는 객체가 있어야 함
//        app.init(5);
//
//        app.run();
//    }
//}
