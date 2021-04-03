package io.github.prospector.modmenu.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;

public class ModMenuButtonWidget extends ButtonWidget {
	private final Screen parent;

	public ModMenuButtonWidget(int id, int x, int y, String text, Screen parent) {
		super(id, x, y, text);
		this.parent = parent;
	}

	public void onClick() {
		MinecraftClient.getInstance().openScreen(new ModListScreen(parent));
	}
}
