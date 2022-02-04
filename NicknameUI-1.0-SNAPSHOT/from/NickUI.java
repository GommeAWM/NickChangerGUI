// 
// Decompiled by Procyon v0.5.36
// 

package from;

import cn.nukkit.plugin.PluginManager;
import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.event.Listener;
import cn.nukkit.command.Command;
import from.Command.NickCMD;
import cn.nukkit.Player;
import java.util.HashMap;
import from.utils.NickConfig;
import from.Listener.NickResponse;
import cn.nukkit.plugin.PluginBase;

public class NickUI extends PluginBase
{
    public static NickUI nickUI;
    public NickResponse nickResponse;
    public static NickConfig nickConfig;
    HashMap<Player, String> normalname;
    
    public NickUI() {
        this.normalname = new HashMap<Player, String>();
    }
    
    public void onEnable() {
        (NickUI.nickUI = this).registerAll();
        (NickUI.nickConfig = new NickConfig(this)).createDefaultConfig();
        this.getLogger().info("§fEnable: §a§lNicknameUI");
    }
    
    public void onDisable() {
        this.getLogger().info("§fDisable: §c§lNicknameUI");
    }
    
    private void registerAll() {
        final SimpleCommandMap simpleCommandMap = this.getServer().getCommandMap();
        simpleCommandMap.register("nick", (Command)new NickCMD(this));
        final PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents((Listener)new NickResponse(this), (Plugin)this);
    }
    
    public NickResponse getNickResponse() {
        return this.nickResponse;
    }
    
    public NickConfig getNickConfig() {
        return NickUI.nickConfig;
    }
}
