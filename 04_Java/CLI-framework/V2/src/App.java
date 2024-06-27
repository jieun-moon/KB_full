public class App {
    int studentNum = 0;
    int[] scores = null;

    Menu menu;

    public App(){
        menu = new Menu();
    }
    private void analize(){
        int max = 0;
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < scores.length; i++) {
            max = (max<scores[i]) ? scores[i]:max;
            sum += scores[i];
        }
        avg = (double)sum/studentNum;
        System.out.println("최고 점수: " + max);
        System.out.println("평균 점수: " + avg);
    }

    //getStudentNum: 1번 메뉴인 학생 수 입력 기능 처리하는 메소드
    public void getStudentNum(){
        System.out.print("학생수> ");
        studentNum = Integer.parseInt(scanner.nextLine());
        scores = new int[studentNum];
    }

    public void getScores() {
        for (int i = 0; i < scores.length; i++) {
            System.out.print("scores[" + i + "]> ");
            scores[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    public void printScore(){
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "]: " + scores[i]);
        }
    }

    //exit: 5번 메뉴인 종료 기능 처리하는 메소드
    public void exit(){
        run=false;
    }

    //executeCommand: 만들어둔 메소드들을 사용자의 입력값에 따라 호출
    public void executeCommand(int selectNo){
        if(selectNo==1){
            getStudentNum();
        } else if (selectNo == 2 ) {
            getScores();
        } else if (selectNo == 3 ) {
            printScore();
        } else if(selectNo == 4 ) {
            analize();
        } else if (selectNo == 5 ) {
            exit();
        }
    }
    public void run(){
        while(true){
            menu.printMenu();
            int selectNo = menu.getSelect();
            executeCommand(selectNo);
        }
    }
}
