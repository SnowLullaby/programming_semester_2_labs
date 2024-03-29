package commands;

import commandService.ExecutionResult;
import commandService.RequestMessage;
import exceptions.NoParamsException;
import models.Country;
import models.PersonsCollection;

public class RemoveAllByNationalityCommand extends RemoveKeyCommand{
    @Override
    public ExecutionResult execute(RequestMessage requestMessage) {
        try {
            if (requestMessage.commandInfo().args() == null)
                throw new NoParamsException();
            PersonsCollection.getInstance().removeByNationality(findCountryByTitle(requestMessage.commandInfo().args().get(0)));
            return new ExecutionResult("Removed", true);
        } catch (IllegalArgumentException | NoParamsException e) {
            return new ExecutionResult(e.getMessage(), false);
        }
    }

    public Country findCountryByTitle(String title) {
        for (Country country : Country.values()) {
            if (country.name().equals(title)) {
                return country;
            }
        }
        return null;
    }
    @Override
    public ExecutionResult showDescription() {
        return new ExecutionResult("remove element with same nationality", true);
    }

    public static ExecutionResult getName() {
        return new ExecutionResult("remove_all_by_nationality", true);
    }
}
