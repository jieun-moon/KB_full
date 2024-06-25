//package CLIFrameworkV3.domain;
//
//import CLIFrameworkV3.domain.command.*;
//
//import java.awt.*;
//
//public class App {
//    Menu menu;
////    실행해야할 명령을 추상화(공통점을 뽑아서 하나로)
//    Command[] commands;
//
//
//    public App(){
//        menu = new Menu();
//        commands = new Command[]{
//                new InitScoresCommand(),
//                new GetScoresCommand(),
//                new PrintScoreCommand(),
//                new AnalizeCommand(),
//                new ExitCommand()
//        };
//    }
//
//    public void executeCommand(int selectNo){
//        Command command = commands[selectNo-1];
//        command.execute();
//    }
//    public void run(){
//        while(true){
//            menu.printMenu();
//            int selectNo = menu.getSelect();
//            executeCommand(selectNo);
//        }
//    }
//    public static void main(String[] args) {
//        App app = new App();
//        app.run();
//    }
//}
