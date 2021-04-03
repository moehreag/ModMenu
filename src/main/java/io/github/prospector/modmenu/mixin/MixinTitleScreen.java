package io.github.prospector.modmenu.mixin;

import io.github.prospector.modmenu.ModMenu;
import io.github.prospector.modmenu.gui.ModMenuButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;

@Mixin(TitleScreen.class)
public class MixinTitleScreen extends Screen {
	@Inject(at = @At("RETURN"), method = "init")
	public void drawMenuButton(CallbackInfo info) {
		buttons.add(new ModMenuButtonWidget(123123, this.width / 2 - 100, this.height / 4 + 48 + 24 * 3, I18n.translate("modmenu.title") + " " + I18n.translate("modmenu.loaded", ModMenu.getFormattedModCount()), this));
		for (ButtonWidget button : buttons) {
			if (button.y <= this.height / 4 + 48 + 24 * 3) {
				button.y -= 12;
			}
			if (button.y > this.height / 4 + 48 + 24 * 3) {
				button.y += 12;
			}
		}
	}

	@Inject(at = @At("HEAD"), method = "buttonClicked", cancellable = true)
	public void buttonPressed(ButtonWidget button, CallbackInfo ci) {
		if (button instanceof ModMenuButtonWidget) {
			((ModMenuButtonWidget) button).onClick();
			ci.cancel();
		}
	}
}
