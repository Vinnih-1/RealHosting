package project.kazumy.realhosting.discord.configuration.embed;

import com.henryfabio.minecraft.configinjector.common.annotations.ConfigField;
import com.henryfabio.minecraft.configinjector.common.annotations.ConfigFile;
import com.henryfabio.minecraft.configinjector.common.annotations.ConfigSection;
import com.henryfabio.minecraft.configinjector.common.injector.ConfigurationInjectable;
import lombok.Getter;
import lombok.val;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.simpleyaml.configuration.ConfigurationSection;

import java.awt.*;
import java.util.function.Function;

@ConfigSection("embed.payment")
@ConfigFile("embed.yml")
public class PaymentEmbedValue implements ConfigurationInjectable {

    @Getter private static final PaymentEmbedValue instance = new PaymentEmbedValue();

    @ConfigField("title") private String title;
    @ConfigField("footer") private String footer;
    @ConfigField("description") private String description;
    @ConfigField("thumbnail") private String thumbnail;
    @ConfigField("site") private String site;
    @ConfigField("fields.1") private ConfigurationSection field1;
    @ConfigField("fields.2") private ConfigurationSection field2;

    public MessageEmbed toEmbed() {
        val embed = new EmbedBuilder();
        embed.setColor(Color.GRAY);
        embed.setTitle(title);
        embed.setFooter(footer);
        embed.setDescription(description);
        embed.addField(field1.getString("name"), field1.getString("value"), field1.getBoolean("inline"));
        embed.addField(field2.getString("name"), field2.getString("value"), field2.getBoolean("inline"));

        return embed.build();
    }

    public <T> T get(Function<PaymentEmbedValue, T> function) {
        return function.apply(instance);
    }
}
