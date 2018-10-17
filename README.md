# Mercury

**Mercury** is a discord bot developed by the **Ryerson Discord Bot Development Committee (RDBDC)** aimed with a focus
of aiding discord server moderators with administrative tasks and duties as well as maintaining order and civility.

# What is Discord?

Discord, while initially developed to be a VoIP application catered to video gaming communities, has opened up to a much
wider audience over the past 18 months. These communities include but are not limited to; hobbies outside of gaming
(competitive programming (e.g. The Coding Den),  hiking (e.g. The Great Outdoors)), academic endeavours (e.g. Ryerson
University Discord), and marginalized communities (e.g. LGBTQ+ Lounge). Discord itself takes a laissez faire approach to
enforcing any sort of platform wide rules, leaving the task to the community moderators/administrators themselves. This
can place a burden on moderators as they are tasked with enforcing community specific rules or guidelines. As these
communities continue to grow, moderators will need tools to help deal with the increased workload in accommodating said
communities.

# Problem being Addressed

Many people create bots to fill some specific utility. Perhaps, they want to provide a particular service on their
server such as screenshot bots. In our case, we're creating a discord bot to maintain order, civility, to ease the
strain of moderators’ need to perform rote tasks, and ultimately to improve user experience. The bot will listen on a
server for new messages and based on the content of those messages, send different messages back.

# Functionality

<li>Remove some messages that break server rules</li>
<li>Send messages to the moderators of the server when something looks like it maybe breaking server rules, but needs human verification</li>
<li>Report messages that have some signals of message rule posts</li>
<li>Enforce channel-locking. In some cases, the mods have decided to lock a channel, and they would have auto-mod removal for all new messages from that channel and have a cooling-off period</li>
<li>Enable moderators to make certain channels visible to users based on different roles assigned to each user in the server</li>
<li>Provide users with an interface in order for them to self-declare certain roles for themselves subject to moderator review and approval</li>
<li>Provide users with appropriate privileges to pin messages to the community channel</li>


# Main Components

<li>**Discord developer API:** (https://discordapp.com/developers/docs/intro)</li>
<li>**JDA:** a discord API wrapper for Java (https://github.com/DV8FromTheWorld/JDA)</li>
<li>**Amazon Web Services:** AWS instance (for hosting the bot, storing server-specific data)</li>


# What is Gradle?

Before we delve into the development of **Mercury** utilizing the JDA wrapper for our discord bot. We're going to start of with building this project with Gradle.

Well, what is Gradle in the first place?

Gradle is an advance build toolkit that manages dependencies and allows defining our custom build logic.

It's build automation tool often used for JVM languages such as Java, Groovy or Scala. Gradle can be configured to run tasks which do things like compile jars, run tests, create documentation and much more.

Let's take a look at the build.gradle file. Of course, we'll be using Java for the project but the same concepts for other languages.

[insert pic]

Gradle build scripts are written in Groovy which is a JVM language similar to Java but with a more concise syntax.

# What is the JDA Wrapper?

JDA strives to provide a clean and full wrapping of the Discord REST api and its Websocket-Events for Java.

# build.gradle file

Main components to add in the **build.gradle** file is the JDA dependency as well as the JDA-Utilities dependency
Click for the latest version of the JDA-Utilities here.


# JDA-Utilities (Detour)

Before we delve into the step-by-step development process for the bot, its important that we actually discuss in detail
the JDA-Utilities library. The JDA-Utilities is an extension library for the Java Discord API library (JDA wrapper) and
the primary objective of this extension library is to provide general utilities, and entities that could not normally
be included in the standard JDA library. This library is divided into two projects: **Commands** and *The Event Waiter**.


# Commands in JDA-Utilities

The internal inheritance for Commands used in JDA-Utilities is that of the Command object. Classes created inheriting
this class gain the unique traits of commands operated using the Commands Extension. Using several fields, a command can
define properties that make it unique and complex while maintaining a low level of development. All Commands extending
this class can define any number of these fields in a object constructor and then create the command action/response in
the abstract execute(CommandEvent event) body.

**Lets jump the Command Client now.**

The **CommandClient** is a suite and framework for easy implementation of various **Commands**. Its standard
implementation is CommandClientImpl and with the provision of certain constants, it is a powerful tool for running
commands.


# Building a CommandClient

A CommandClient is built through the use of the **CommandClientBuilder**.
Under the **psvm** method, we initialized an instance of the **CommandClientBuilder**.

        CommandClientBuilder builder = new CommandClientBuilder();

After instantiation, several constants can be set so that the CommandClient generated will hold useful information that can be used during Command execution.
**NOTE:** the snippet of code is simply an example and not from the Mercury Bot repository.

        // Set the bot's Owner ID
        builder.setOwnerId("12345678910111213");
        // Set the bot's prefix
        builder.setPrefix("!?!");
        // Set the bot's "Playing" status
        builder.setGame(Game.of("Hello World"));
        // Add Commands
        builder.addCommands(new FooCommand(), new BooCommand());
        // And More!

Once everything is set, all we need to do is **build()** the **CommandClient** and add it to **JDABuilder**.

        CommandClient client = builder.build();

        JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT).addEventListener(client);


After that, the rest will be handled by **CommandClient**.


We'll be using the JDA-Utilities CommandClient to handle our command processing. We'll start off by implementing our
**psvm** method throwing a **LoginException** for now.

In our application, what we've done so far is the following:

<li>initialized an instance of CommandClientBuilder</li>
<li>set several constants so that the **CommandClient** that would be generated will hold useful information that can be
used during **Command** execution</li>
<li>once everything is set, we **build()** the **CommandClient** and add it all to the **JDABuilder** as well as taken the
 token into consideration</li>
<li>Create a protected method to take care of replying when said command is executed</li>






