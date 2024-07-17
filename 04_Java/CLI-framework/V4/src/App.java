import command.Command;
import command.GetScoresCommand;
import command.InitScoresCommand;
import command.PrintScoreCommand;
import src.command.AnalizeCommand;
import src.command.ExitCommand;

import java.awt.*;
import java.util.Scanner;

public class App {
    Menu menu;
    command.Command[] commands;

    public App(){
        //생성자에서 Menu로 객체 생성해서 초기화
        menu = new Menu();
        //Command 패턴
        commands = new Command[]{
                new InitScoresCommand(), //1. 학생수 입력
                new GetScoresCommand(), //2. 점수 입력
                new PrintScoreCommand(), //3. 점수 출력
                new AnalizeCommand(), //4. 분석
                new ExitCommand(), //5. 종료
        };
    }

    //executeCommand: 만들어둔 메소드들을 사용자의 입력값에 따라 호출
    public void executeCommand(int selectNo){
        //인덱스로 접근해야 하기 때문에 사용자가 입력한 번호에서 -1 해줌
        Command command = commands[selectNo-1];
        //가져온 command의 execute가 실행된다.
        command.execute();
    }

    public void run(){
        while(true){
            int selectNo = menu.getSelect();

            if (selectNo == 5 ) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
