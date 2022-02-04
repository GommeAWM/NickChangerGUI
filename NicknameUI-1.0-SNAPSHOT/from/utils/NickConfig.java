// 
// Decompiled by Procyon v0.5.36
// 

package from.utils;

import cn.nukkit.utils.Config;
import java.io.File;
import from.NickUI;

public class NickConfig
{
    public NickUI nickUI;
    public File file;
    public Config config;
    
    public NickConfig(final NickUI nickUI) {
        this.nickUI = nickUI;
        this.file = new File(nickUI.getDataFolder() + "NickConfig.yml");
        this.config = new Config(this.file, 2);
    }
    
    public void createDefaultConfig() {
        this.addDefault("options.titel0", "§0NickChanger");
        this.addDefault("options.titel1", "§0NickChanger");
        this.addDefault("options.maxlength", 20);
        this.addDefault("options.content0", "§a---> §fWrite your custom nickname");
        this.addDefault("options.ui.button1", "§6PRESS: §fChange nick");
        this.addDefault("options.ui.button2", "§6PRESS: §freset");
        this.addDefault("options.ui.label", "PANEL FOR NICKNAME - Check Config for edit");
        this.addDefault("options.ui.inputlabel", "§6The nickname length is max 20");
        this.addDefault("options.ui.messages.success", "§6§lNickUI §f-> §aThe nick was successfully changed");
        this.addDefault("options.ui.messages.error.empty", "§cThat can't be empty");
        this.addDefault("options.ui.messages.error.length", "§cMax length is 20");
        this.addDefault("options.ui.messages.error.samename", "§cYou can't use the same nick");
        this.addDefault("options.ui.messages.chatsystem.enable", "Enable the chat system");
        this.addDefault("options.ui.messages.chatsystem.disable", "Disable the chat system");
        this.addDefault("options.ui.messages.chatsystem.dropdown", "Chat system (for working in Chat)");
        this.addDefault("options.ui.messages.chatsystem.settings", "<%name>§f %message");
        this.addDefault("options.permission", true);
        this.addDefault("options.permission1", "ANY PERMISSION");
    }
    
    public String titel() {
        return this.config.getString("options.titel0");
    }
    
    public String titel1() {
        return this.config.getString("options.titel1");
    }
    
    public String content() {
        return this.config.getString("options.content0");
    }
    
    public String button1() {
        return this.config.getString("options.ui.button1");
    }
    
    public String button2() {
        return this.config.getString("options.ui.button2");
    }
    
    public String label() {
        return this.config.getString("options.ui.label");
    }
    
    public String inputlabel() {
        return this.config.getString("options.ui.inputlabel");
    }
    
    public String msg() {
        return this.config.getString("options.ui.messages.success");
    }
    
    public String error1() {
        return this.config.getString("options.ui.messages.error.empty");
    }
    
    public String error2() {
        return this.config.getString("options.ui.messages.error.length");
    }
    
    public String error3() {
        return this.config.getString("options.ui.messages.error.samename");
    }
    
    public boolean permission() {
        return this.config.getBoolean("options.permission");
    }
    
    public String permission1() {
        return this.config.getString("options.permission1");
    }
    
    public String enable() {
        return this.config.getString("options.ui.messages.chatsystem.enable");
    }
    
    public String disable() {
        return this.config.getString("options.ui.messages.chatsystem.disable");
    }
    
    public String dropdown() {
        return this.config.getString("options.ui.messages.chatsystem.dropdown");
    }
    
    public String chatsystem() {
        return this.config.getString("options.ui.messages.chatsystem.settings");
    }
    
    public Integer maxcount() {
        return this.config.getInt("options.maxlength");
    }
    
    public void addDefault(final String path, final Object object) {
        if (!this.config.exists(path)) {
            this.config.set(path, object);
            this.config.save(this.file);
        }
    }
}
