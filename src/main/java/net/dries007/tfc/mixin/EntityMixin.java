/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.dries007.tfc.mixin;

import net.minecraft.world.entity.Entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import net.dries007.tfc.common.fluids.TFCFluids;
import net.dries007.tfc.util.Helpers;

@Mixin(Entity.class)
public abstract class EntityMixin
{
    @Inject(method = "checkInsideBlocks", at = @At("HEAD"))
    private void checkInsideBlocksForCustomSlowEffects(CallbackInfo ci)
    {
        Helpers.slowEntityInsideBlocks((Entity) (Object) this);
    }

    @ModifyExpressionValue(method = "updateFluidHeightAndDoFluidPushing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;isInFluidType(Lnet/neoforged/neoforge/fluids/FluidType;)Z"))
    private boolean updateFluidHeightCheckAllWaterTypes(boolean original)
    {
        return original
            || ((Entity) (Object) this).isInFluidType(TFCFluids.SALT_WATER.getType())
            || ((Entity) (Object) this).isInFluidType(TFCFluids.SPRING_WATER.getType());
    }
}
