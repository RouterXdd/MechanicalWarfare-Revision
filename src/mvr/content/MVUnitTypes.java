package mvr.content;

import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.meta.*;
import mvr.classes.entities.abilities.*;

public class MVUnitTypes {
    public static UnitType
    //air shifter
    phantasm;
    public static void load(){
        phantasm = new UnitType("phantasm"){{
            speed = 1.9f;
            accel = 0.08f;
            drag = 0.06f;
            flying = true;
            health = 900;
            engineOffset = 5.2f;
            constructor = UnitEntity::create;
            targetFlags = new BlockFlag[]{BlockFlag.factory, null};
            hitSize = 15;
            itemCapacity = 30;
            abilities.add(new ShiftAbility(0.8f,0.7f));

            weapons.add(new Weapon("mechanical-warfare-revisit-phantasmal-gun-equip"){{
                y = 0f;
                x = 4.5f;
                reload = 20f;
                alternate = true;
                inaccuracy = 2;
                ejectEffect = Fx.casing1;
                bullet = new FlakBulletType(12f, 5){{
                    width = 6f;
                    height = 10f;
                    shrinkX = shrinkY = 0.3f;
                    lifetime = 15f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitEffect = Fx.flakExplosion;
                    explodeRange = 12;
                    ammoMultiplier = 2;
                    sprite = "shell";
                }};
                shootSound = Sounds.shootBig;
            }});
        }};
    }
}
