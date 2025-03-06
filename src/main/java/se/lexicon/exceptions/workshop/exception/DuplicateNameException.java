package se.lexicon.exceptions.workshop.exception;

public class DuplicateNameException extends RuntimeException{
    String name;

    public DuplicateNameException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.getMessage() + name + " already exists in the list";
    }
}
