// 
// Decompiled by Procyon v0.5.36
// 

package from.Command;

import cn.nukkit.form.window.FormWindow;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import from.NickUI;
import cn.nukkit.command.Command;

public class NickCMD extends Command
{
    static int NICKMAINUI;
    private final NickUI plugin;
    
    public NickCMD(final NickUI plugin) {
        super("nick");
        this.plugin = plugin;
    }
    
    public boolean execute(final CommandSender commandSender, final String s, final String[] strings) {
        if (commandSender instanceof Player) {
            final Player player = (Player)commandSender;
            if (!this.plugin.getNickConfig().permission()) {
                final FormWindowSimple formWindowSimple = new FormWindowSimple(this.plugin.getNickConfig().titel(), this.plugin.getNickConfig().content());
                formWindowSimple.addButton(new ElementButton(this.plugin.getNickConfig().button1()));
                formWindowSimple.addButton(new ElementButton(this.plugin.getNickConfig().button2()));
                player.showFormWindow((FormWindow)formWindowSimple, NickCMD.NICKMAINUI);
            }
            else if (player.hasPermission("cmd.nick")) {
                final FormWindowSimple formWindowSimple = new FormWindowSimple(this.plugin.getNickConfig().titel(), this.plugin.getNickConfig().content());
                formWindowSimple.addButton(new ElementButton(this.plugin.getNickConfig().button1()));
                formWindowSimple.addButton(new ElementButton(this.plugin.getNickConfig().button2()));
                player.showFormWindow((FormWindow)formWindowSimple, NickCMD.NICKMAINUI);
            }
            else {
                player.sendMessage(this.plugin.getNickConfig().permission1());
            }
        }
        return true;
    }
    
    static {
        NickCMD.NICKMAINUI = 178913281;
    }
}
