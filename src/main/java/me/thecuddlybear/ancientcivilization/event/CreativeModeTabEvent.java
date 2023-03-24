package me.thecuddlybear.ancientcivilization.event;

import me.thecuddlybear.ancientcivilization.Ancientcivilization;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ancientcivilization.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class CreativeModeTabEvent {

    @SubscribeEvent
    public static void onCreativeTabRegistry(net.minecraftforge.event.CreativeModeTabEvent.Register event){
        event.registerCreativeModeTab(new ResourceLocation(Ancientcivilization.MODID, "ancientcivtab"), builder -> {
           builder
                   .title(Component.translatable("item_group." + Ancientcivilization.MODID + ".ancientcivtab"))
                   .icon(() -> new ItemStack(Items.SCULK_SENSOR))
                   .displayItems((enabledFlags, populator) -> {
                       populator.accept(new ItemStack(Items.SCULK_SENSOR));
                   });
        });
    }

}
