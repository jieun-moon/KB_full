package command;

import basic.Input;
import domain.StudentScores;
//1번 메뉴인 학생수 입력 기능 처리하는 메소드
public class InitScoresCommand implements command.Command {
    StudentScores studentScores = StudentScores.getInstance();

    @Override
    public void execute() {
        //Input은 package가 있어야 찾아짐
        //getInt를 사용해서 사용자한테 학생 수를 입력받음
        int studentNum = Input.getInt("학생수> ");
        //studentNum과 점수 배열의 크기를 할당
        studentScores.setStudentNum(studentNum);
    }
}
