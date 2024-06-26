//package CLIFrameworkV06;
//
//import CLIFrameworkV2.Input;
//import cli.ui.MenuItem;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Menu {
//    List<MenuItem> menus;
//
//    public Menu(){
//        menus = new ArrayList<>();
//    }
//
//    public void add(MenuItem item){
//        menus.add(item);
//    }
//
//    public void printMenu(){
//        System.out.println("------------------------------------");
//        //순회할 때 length대신 size로 돎
//        for(int i = 0; i < menus.size(); i++){
//            System.out.println("%d.%s |", i+1, menus.get(i).getTitle());
//        }
//        System.out.println();
//        System.out.println("------------------------------------");
//    }
//
//    //메뉴에서 getSelect할때 사용자를 믿으면 안됨
//    //발생할 수 있는 예외 1.인덱스 잘못 줌, 2.숫자가 아니라 a, 칠 등 숫자가 아닌 글자 입력 하고 엔터칠수도
//    //getInt에서 parseInt 에러발생 가능
//    public Command getSelect(){
//        int selectNo = Input.getInt("선택> ");
//        //올바른 범위 인지 체크
//
//        return menus.get(selectNo-1).getCommand();
//    }
//}
