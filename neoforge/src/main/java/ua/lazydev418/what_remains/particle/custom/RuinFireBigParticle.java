package ua.lazydev418.what_remains.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class RuinFireBigParticle extends SingleQuadParticle {
    private final float startSize;
    private final float maxSize;

    private final Layer layer;

    protected RuinFireBigParticle(ClientLevel level, double xCoord, double yCoord, double zCoord, SpriteSet spriteSet) {
        super(level, xCoord, yCoord, zCoord, spriteSet.get(0, 1));

        this.friction = 0.8F;
        this.lifetime = 40;

        this.startSize = 0.5F;
        this.maxSize = 1.0F;
        this.quadSize = startSize;

        RandomSource random = level.getRandom();
        this.xd = (random.nextFloat() - 0.5F) * 0.02;
        this.zd = (random.nextFloat() - 0.5F) * 0.02;
        this.yd = 0.0;

        this.setSpriteFromAge(spriteSet);

        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;
        this.alpha = 1f;

        this.layer = Layer.bySprite(this.sprite);
    }

    @Override
    public void tick() {
        super.tick();

        this.yd += 0.008;
        this.xd *= friction;
        this.zd *= friction;

        float progress = (float) age / lifetime;

        float startR = 1.0F, startG = 1.0F, startB = 1.0F;
        float endR = 0.45F, endG = 0.75F, endB = 1.0F;

        setColor(
                startR + (endR - startR) * progress,
                startG + (endG - startG) * progress,
                startB + (endB - startB) * progress
        );

        updateSize(progress);
    }

    private void updateSize(float progress) {
        if (progress < 1f / 4f) {
            float growProgress = progress / (1f / 4f);
            this.quadSize = startSize + (maxSize - startSize) * growProgress;
        } else {
            float shrinkProgress = (progress - 1f / 4f) / (2f / 3f);
            this.quadSize = maxSize - (maxSize - 0f) * shrinkProgress + 0.1f;
        }
    }

    @Override
    protected Layer getLayer() {
        return Layer.TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double v, double v1, double v2, double v3, double v4, double v5, RandomSource randomSource) {

            return new RuinFireBigParticle(clientLevel, v, v1, v2, this.sprites);
        }
    }
}