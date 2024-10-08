package twilight;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline to be stored in a task list with a particular description and date.
 */
public class Deadline extends Task {
    protected LocalDate deadline;

    /**
     * Instantiates the deadline with it being incomplete.
     *
     * @param description What the task is.
     * @param deadline When the task is due in the format YYYY-MM-DD.
     */
    public Deadline(String description, String deadline) throws InvalidInputException {
        super(description);
        try {
            this.deadline = LocalDate.parse(deadline);
        } catch (DateTimeException e) {
            throw new InvalidInputException("Invalid date. Date must be in the format:\nYYYY-MM-DD");
        }
    }

    /**
     * Instantiates the deadline.
     *
     * @param isDone Whether the task is complete.
     * @param description What the task is.
     * @param deadline When the task is due in the format YYYY-MM-DD.
     */
    public Deadline(boolean isDone, String description, String deadline, String tag) {
        super(description, isDone, tag);
        this.deadline = LocalDate.parse(deadline);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " by: "
                + this.deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + this.getTagString();
    }

    @Override
    public String toStorageString() {
        if (this.tag.equals("")) {
            return "D," + super.toStorageString() + "," + deadline + "," + EMPTY_TAG;
        }
        return "D," + super.toStorageString() + "," + deadline + "," + this.tag;
    }
}
