package project.kazumy.realhosting.discord.commands.slash;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import project.kazumy.realhosting.discord.commands.base.BaseSlashCommand;

import java.util.Arrays;

public class RenewPlanCommand extends BaseSlashCommand {

    public RenewPlanCommand() {
        super("renovar", "Renove seu plano para que ele não expire!",
                Arrays.asList(new OptionData(OptionType.STRING, "plano", "Indique qual plano você quer renovar.", true)));
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        /*val typedPlan = event.getOption("plano").getAsString();

        event.getUser().openPrivateChannel().queue(channel -> {
            if (InitBot.paymentManager.hasPlanByPlanId(typedPlan)) {
                val plan = InitBot.paymentManager.getPlanById(typedPlan);
                val planData = plan.getPlanData();

                if (plan.getStageType() == StageType.PENDING_PAYMENT || plan.getStageType() == StageType.CHOOSING_SERVER) {
                    event.deferReply().setEmbeds(new EmbedBuilder()
                                    .setColor(Color.RED)
                                    .setDescription("Você não pode renovar um plano que ainda não está ativo!")
                            .build()).queue();
                    return;
                }
                event.deferReply(true).setContent(":white_check_mark: Estamos realizando todos os procedimentos, aguarde um pouco...").queue();
                event.getChannel().sendTyping().queue();
                val paymentManager = InitBot.paymentManager;
                val logsChat = event.getJDA().getTextChannelById(InitBot.config.getString("bot.guild.logs-chat-id"));
                val qrCodeText = paymentManager.getPaymentQrCode(PaymentIntent.RENEW_PLAN, InitBot.config, plan);
                val qrCodeImage = paymentManager.getPaymentQrCodeImage(qrCodeText, plan);
                logsChat.sendMessage("QRCode PIX: " + event.getUser().getAsTag())
                        .addFiles(FileUpload.fromData(qrCodeImage)).queueAfter(2, TimeUnit.SECONDS, message -> {
                            channel.sendMessage("RealHosting: Cobrança Automática de Serviços Prestados")
                                    .addFiles(FileUpload.fromData(qrCodeImage))
                                    .addEmbeds(new EmbedBuilder()
                                            .setTitle(":white_check_mark: PIX! Basta copiar e colar.")
                                            .setColor(Color.YELLOW)
                                            .setDescription(qrCodeText)
                                            .build()).queue(paymentMessage -> {
                                        InitBot.paymentManager.getPaymentMP().detectRenewPayment(plan.getPlanData().getPlanId(), onSuccess -> {
                                            plan.enablePlan(event.getGuild());
                                            plan.updatePaymentIntent(PaymentIntent.NONE);

                                            if (event.getChannel() == null) return;

                                            if (!InitBot.panelManager.serverExistsByPlanId(plan.getPlanData().getPlanId())) {
                                                channel.sendMessageEmbeds(new EmbedBuilder()
                                                        .setColor(Color.RED)
                                                        .setDescription(String.format("Não foi possível encontrar o servidor do plano %s para renovação! Por favor, abra um ticket.",
                                                                plan.getPlanData().getPlanId()))
                                                        .build()).queue();
                                                return;
                                            }
                                            val server = InitBot.panelManager.getServerByPlanId(plan.getPlanData().getPlanId());
                                            server.getController().unsuspend().executeAsync(success -> {
                                                channel.sendMessageEmbeds(new EmbedBuilder()
                                                        .setColor(Color.GREEN)
                                                        .setDescription("Detectamos seu pagamento! Seu plano foi renovado por mais 1 mês.")
                                                        .build()).queue();
                                            });
                                        });
                                    }, failure -> {
                                        event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                                                        .setColor(Color.RED)
                                                        .setDescription(String.format(":x: <@%s>, você precisa estar com o DM aberto para renovar o seu plano!", event.getMember().getId()))
                                                .build()).queue();
                                            });
                        });
                return;
            }
            event.deferReply(true).setContent(":x: Não encontrei nenhum plano com esse identificador!").queue();
        }, failure -> {
            event.deferReply(true).setContent(":x: Você precisa estar com o DM aberto para renovar o seu plano!").queue();
        });*/
    }
}
