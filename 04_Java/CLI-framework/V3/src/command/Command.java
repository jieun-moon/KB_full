package command;

public interface Command {
    //추상 메소드이므로 자식에서 재정의 필요
    void execute();
}
