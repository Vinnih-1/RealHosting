package project.kazumy.realhosting.discord.listener.interactions.menu;

import lombok.val;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import org.apache.commons.lang.RandomStringUtils;
import project.kazumy.realhosting.configuration.embed.PaymentEmbedValue;
import project.kazumy.realhosting.configuration.menu.PlanMenuValue;
import project.kazumy.realhosting.discord.DiscordMain;
import project.kazumy.realhosting.discord.listener.InteractionService;
import project.kazumy.realhosting.model.panel.ServerType;
import project.kazumy.realhosting.model.panel.StageType;
import project.kazumy.realhosting.model.payment.intent.PaymentIntent;
import project.kazumy.realhosting.model.plan.impl.PlanImpl;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class PurchaseServerMenuInteraction extends InteractionService<StringSelectInteractionEvent> {

    private final DiscordMain discordMain;

    public PurchaseServerMenuInteraction(DiscordMain discordMain) {
        super("purchase-server-menu", discordMain);
        this.discordMain = discordMain;
    }

    @Override
    public void execute(StringSelectInteractionEvent event) {
        val client = discordMain.getClientManager().getClientById(event.getMember().getId());
        val type = event.getSelectedOptions().get(0).getValue().split("\\.")[2].toUpperCase();
        val plan = PlanImpl.builder()
                .id(RandomStringUtils.randomAlphanumeric(15))
                .creation(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))
                .payment(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))
                .expiration(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).plusDays(30L))
                .serverType(ServerType.valueOf(type))
                .stageType(StageType.CHOOSING_SERVER)
                .paymentIntent(PaymentIntent.CREATE_PLAN)
                .prePlan(discordMain.getPlanService().getPrePlanByType("BASIC"))
                .build();

        plan.savePlan(client, success -> {
            event.deferReply().addEmbeds(PaymentEmbedValue.instance().toEmbed(plan))
                    .addActionRow(PlanMenuValue.instance().toMenu("purchase-plan-menu"))
                    .queue();
        });
    }
}
