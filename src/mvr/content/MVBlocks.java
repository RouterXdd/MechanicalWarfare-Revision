package mvr.content;

import arc.graphics.Color;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;
import mvr.MVPal;
import mvr.classes.defence.turrets.BunkerTurret;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;
public class MVBlocks {
    public static Block

            //turrets
            heatLasor, aegis, ghost, nighthawk;
    public static void load(){
        heatLasor = new TractorBeamTurret("incandescence"){{
            requirements(Category.turret, with(Items.lead, 160, Items.titanium, 120, Items.silicon, 120, MVItems.steel, 100));

            hasPower = true;
            targetGround = true;
            size = 2;
            force = 0f;
            scaledForce = 0f;
            range = 100f;
            damage = 1f;
            scaledHealth = 160;
            rotateSpeed = 7;
            status = MVStatuses.ultraMelting;
            statusDuration = 50;
            shootSound = MVSounds.heatrayActive;
            //research = arc

            consumePower(4f);
        }};
        aegis = new BunkerTurret("aegis"){{
            requirements(Category.turret, with(Items.copper, 50, Items.lead, 50, MVItems.steel, 40));
            ammo(
                    MVItems.cobblestone,  new BasicBulletType(3.3f, 4){{
                        width = 7f;
                        height = 10f;
                        lifetime = 36f;
                        inaccuracy = 9;
                        ammoMultiplier = 2;
                    }},
                    Items.copper,  new BasicBulletType(3.5f, 7){{
                        width = 7f;
                        height = 10f;
                        lifetime = 36f;
                        inaccuracy = 8;
                        ammoMultiplier = 2;
                    }},
                    MVItems.iron,  new BasicBulletType(3.9f, 10){{
                        width = 7f;
                        height = 10f;
                        lifetime = 32f;
                        inaccuracy = 7.5f;
                        ammoMultiplier = 2;
                    }},
                    Items.thorium,  new BasicBulletType(4.5f, 14){{
                        width = 7f;
                        height = 10f;
                        lifetime = 28f;
                        inaccuracy = 7;
                        ammoMultiplier = 2;
                    }},
                    MVItems.uranium,  new BasicBulletType(4.8f, 20){{
                        width = 7f;
                        height = 10f;
                        lifetime = 27f;
                        inaccuracy = 5.6f;
                        ammoMultiplier = 2;
                    }}
            );

            recoil = 1.2f;
            reload = 30f;
            range = 120;
            shootCone = 10f;
            ammoUseEffect = Fx.casing2;
            health = 3000;
            inaccuracy = 5f;
            shoot.shots = 5;
            rotateSpeed = 4f;
            coolant = consumeCoolant(0.2f);
            size = 2;
            //research = hail

            limitRange();
        }};
        ghost = new ItemTurret("ghost"){{
            requirements(Category.turret, with(Items.plastanium, 75, MVItems.steel, 100, Items.surgeAlloy, 50, Items.graphite, 150, Items.thorium, 125));
            ammo(
                    Items.metaglass, new FlakBulletType(18f, 12){{
                        width = 4f;
                        height = 15f;
                        lifetime = 14f;
                        ammoMultiplier = 2;
                        splashDamage = 48;
                        splashDamageRadius = 18;
                        hitEffect = Fx.flakExplosion;
                        despawnEffect = Fx.flakExplosion;
                        fragBullets = 12;
                        fragBullet = new BasicBulletType(2,9){{
                            width = 6f;
                            height = 12f;
                            drag = 0.5f;
                            lifetime = 20f;
                            shrinkX = shootY = 1;
                            despawnEffect = Fx.none;
                        }};
                    }},
                    Items.pyratite, new FlakBulletType(16f, 66){{
                        width = 5f;
                        height = 18f;
                        lifetime = 16f;
                        ammoMultiplier = 2;
                        splashDamage = 102;
                        splashDamageRadius = 18;
                        hitEffect = Fx.flakExplosion;
                        despawnEffect = Fx.flakExplosion;
                    }},
                    Items.blastCompound, new FlakBulletType(15f, 104){{
                        width = 4f;
                        height = 18f;
                        lifetime = 17f;
                        ammoMultiplier = 2;
                        splashDamage = 152;
                        splashDamageRadius = 42;
                        hitEffect = Fx.flakExplosion;
                        despawnEffect = Fx.flakExplosion;
                        reloadMultiplier = 0.6f;
                    }},
                    Items.plastanium, new FlakBulletType(18f, 18){{
                        width = 5f;
                        height = 18f;
                        lifetime = 14f;
                        ammoMultiplier = 3;
                        splashDamage = 56;
                        splashDamageRadius = 24;
                        hitEffect = Fx.plasticExplosionFlak;
                        despawnEffect = Fx.plasticExplosionFlak;
                        fragBullets = 12;
                        fragBullet = new BasicBulletType(2,12){{
                            width = 6f;
                            height = 12f;
                            lifetime = 20f;
                            drag = 0.5f;
                            shrinkX = shootY = 1;
                            despawnEffect = Fx.none;
                        }};
                    }},
                    Items.surgeAlloy, new FlakBulletType(18f, 20){{
                        width = 5f;
                        height = 18f;
                        lifetime = 14f;
                        ammoMultiplier = 3;
                        reloadMultiplier = 1.2f;
                        splashDamage = 48;
                        splashDamageRadius = 20;
                        status = StatusEffects.shocked;
                        lightningColor = Pal.surge;
                        lightning = 5;
                        lightningCone = 45;
                        lightningDamage = 20;
                        lightningLength = 10;
                        lightningLengthRand = 5;
                        hitEffect = Fx.flakExplosion;
                        despawnEffect = Fx.lightningShoot;
                    }},
                    MVItems.heShell, new FlakBulletType(13f, 125){{
                        width = 6f;
                        height = 21f;
                        lifetime = 20f;
                        ammoMultiplier = 5;
                        splashDamage = 174;
                        splashDamageRadius = 42;
                        backColor = MVPal.backColorHE;
                        frontColor = MVPal.frontColorHE;
                        hitEffect = Fx.blastExplosion;
                        despawnEffect = Fx.blastExplosion;
                    }}
            );

            shoot = new ShootAlternate(5.75f);

            recoil = 2.5f;
            targetGround = false;
            size = 3;
            shootY = 10f;
            reload = 15f;
            range = 240;
            shootCone = 15f;
            shootSound = Sounds.shootBig;
            ammoUseEffect = Fx.casing2Double;
            health = 1350;
            inaccuracy = 0f;
            rotateSpeed = 4f;
            coolant = consumeCoolant(0.4f);
            //research = swarmer
        }};
        nighthawk = new ItemTurret("nighthawk"){{
            requirements(Category.turret, with(Items.copper, 180, Items.graphite, 100, Items.titanium, 125, MVItems.iron, 150));
            ammo(
                    Items.graphite, new BasicBulletType(10f, 75){{
                        knockback = 0.8f;
                        lifetime = 50f;
                        width = 12;
                        height = 16f;
                        ammoMultiplier = 2;
                        hitEffect = Fx.hitBulletBig;
                        despawnEffect = Fx.hitBulletBig;
                        trailLength = 8;
                        trailWidth = 1;
                        trailColor = heatColor;
                        sprite = "mechanical-warfare-revisit-hvbullet";
                    }},
                    Items.titanium, new BasicBulletType(12f, 98){{
                        knockback = 0.8f;
                        lifetime = 42f;
                        width = 12;
                        height = 20f;
                        ammoMultiplier = 2;
                        pierce = true;
                        pierceCap = 2;
                        hitEffect = Fx.hitBulletBig;
                        despawnEffect = Fx.hitBulletBig;
                        trailLength = 9;
                        trailWidth = 1;
                        trailColor = heatColor;
                        sprite = "mechanical-warfare-revisit-hvbullet";
                    }},
                    MVItems.apShell, new BasicBulletType(14f, 140){{
                        knockback = 0.8f;
                        lifetime = 36f;
                        width = 12;
                        height = 25f;
                        pierce = true;
                        pierceCap = 4;
                        ammoMultiplier = 3;
                        backColor = MVPal.backColorAP;
                        frontColor = MVPal.frontColorAP;
                        hitEffect = Fx.hitLancer;
                        despawnEffect = Fx.hitLancer;
                        trailLength = 10;
                        trailWidth = 1;
                        trailColor = heatColor;
                        sprite = "mechanical-warfare-revisit-hvbullet";
                    }}
            );
            size = 3;
            reload = 160f;
            recoil = 2.5f;
            range = 420f;
            inaccuracy = 0.3f;
            shootCone = 3f;
            health = 1350;
            rotateSpeed = 6;
            shootSound = Sounds.shootBig;
            coolant = consumeCoolant(0.4f);
            //research = salvo
        }};
    }
}
