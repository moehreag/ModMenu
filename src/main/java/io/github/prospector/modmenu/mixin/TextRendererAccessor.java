package io.github.prospector.modmenu.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.client.font.TextRenderer;

@Mixin(TextRenderer.class)
public interface TextRendererAccessor {
	@Invoker
	String callMirror(String text);
}
