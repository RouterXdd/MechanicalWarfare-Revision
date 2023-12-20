package mvr.classes.defence.walls;

import arc.math.Mathf;
import mindustry.entities.Lightning;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.gen.Bullet;
import mindustry.world.blocks.power.*;
import mindustry.world.meta.BlockGroup;

public class InsulatorWall extends PowerGenerator {
    public float lightningMultiplier = 15f;

    public InsulatorWall(String name) {
        super(name);
        group = BlockGroup.walls;
        solid = true;
        destructible = true;
        sync = true;
        update = true;
        insulated = true;
        powerProduction = 2;
    }
    public class InsulatorWallBuild extends GeneratorBuild {
        @Override
        public void update(){
            super.update();
            productionEfficiency = Mathf.lerpDelta(productionEfficiency, 0, 0.05f);
        }
        @Override
        public boolean collision(Bullet b){
            if (b != null){
                if (!b.type.reflectable){
                    productionEfficiency += (b.damage / 150) * lightningMultiplier;
                    damage(b.damage);
                } else {
                    productionEfficiency += (b.damage / 150);
                    damage(b.damage);
                }
                return true;
            }

            return true;
        }
    }
}
