package io.github.prospector.modmenu.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.util.Identifier;

public class ModMenuTexturedButtonWidget extends ButtonWidget {
	private final Identifier texture;
	private final int u;
	private final int v;
	private final int uWidth;
	private final int vHeight;

	protected ModMenuTexturedButtonWidget(int id, int x, int y, int width, int height, int u, int v, Identifier texture) {
		this(id, x, y, width, height, u, v, texture, 256, 256);
	}

	protected ModMenuTexturedButtonWidget(int id, int x, int y, int width, int height, int u, int v, Identifier texture, int uWidth, int vHeight) {
		this(id, x, y, width, height, u, v, texture, uWidth, vHeight, "");
	}

	protected ModMenuTexturedButtonWidget(int id, int x, int y, int width, int height, int u, int v, Identifier texture, int uWidth, int vHeight, String message) {
		super(id, x, y, width, height, message);
		this.uWidth = uWidth;
		this.vHeight = vHeight;
		this.u = u;
		this.v = v;
		this.texture = texture;
	}

	protected void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void renderBg(MinecraftClient client, int mouseX, int mouseY) {
		client.getTextureManager().bindTexture(this.texture);
		GlStateManager.color4f(1, 1, 1, 1f);
		GlStateManager.disableDepthTest();
		int adjustedV = this.v;
		if (!active) {
			adjustedV += this.height * 2;
		} else if (this.isHovered()) {
			adjustedV += this.height;
		}

		drawTexture(this.x, this.y, this.u, adjustedV, this.width, this.height, this.uWidth, this.vHeight);
		GlStateManager.enableDepthTest();
	}
}
