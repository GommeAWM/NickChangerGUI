// 
// Decompiled by Procyon v0.5.36
// 

package from.Listener;

import java.util.Iterator;
import cn.nukkit.Server;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.EventHandler;
import cn.nukkit.form.response.FormResponseCustom;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.window.FormWindow;
import cn.nukkit.form.element.ElementDropdown;
import cn.nukkit.form.element.ElementInput;
import cn.nukkit.form.element.Element;
import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.form.window.FormWindowCustom;
import java.util.ArrayList;
import java.util.List;
import cn.nukkit.Player;
import java.util.HashMap;
import from.NickUI;
import cn.nukkit.event.Listener;

public class NickResponse implements Listener
{
    public NickUI nickUI;
    HashMap<Player, String> normaldaten;
    HashMap<Player, String> customdaten;
    List<Player> players;
    static int NICKMAINUI;
    static int NICKCHANGERUI;
    
    public NickResponse(final NickUI nickUI) {
        this.normaldaten = new HashMap<Player, String>();
        this.customdaten = new HashMap<Player, String>();
        this.players = new ArrayList<Player>();
        this.nickUI = nickUI;
    }
    
    public void NickChanger(final Player player) {
        final FormWindowCustom formWindowCustom = new FormWindowCustom(this.nickUI.getNickConfig().titel1());
        final List<String> chatsystem = new ArrayList<String>();
        chatsystem.add(TextFormat.GREEN + this.nickUI.getNickConfig().enable());
        chatsystem.add(TextFormat.RED + this.nickUI.getNickConfig().disable());
        formWindowCustom.addElement((Element)new ElementLabel(this.nickUI.getNickConfig().label()));
        formWindowCustom.addElement((Element)new ElementInput(this.nickUI.getNickConfig().inputlabel()));
        formWindowCustom.addElement((Element)new ElementDropdown(this.nickUI.getNickConfig().dropdown(), (List)chatsystem));
        player.showFormWindow((FormWindow)formWindowCustom, NickResponse.NICKCHANGERUI);
    }
    
    @EventHandler
    public void PlayerNickResponse(final PlayerFormRespondedEvent event) {
        final Player player = event.getPlayer();
        if (event.getWindow() instanceof FormWindowSimple) {
            final FormWindowSimple formWindowSimple = (FormWindowSimple)event.getWindow();
            if (event.getFormID() == NickResponse.NICKMAINUI) {
                if (event.wasClosed()) {
                    return;
                }
                if (formWindowSimple.getResponse().getClickedButton().getText().equals(this.nickUI.getNickConfig().button1())) {
                    this.NickChanger(player);
                }
                if (formWindowSimple.getResponse().getClickedButton().getText().equals(this.nickUI.getNickConfig().button2())) {
                    final String playernick = this.normaldaten.get(player);
                    player.setDisplayName(playernick);
                    player.setNameTag(playernick);
                    player.sendMessage(this.nickUI.getNickConfig().msg());
                    this.players.remove(player);
                }
            }
        }
        if (event.getWindow() instanceof FormWindowCustom) {
            final FormWindowCustom formWindowCustom = (FormWindowCustom)event.getWindow();
            final FormResponseCustom formResponseCustom = (FormResponseCustom)event.getResponse();
            if (event.getFormID() == NickResponse.NICKCHANGERUI) {
                if (event.wasClosed()) {
                    return;
                }
                final String customnick = formResponseCustom.getInputResponse(1);
                final String resultofdrop = formWindowCustom.getResponse().getDropdownResponse(2).getElementContent();
                if (customnick != null) {
                    if (customnick.length() <= this.nickUI.getNickConfig().maxcount()) {
                        final String name = player.getName();
                        if (customnick != name) {
                            this.normaldaten.put(player, name);
                            this.customdaten.put(player, customnick);
                            player.setNameTag(customnick);
                            player.setDisplayName(customnick);
                            player.sendPopup(customnick);
                            if (resultofdrop.equals(TextFormat.GREEN + this.nickUI.getNickConfig().enable())) {
                                this.players.add(player);
                            }
                            else {
                                this.players.remove(player);
                            }
                        }
                        else {
                            player.sendMessage(this.nickUI.getNickConfig().error3());
                        }
                    }
                    else {
                        player.sendMessage(this.nickUI.getNickConfig().error2());
                    }
                }
                else {
                    player.sendMessage(this.nickUI.getNickConfig().error1());
                }
            }
        }
    }
    
    @EventHandler
    public void ChatListener(final PlayerChatEvent event) {
        final Player player = event.getPlayer();
        if (this.players.contains(player)) {
            event.setCancelled(true);
            final String name = this.customdaten.get(player);
            for (final Player pl : Server.getInstance().getOnlinePlayers().values()) {
                player.sendMessage(this.nickUI.getNickConfig().chatsystem().replace("%name", name).replace("%message", event.getMessage()));
            }
        }
    }
    
    static {
        NickResponse.NICKMAINUI = 178913281;
        NickResponse.NICKCHANGERUI = 178913282;
    }
}
