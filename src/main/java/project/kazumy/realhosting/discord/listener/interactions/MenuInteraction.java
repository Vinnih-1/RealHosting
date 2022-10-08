package project.kazumy.realhosting.discord.listener.interactions;

import lombok.val;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import project.kazumy.realhosting.discord.InitBot;
import project.kazumy.realhosting.discord.listener.InteractionService;
import project.kazumy.realhosting.discord.services.ticket.Ticket;

public class MenuInteraction extends InteractionService<SelectMenuInteractionEvent> {

    public MenuInteraction() {
        super("menu-ticket");
    }

    @Override
    public void execute(SelectMenuInteractionEvent event) {
        InitBot.ticketManager.openTicket(
                Ticket.builder()
                        .author(event.getMember())
                        .category(event.getSelectedOptions().get(0).getValue())
                        .id("test")
                        .build()
        );
    }

    @Override
    public void register(InteractionService<SelectMenuInteractionEvent> instance) {

    }
}
