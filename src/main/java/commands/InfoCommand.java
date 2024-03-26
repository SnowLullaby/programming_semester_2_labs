package commands;

import models.PersonsCollection;

import java.time.ZonedDateTime;

public class InfoCommand implements Command{
    public void execute() {
        String creationTime = PersonsCollection.getInstance().getCreationTime();
        int size = PersonsCollection.getInstance().getSize();
        System.out.printf("Creation time: %s\nSize: %s\n", creationTime, size);
    }
}
