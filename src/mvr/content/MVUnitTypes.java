package mvr.content;

import arc.struct.Seq;
import mindustry.ai.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import mvr.classes.draw.DrawRotor;
import mvr.classes.entities.abilities.*;
import mvr.classes.entities.ai.*;
import mvr.graphics.MVPal;

public class MVUnitTypes {
    public static UnitType
    //air miner
    bullhead, bulwark,
    //air shifter
    phantasm,
    //air heli
    serpent,
    //ground mech
    sabre;
    public static void load(){
        bullhead = new UnitType("bullhead"){{
            controller = u -> new RevengeMinerAI(){{
                mineItems = Seq.with(Items.copper, Items.lead, Items.titanium, MVRes.iron, MVRes.aluminium);
            }};;

            defaultCommand = UnitCommand.mineCommand;

            flying = true;
            drag = 0.08f;
            accel = 0.14f;
            speed = 1.8f;
            health = 180;
            engineSize = 1.8f;
            engineOffset = 6.4f;
            hitSize = 10;
            range = 100f;
            isEnemy = false;
            constructor = UnitEntity::create;

            ammoType = new PowerAmmoType(800);

            mineTier = 4;
            mineSpeed = 3f;
            weapons.add(new Weapon(""){{
                shootCone = 22.5f;
                reload = 12f;
                x = 4f;
                y = 5f;
                recoil = 1f;
                top = false;
                inaccuracy = 2;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(3f, 6){{
                    width = 6f;
                    height = 9f;
                    lifetime = 100 / 3f;
                }};
            }});
        }};
        bulwark = new UnitType("bulwark"){{
            controller = u -> new RevengeMinerAI();

            defaultCommand = UnitCommand.mineCommand;

            flying = true;
            drag = 0.06f;
            accel = 0.12f;
            speed = 1.5f;
            health = 100;
            engineSize = 1.8f;
            engineOffset = 5.7f;
            range = 50f;
            isEnemy = false;
            constructor = UnitEntity::create;

            ammoType = new PowerAmmoType(500);

            mineTier = 1;
            mineSpeed = 2.5f;
            weapons.add(new Weapon("large-weapon"){{
                reload = 13f;
                x = 2f;
                y = 0f;
                top = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(2.5f, 9){{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
                }};
            }});
        }};
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
            abilities.add(new ShiftAbility(1.2f,0.95f));

            weapons.add(new Weapon("mechanical-warfare-revisit-phantasmal-gun-equip"){{
                y = 0f;
                x = 4.5f;
                reload = 20f;
                top = false;
                alternate = true;
                inaccuracy = 2;
                ejectEffect = Fx.casing1;
                bullet = new FlakBulletType(12f, 5){{
                    collidesGround = true;
                    width = 6f;
                    height = 10f;
                    shrinkX = shrinkY = 0.3f;
                    lifetime = 15f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitEffect = Fx.flakExplosion;
                    explodeRange = 12;
                    sprite = "shell";
                }};
                shootSound = Sounds.shootBig;
            }});
        }};
        serpent = new UnitType("serpent"){{
            speed = 1.2f;
            drag = 0.08f;
            flying = true;
            health = 900;
            engineOffset = 5.2f;
            engineSize = 0;
            constructor = UnitEntity::create;
            hitSize = 15;
            itemCapacity = 40;
            parts.add(new DrawRotor("rotor-blade", 3));

            weapons.add(new Weapon("mechanical-warfare-revisit-serpent-gun-equip"){{
                y = 1.1f;
                x = 6.5f;
                layerOffset = -1f;
                reload = 12f;
                alternate = true;
                recoil = 1.5f;
                inaccuracy = 3;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(9f, 8){{
                    width = 6f;
                    height = 9f;
                    lifetime = 14f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitEffect = Fx.hitBulletSmall;
                }};
                shootSound = Sounds.shootSnap;
            }},
                    new Weapon("mechanical-warfare-revisit-serpent-launcher-equip"){{
                        y = 1f;
                        x = 3.5f;
                        reload = 80f;
                        alternate = true;
                        shootCone = 45;
                        recoil = 1.5f;
                        inaccuracy = 3;
                        ejectEffect = Fx.casing3;
                        bullet = new MissileBulletType(2.8f, 24){{
                            width = 9f;
                            height = 12f;
                            lifetime = 50f;
                            drag = -0.01f;
                            shootEffect = Fx.shootBig;
                            smokeEffect = Fx.shootBigSmoke;
                            hitEffect = Fx.blastExplosion;
                            homingPower = 2;
                            homingRange = 120;
                        }};
                        shootSound = Sounds.missile;
                    }});
        }};
        sabre = new UnitType("sabre"){{
            speed = 0.5f;
            hitSize = 9f;
            rotateSpeed = 2.6f;
            targetAir = false;
            health = 600;
            armor = 12f;
            mechFrontSway = 0.4f;
            ammoType = new ItemAmmoType(MVRes.sulfur);
            immunities.add(StatusEffects.corroded);
            constructor = MechUnit::create;
            weapons.add(new Weapon("mechanical-warfare-revisit-sabre-launcher-equip"){{
                top = false;
                y = 1f;
                x = 7f;
                reload = 90f;
                recoil = 3f;
                shake = 2f;
                ejectEffect = Fx.casing2;
                shootSound = Sounds.shootBig;
                bullet = new MissileBulletType(2.5f, 20){{
                    lifetime = 64f;
                    width = 9f;
                    height = 13f;
                    collides = true;
                    collidesTiles = true;
                    homingPower = 0.5f;
                    homingRange = 50;
                    backColor = MVPal.frontColorAcid;
                    frontColor = MVPal.backColorAcid;
                    status = StatusEffects.corroded;
                    fragBullets = 10;
                    fragBullet = new MissileBulletType(2.5f, 4){{
                            lifetime = 24f;
                            width = 7f;
                            height = 9f;
                            collides = true;
                            collidesTiles = true;
                            homingPower = 0.5f;
                            homingRange = 75;
                            splashDamage = 20;
                            splashDamageRadius = 5;
                            backColor = MVPal.frontColorAcid;
                            frontColor = MVPal.backColorAcid;
                            status = StatusEffects.corroded;
                            fragBullets = 3;
                            fragBullet = new LiquidBulletType(MVRes.acid){{
                                lifetime = 2;
                                speed = 1;
                                damage = 2;
                            }};
                        }};
                }};
            }});
        }};
    }
}
