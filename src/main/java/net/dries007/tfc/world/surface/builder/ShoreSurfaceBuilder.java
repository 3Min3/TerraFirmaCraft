/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.dries007.tfc.world.surface.builder;

import net.minecraft.core.BlockPos;

import net.dries007.tfc.world.Seed;
import net.dries007.tfc.world.noise.Noise2D;
import net.dries007.tfc.world.noise.OpenSimplex2D;
import net.dries007.tfc.world.surface.SurfaceBuilderContext;
import net.dries007.tfc.world.surface.SurfaceState;
import net.dries007.tfc.world.surface.SurfaceStates;

public class ShoreSurfaceBuilder implements SurfaceBuilder
{
    public static final SurfaceBuilderFactory SANDY = seed -> new ShoreSurfaceBuilder(seed, SurfaceStates.RARE_SHORE_SAND, SurfaceStates.RARE_SHORE_SANDSTONE, false);
    public static final SurfaceBuilderFactory GRAVELLY = seed -> new ShoreSurfaceBuilder(seed, SurfaceStates.GRAVEL, SurfaceStates.RAW, true);

    private final Noise2D variantNoise;
    private final SurfaceState typicalSurfaceState, typicalUnderState;
    private final boolean gravelly;

    protected ShoreSurfaceBuilder(Seed seed, SurfaceState rareSandState, SurfaceState rareSandUnderState, boolean gravelly)
    {
        this.typicalSurfaceState = rareSandState;
        this.typicalUnderState = rareSandUnderState;
        this.gravelly = gravelly;
        this.variantNoise = new OpenSimplex2D(seed.seed()).octaves(5).spread(0.0003f).abs();
    }

    @Override
    public void buildSurface(SurfaceBuilderContext context, int startY, int endY)
    {
        // Adjust slope, shores should have high relief carving where they intersect with the landmass
        final double slope = context.getSlope();
        context.setSlope(slope * (slope + 0.2));

        final BlockPos pos = context.pos();
        final int x = pos.getX();
        final int z = pos.getZ();
        final float variantNoiseValue = (float) variantNoise.noise(x, z);

        // The following shall match the sand selection in SeaCliffSurfaceBuilder.java
        // Rare sands are the "typical" state
        if (gravelly || variantNoiseValue > 0.65f)
        {
            NormalSurfaceBuilder.ROCKY.buildSurface(context, startY, endY, typicalSurfaceState, typicalSurfaceState, typicalUnderState);
        }
        else
        {
            final SurfaceState top;
            final SurfaceState under;
            if (variantNoiseValue > 0.4)
            {
                top = SurfaceStates.RED_SAND;
                under = SurfaceStates.RED_SANDSTONE;
            }
            else if (variantNoiseValue > 0.22)
            {
                top = SurfaceStates.BROWN_SAND;
                under = SurfaceStates.BROWN_SANDSTONE;
            }
            else
            {
                top = SurfaceStates.YELLOW_SAND;
                under = SurfaceStates.YELLOW_SANDSTONE;
            }
            NormalSurfaceBuilder.ROCKY.buildSurface(context, startY, endY, top, top, under);
        }
    }

}