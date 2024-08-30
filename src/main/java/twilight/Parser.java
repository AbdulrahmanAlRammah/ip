package twilight;

import java.io.IOException;
import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;

/**
 * Represents a class used for transforming user input to a command to be carried out by chatbot.
 */
public class Parser {
    private static final String[] COMMANDS = new String[]{"list", "mark", "unmark", "todo", "event", "deadline", "delete", "bye"};
    public Parser(){}

    /**
     * Parses the string input and returns a command to be executed.
     *
     * @param input The message from user.
     * @return Command according to user desire.
     * @throws InvalidInputException When the message from user is an invalid statement.
     */
    public static Command parse(String input) throws InvalidInputException {
        try {
            String[] split = input.split(" ", 2);
            String command = split[0];
            String details = split[1];
            int i = 0;
            while (!COMMANDS[i].equals(command)) {
                i++;
            }
            if (i == 0) {
                return new ListCommand();
            } else if (i < 3) {
                return new MarkingCommand(i, details);
            } else if (i <= 5) {
                return new AddCommand(i, details);
            } else {
                return new DeleteCommand(details);
            }
        } catch (IndexOutOfBoundsException e) {
            if (input.equals("list")) {
                return new ListCommand();
            } else if (input.equals("bye")) {
                return new ExitCommand();
            } else {
                throw new InvalidInputException("Not a valid input!");
            }
        }
    }
}


