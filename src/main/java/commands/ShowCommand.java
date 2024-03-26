package commands;

import models.PersonsCollection;

public class ShowCommand implements Command{
    public void execute() {
        System.out.println("There are " + PersonsCollection.getInstance().getSize() + " elements in collection");
        sorting();
        System.out.print(PersonsCollection.getInstance().toString());
    }

    public void sorting(){
        PersonsCollection.getInstance().defaultSortByID();
    }
}
