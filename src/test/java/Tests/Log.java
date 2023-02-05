package Tests;

import java.time.LocalDateTime;

public class Log {
    static Log log;
    StringBuilder logText;
    public Log buildLog(){
        if (log ==null)
            return new Log();
        return this;
    }

    public void append(String log){
        logText.append(String.format("%s-%s", LocalDateTime.now(), log));
    }
}
