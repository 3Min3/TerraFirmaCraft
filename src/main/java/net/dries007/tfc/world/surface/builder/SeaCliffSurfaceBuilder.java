/*
 * Licensed under the EUPL, Version 1.2.
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 */

package net.dries007.tfc.world.surface.builder;

import net.minecraft.core.BlockPos;

import net.dries007.tfc.world.Seed;
import net.dries007.tfc.world.biome.BiomeNoise;
import net.dries007.tfc.world.noise.Noise2D;
import net.dries007.tfc.world.noise.OpenSimplex2D;
import net.dries007.tfc.world.surface.SurfaceBuilderContext;
import net.dries007.tfc.world.surface.SurfaceState;
import net.dries007.tfc.world.surface.SurfaceStates;

import static net.dries007.tfc.world.TFCChunkGenerator.*;
import static net.dries007.tfc.world.surface.SurfaceStates.*;

public class SeaCliffSurfaceBuilder implements SurfaceBuilder
{

    public static final SurfaceBuilderFactory SANDY = seed -> new SeaCliffSurfaceBuilder(seed, ShoreSurfaceBuilder.SANDY.apply(seed), NormalSurfaceBuilder.ROCKY, RARE_SHORE_SAND, SEA_LEVEL_Y + 1, true);
    public static final SurfaceBuilderFactory GRAVELLY = seed -> new SeaCliffSurfaceBuilder(seed, ShoreSurfaceBuilder.GRAVELLY.apply(seed), NormalSurfaceBuilder.ROCKY, GRAVEL, SEA_LEVEL_Y + 1, false);


    private final Noise2D variantNoise;
    private final SurfaceBuilder beachBuilder;
    private final NormalSurfaceBuilder landBuilder;
    private final SurfaceState beachTopState;
    private final int border;
    private final boolean usesShoreSands;

    public SeaCliffSurfaceBuilder(Seed seed, SurfaceBuilder beachBuilder, NormalSurfaceBuilder landBuilder, SurfaceState beachTopState, int border, boolean usesShoreSands)
    {
        this.beachBuilder = beachBuilder;
        this.landBuilder = landBuilder;
        this.beachTopState = beachTopState;
        this.border = border;
        this.usesShoreSands = usesShoreSands;
        this.variantNoise = new OpenSimplex2D(seed.seed()).octaves(5).spread(0.0003f).abs();
    }

    @Override
    public void buildSurface(SurfaceBuilderContext context, int startY, int endY)
    {
        if (startY < border)
        {
            beachBuilder.buildSurface(context, startY, endY);
        }
        else if (usesShoreSands)
        {
            final BlockPos pos = context.pos();
            final int x = pos.getX();
            final int z = pos.getZ();
            final float variantNoiseValue = (float) variantNoise.noise(x, z);

            // The following shall match the sand selection in ShoreSurfaceBuilder.java
            // Rare sands are the "typical" state
            if (variantNoiseValue > 0.65f)
            {
                landBuilder.buildSurface(context, startY, endY, RARE_SHORE_SAND, RARE_SHORE_SAND, RARE_SHORE_SANDSTONE, border, true);
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
                landBuilder.buildSurface(context, startY, endY, top, top, under, border, true);
            }
        }
        else
        {
            landBuilder.buildSurface(context, startY, endY, beachTopState, beachTopState, SurfaceStates.RAW, border, true);
        }
    }
}
