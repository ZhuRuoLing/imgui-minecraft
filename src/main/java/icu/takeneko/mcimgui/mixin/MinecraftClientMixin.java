/*
 * This file is part of the ImGui Minecraft project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2024  ZhuRuoLing and contributors
 *
 * ImGui Minecraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ImGui Minecraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ImGui Minecraft.  If not, see <https://www.gnu.org/licenses/>.
 */

package icu.takeneko.mcimgui.mixin;

import com.mojang.blaze3d.platform.Window;
import icu.takeneko.mcimgui.Application;
import icu.takeneko.mcimgui.McImGui;
import imgui.ImGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftClientMixin {
    @Shadow @Final private Window window;

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;initRenderer(IZ)V"))
    void onInitRenders(GameConfig gameConfig, CallbackInfo ci){
        McImGui.imGuiGlfw.init(window.getWindow(), true);
        McImGui.imGuiGl3.init(McImGui.glslVersion);
    }

    @Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Window;updateDisplay()V"))
    void onRender(boolean bl, CallbackInfo ci){
        McImGui.imGuiGlfw.newFrame();
        ImGui.newFrame();
        McImGui.APPLICATIONS.forEach(Application::frame);
        ImGui.render();
        McImGui.imGuiGl3.renderDrawData(ImGui.getDrawData());
    }
}
