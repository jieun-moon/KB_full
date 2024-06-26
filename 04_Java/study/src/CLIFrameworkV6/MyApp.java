//package CLIFrameworkV06;
//
//import CLIFrameworkV3.domain.command.AnalizeCommand;
//import CLIFrameworkV3.domain.command.GetScoresCommand;
//import CLIFrameworkV3.domain.command.InitScoresCommand;
//import CLIFrameworkV3.domain.command.PrintScoreCommand;
//import cli.ui.MenuItem;
//
////framework: 고정된 틀
//public class MyApp extends App{
//    @Override
//    public void createMenu(Menu menu) {
//        super.createMenu(menu);
//        menu.add(new MenuItem("학생수", new InitScoresCommand()));
//        menu.add(new MenuItem("점수입력", new GetScoresCommand()));
//        menu.add(new MenuItem("점수리스트", new PrintScoreCommand()));
//        menu.add(new MenuItem("분석", new AnalizeCommand()));
//    }
//
//    public static void main(String[] args) {
//        App app = new MyApp();
//        app.run();
//    }
//}
