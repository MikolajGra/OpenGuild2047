/**
 * The MIT License
 *
 * Copyright 2014 Grzegorz.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package pl.grzegorz2047.openguild2047.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import pl.grzegorz2047.openguild2047.commands.arguments.AcceptArg;
import pl.grzegorz2047.openguild2047.commands.arguments.CreateArg;
import pl.grzegorz2047.openguild2047.commands.arguments.DescriptionArg;
import pl.grzegorz2047.openguild2047.commands.arguments.DisbandArg;
import pl.grzegorz2047.openguild2047.commands.arguments.HelpArg;
import pl.grzegorz2047.openguild2047.commands.arguments.HomeArg;
import pl.grzegorz2047.openguild2047.commands.arguments.InviteArg;
import pl.grzegorz2047.openguild2047.commands.arguments.KickArg;
import pl.grzegorz2047.openguild2047.commands.arguments.LeaveArg;
import pl.grzegorz2047.openguild2047.commands.arguments.ListArg;
import pl.grzegorz2047.openguild2047.commands.arguments.MembersArg;
import pl.grzegorz2047.openguild2047.commands.arguments.ReloadArg;
import pl.grzegorz2047.openguild2047.commands.arguments.UnbanArg;
import pl.grzegorz2047.openguild2047.commands.arguments.VersionArg;
import pl.grzegorz2047.openguild2047.managers.MsgManager;

public class GuildCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("guild")) {
            if(args.length > 0) {
                if(args.length >= 2) {
                    if(args[0].equalsIgnoreCase("create") || args[0].equalsIgnoreCase("stworz") || args[0].equalsIgnoreCase("zaloz")) {
                        return CreateArg.execute(sender, args);
                    }
                    if(args[0].equalsIgnoreCase("accept") || args[0].equalsIgnoreCase("akceptuj") || args[0].equalsIgnoreCase("dolacz")) {
                        return AcceptArg.execute(sender, args);
                    }
                    else if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("pomoc") || args[0].equalsIgnoreCase("?")) {
                        return HelpArg.execute(sender, args);
                    }
                    if(args[0].equalsIgnoreCase("invite") || args[0].equalsIgnoreCase("zapros")) {
                        return InviteArg.execute(sender, args);
                    }
                    if(args[0].equalsIgnoreCase("kick") || args[0].equalsIgnoreCase("wyrzuc")) {
                        return KickArg.execute(sender, args);
                    }
                    if(args[0].equalsIgnoreCase("unban") || args[0].equalsIgnoreCase("ub")) {
                        return UnbanArg.execute(sender, args);
                    }
                    return true;
                }
                else if(args[0].equalsIgnoreCase("create") || args[0].equalsIgnoreCase("stworz") || args[0].equalsIgnoreCase("zaloz")) {
                    return error(sender, "Podano zbyt malo argumentów");
                }
                else if(args[0].equalsIgnoreCase("accept") || args[0].equalsIgnoreCase("akceptuj")) {
                    return error(sender, "Podano zbyt malo argumentów");
                }
                else if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("pomoc") || args[0].equalsIgnoreCase("?")) {
                    return HelpArg.execute(sender, args);
                }
                else if(args[0].equalsIgnoreCase("reload")) {
                    return ReloadArg.execute(sender);
                }
                else if(args[0].equalsIgnoreCase("ver") || args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("about")) {
                    return VersionArg.execute(sender);
                }
                else if(args[0].equalsIgnoreCase("leave") || args[0].equalsIgnoreCase("opusc") || args[0].equalsIgnoreCase("wyjdz")) {
                    return LeaveArg.execute(sender);
                }
                else if(args[0].equalsIgnoreCase("disband") || args[0].equalsIgnoreCase("rozwiaz") || args[0].equalsIgnoreCase("zamknij")) {
                    return DisbandArg.execute(sender);
                }
                else if(args[0].equalsIgnoreCase("dom") || args[0].equalsIgnoreCase("home")) {
                    return HomeArg.execute(sender, args);
                }
                else if(args[0].equalsIgnoreCase("members") || args[0].equalsIgnoreCase("czlonkowie")) {
                    return MembersArg.execute(sender);
                }
                else if(args[0].equalsIgnoreCase("list") || args[0].equalsIgnoreCase("lista")) {
                    return ListArg.execute(sender);
                }
                else if(args[0].equalsIgnoreCase("description") || args[0].equalsIgnoreCase("opis") || args[0].equalsIgnoreCase("desc")) {
                    return DescriptionArg.execute(sender, args);
                } else {
                    return error(sender, "cmdsyntaxerr");
                }
            } else {
                HelpArg.execute(sender, args);
                return true;
            }
        }
        return false;
    }

    private boolean error(CommandSender sender, String msg) {
        sender.sendMessage(MsgManager.get(msg));
        sender.sendMessage(MsgManager.get("seehelp"));
        return true;
    }

}
