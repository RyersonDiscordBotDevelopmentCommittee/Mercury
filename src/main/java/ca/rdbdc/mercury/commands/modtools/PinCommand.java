/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.rdbdc.mercury.commands.modtools;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

/**
 *
 * @author Liam Gregory
 */
public class PinCommand extends Command {

    public PinCommand() {
        this.name = "setpin";
        this.aliases = new String[]{"spc"};
        this.help = "Set the number of reactions for pinning";
    }

    @Override
    protected void execute(CommandEvent ce) {
        
        
        
    }
    
    

}
