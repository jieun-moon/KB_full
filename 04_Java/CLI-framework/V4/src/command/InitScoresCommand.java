package command;

import basic.Input;
import domain.StudentScores;

public class InitScoresCommand implements Command {
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
