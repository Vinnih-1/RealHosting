package project.kazumy.realhosting.discord.services.panel.exceptions;

public class EmailAlreadyExistsException extends Exception {

    public EmailAlreadyExistsException() {
        super("Este email já está registrado por outra pessoa!");
    }
}
