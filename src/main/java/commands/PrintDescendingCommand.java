package commands;

import models.PersonsCollection;

public class PrintDescendingCommand extends ShowCommand{
    @Override
    public void sorting(){
        PersonsCollection.getInstance().descendingSortByID();
    }
}
