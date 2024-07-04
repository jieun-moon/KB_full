package org.scoula.lib.cli.ui;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.App;
import org.scoula.todo.command.*;
import org.scoula.lib.cli.ui.MenuItem;

public abstract class App {
    public void run(){
        init();

        while(true){
            try{
                menu.printMenu();
                Command command = menu.getSelect();
                command.execute();
            } catch(Exception e){
                e.printStackTrace();
                //System.out.println("에러: " + e.getMessage());
            }
        }
    }

}


