package commandService;

import java.io.Serializable;

public record RequestMessage(CommandInfo commandInfo) implements Serializable {
}