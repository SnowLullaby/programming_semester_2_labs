package commands;

import lombok.Getter;

@Getter
public class CommandDescription {
    private final String commandName;
    private final String commandDesc;
    private final Class<?> commandClass;

    CommandDescription (String name, String desc, Class<?> clss){
        this.commandName = name;
        this.commandDesc = desc;
        this.commandClass = clss;
    }

}
