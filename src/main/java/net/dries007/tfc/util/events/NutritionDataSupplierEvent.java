/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.dries007.tfc.util.events;

import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

import net.dries007.tfc.common.component.food.INutritionData;
import net.dries007.tfc.common.player.PlayerInfo;

public class NutritionDataSupplierEvent extends Event implements IModBusEvent
{
    private final PlayerInfo.NutritionDataSupplier<INutritionData> supplier;

    public NutritionDataSupplierEvent(PlayerInfo.NutritionDataSupplier<INutritionData> supplier)
    {
        this.supplier = supplier;
    }

    public PlayerInfo.NutritionDataSupplier<INutritionData> getSupplier()
    {
        return this.supplier;
    }
}
