package org.scoula.todo.Context;

import lombok.Getter;
import lombok.Setter;
import org.scoula.todo.domain.UserVO;

@Getter
@Setter

public class Context {
    private UserVO user;

    private Context(){}

    private static Context context = new Context();

    public static Context getContext(){
        return context;
    }
}
