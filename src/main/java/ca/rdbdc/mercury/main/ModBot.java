/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.rdbdc.mercury.main;

import com.jagrosh.jdautilities.command.*;
import ca.rdbdc.mercury.commands.modtools.*;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;

public class ModBot {

    public static void main(String[] args) throws LoginException {
        CommandClientBuilder commandClientBuilder = new CommandClientBuilder();

        // our prefix is !!
        commandClientBuilder.setPrefix("!!");
        commandClientBuilder.setOwnerId("");//Needs this and token updated

        // "Type !!help"
        commandClientBuilder.useDefaultGame();

        commandClientBuilder.addCommand(new HelloWorldCommand());
        commandClientBuilder.addCommand(new PinCommand());

        new JDABuilder(AccountType.BOT)
                .setToken("")
                .addEventListener(commandClientBuilder.build())
                .build();
    }

    public static class HelloWorldCommand extends Command {

        public HelloWorldCommand() {
            this.name = "helloworld";
            this.aliases = new String[]{"hw"};
            this.help = "says hello";
        }

        @Override
        protected void execute(CommandEvent commandEvent) {
            commandEvent.reply("Hello World");
        }
    }

}
