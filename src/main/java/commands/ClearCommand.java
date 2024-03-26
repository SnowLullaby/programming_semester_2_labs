package commands;

import models.PersonsCollection;

public class ClearCommand implements Command{
    public void execute() {
        PersonsCollection.getInstance().removeAll();
        System.out.println("Collection clearing is finished");
    }
}
