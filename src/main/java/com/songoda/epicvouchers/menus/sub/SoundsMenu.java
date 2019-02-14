package com.songoda.epicvouchers.menus.sub;

import com.google.common.base.Enums;
import com.songoda.epicvouchers.EpicVouchers;
import com.songoda.epicvouchers.libraries.ItemBuilder;
import com.songoda.epicvouchers.libraries.inventory.IconInv;
import com.songoda.epicvouchers.libraries.inventory.icons.IntegerIcon;
import com.songoda.epicvouchers.libraries.inventory.icons.StringIcon;
import com.songoda.epicvouchers.menus.VoucherEditorMenu;
import com.songoda.epicvouchers.utils.SoundUtils;
import com.songoda.epicvouchers.voucher.Voucher;
import org.bukkit.Material;
import org.bukkit.Sound;

import static org.bukkit.ChatColor.GRAY;
import static org.bukkit.ChatColor.YELLOW;

public class SoundsMenu extends IconInv {
    public SoundsMenu(EpicVouchers instance, Voucher voucher) {
        super(9, "Sound");

        addIcon(1, new StringIcon(instance, "Sound", voucher.getSound(), (player, editString) -> {
            voucher.setSound(editString).saveSetting("sounds.sound", editString);
            new SoundsMenu(instance, voucher).open(player);
        }, string -> Enums.getIfPresent(SoundUtils.class, string).isPresent()));

        addIcon(2, new IntegerIcon(instance, "Pitch", voucher.getSoundPitch(), (player, number) -> {
            voucher.setSoundPitch(number).saveSetting("sounds.pitch", number);
            new SoundsMenu(instance, voucher).open(player);
        }));

        addIcon(0, new ItemBuilder(Material.BARRIER)
                .name(YELLOW + "Return")
                .lore(GRAY + "Return to the editor")
                .build(), event -> new VoucherEditorMenu(instance, voucher).open(event.getPlayer()));

    }
}