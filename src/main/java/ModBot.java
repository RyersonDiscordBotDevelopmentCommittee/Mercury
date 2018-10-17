import javax.security.auth.login.LoginException;

public class ModBot {
    public static void main (String[] args) throws LoginException {
        CommandClientBuilder commandClientBuilder = new CommandClientBuilder();

        // our prefix is !!
        commandClientBuilder.setPrefix("!!");

        // "Type !!help"
        commandClientBuilder.useDefaultGame();

        commandClientBuilder.addCommand(new HelloWorldCommand());

        new JDABuilder(AccountType.BOT)
                .setToken("NDk3OTI4NzQ4MTg4OTU4NzQy.DpmT4w.64eESfpcaVF4GvDoNEtxzpKK0Ec")
                .addEventListener(commandClientBuilder.build())
                .buildAsync();
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
