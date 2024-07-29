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

package icu.takeneko.mcimgui;

import icu.takeneko.mcimgui.event.application.ApplicationRegistrationEvent;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
import net.fabricmc.api.ClientModInitializer;

import java.util.ArrayList;
import java.util.List;

public class McImGui implements ClientModInitializer {
    public static final List<Application> APPLICATIONS = new ArrayList<>();
    public static String glslVersion;
    public static final ImGuiImplGlfw imGuiGlfw = new ImGuiImplGlfw();
    public static final ImGuiImplGl3 imGuiGl3 = new ImGuiImplGl3();

    static {
        //#if MC > 11605
        //$$ glslVersion = "#version 150";
        //#else
        glslVersion = "#version 110";
        //#endif
    }

    @Override
    public void onInitializeClient() {
        System.out.println("Hello World!");
        ApplicationRegistrationEvent.INSTANCE.addListener(it -> {
            it.register(new HintApplication());
        });
    }
}
