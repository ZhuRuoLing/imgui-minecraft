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

package icu.takeneko.mcimgui.event.application;

import icu.takeneko.mcimgui.event.Event;
import icu.takeneko.mcimgui.event.EventListener;

/**
 * Event to handle Application registration
 */
public class ApplicationRegistrationEvent extends Event<EventListener<ApplicationRegistrationEventArgs>, ApplicationRegistrationEventArgs> {
    public static final ApplicationRegistrationEvent INSTANCE = new ApplicationRegistrationEvent();
}
