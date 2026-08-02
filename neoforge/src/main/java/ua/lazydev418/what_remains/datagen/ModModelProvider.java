package ua.lazydev418.what_remains.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import ua.lazydev418.what_remains.block.ModBlocks;
import ua.lazydev418.what_remains.util.Constants;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        //blockModels.createTrivialCube(ModBlocks.RUINS_BRICKS.get());
        blockModels.family(ModBlocks.RUINS_BRICKS.get())
                .slab(ModBlocks.RUINS_BRICKS_SLAB.get())
                .stairs(ModBlocks.RUINS_BRICKS_STAIRS.get())
                .wall(ModBlocks.RUINS_BRICKS_WALL.get());

        //blockModels.createTrivialCube(ModBlocks.RUINS_BRICKS_CRACKED.get());
        blockModels.family(ModBlocks.RUINS_BRICKS_CRACKED.get())
                .slab(ModBlocks.RUINS_BRICKS_CRACKED_SLAB.get())
                .stairs(ModBlocks.RUINS_BRICKS_CRACKED_STAIRS.get())
                .wall(ModBlocks.RUINS_BRICKS_CRACKED_WALL.get());

        //blockModels.createTrivialCube(ModBlocks.RUINS_BRICKS_MOSSY.get());
        blockModels.family(ModBlocks.RUINS_BRICKS_MOSSY.get())
                .slab(ModBlocks.RUINS_BRICKS_MOSSY_SLAB.get())
                .stairs(ModBlocks.RUINS_BRICKS_MOSSY_STAIRS.get())
                .wall(ModBlocks.RUINS_BRICKS_MOSSY_WALL.get());

    }
}
