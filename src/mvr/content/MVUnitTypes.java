package mvr.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.ai.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import mvr.classes.draw.DrawRotor;
import mvr.classes.draw.HideDraw;
import mvr.classes.entities.abilities.*;
import mvr.classes.entities.ai.*;
import mvr.classes.entities.units.HideUnitType;
import mvr.graphics.MVPal;

public class MVUnitTypes {
    public static UnitType
    //air miner
    bullhead, bulwark,
    //air shifter
    apparition, phantasm,
    //air heli
    serpent, viper,
        //support heli
        bonker,
    //ground mech
    scrapper, rapier, sabre, dominator, nullifier,
    //ground electro
    mTron, anarchy;
    public static void load(){
        UnitTypes.pulsar.parts.add(new DrawRotor("rotor-blade-heal", 4.5f){{
            y = -2;
        }});
        UnitTypes.oct.setEnginesMirror(
                new UnitType.UnitEngine(120 / 4f, -110 / 4f, 6.5f, 310f)
        );
        UnitTypes.pulsar.engineSize = 0;
        bullhead = new UnitType("bullhead"){{
            controller = u -> new RevengeMinerAI(){{
                mineItems = Seq.with(Items.copper, Items.lead, Items.titanium, MVRes.iron, MVRes.aluminium);
            }};;

            defaultCommand = UnitCommand.mineCommand;

            flying = true;
            drag = 0.08f;
            accel = 0.14f;
            speed = 1.8f;
            health = 240;
            engineSize = 1.8f;
            engineOffset = 6.4f;
            hitSize = 10;
            range = 60f;
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
                bullet = new BasicBulletType(3f, 8){{
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
        apparition = new HideUnitType("apparition"){{
            speed = 2.2f;
            accel = 0.08f;
            drag = 0.045f;
            flying = true;
            health = 280;
            engineOffset = 6.35f;
            targetFlags = new BlockFlag[]{BlockFlag.generator, null};
            hitSize = 14;
            itemCapacity = 12;
            constructor = UnitEntity::create;
            parts.add(new HideDraw());
            weapons.add(new Weapon(){{
                y = 1f;
                x = 0f;
                mirror = false;
                reload = 30f;
                ejectEffect = Fx.casing1;
                bullet = new FlakBulletType(10f, 2){{
                    collidesGround = true;
                    width = 6f;
                    height = 10f;
                    shrinkX = shrinkY = 0.3f;
                    lifetime = 5f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    hitEffect = Fx.flakExplosion;
                    explodeRange = 8;
                    sprite = "shell";
                }};
                shootSound = Sounds.shootBig;
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
            hitSize = 15;
            itemCapacity = 30;
            abilities.add(new ShiftAbility(35f, 0.05f));

            weapons.add(new Weapon("mechanical-warfare-revisit-phantasmal-gun-equip"){{
                y = 0.25f;
                x = 4f;
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
            speed = 1.6f;
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
        viper = new UnitType("viper"){{
            speed = 2.05f;
            drag = 0.095f;
            flying = true;
            health = 1100;
            engineOffset = 5.2f;
            engineSize = 0;
            constructor = UnitEntity::create;
            hitSize = 18;
            itemCapacity = 45;
            parts.add(new DrawRotor("rotor-blade2", 5f){{
                y = 14;
            }},
                    new DrawRotor("rotor-blade2", 3f){{
                        y = -6;
                    }}
            );

            weapons.add(new Weapon("mechanical-warfare-revisit-viper-machine-gun-equip"){{
                            y = 20f;
                            x = 4f;
                            layerOffset = -1f;
                            reload = 16f;
                            alternate = true;
                            recoil = 1.5f;
                            inaccuracy = 3;
                            ejectEffect = Fx.casing1;
                            bullet = new BasicBulletType(6f, 12){{
                                width = 6f;
                                height = 9f;
                                lifetime = 21f;
                                shootEffect = Fx.shootBig;
                                smokeEffect = Fx.shootBigSmoke;
                                hitEffect = Fx.hitBulletSmall;
                                frontColor = MVPal.frontColorCyan;
                                backColor = MVPal.backColorCyan;
                            }};
                            shootSound = Sounds.shootBig;
                        }},
                    new Weapon("mechanical-warfare-revisit-viper-launcher-equip"){{
                        y = 3.5f;
                        x = 7f;
                        reload = 60f;
                        alternate = true;
                        shootCone = 50;
                        recoil = 2.3f;
                        shoot.shots = 3;
                        inaccuracy = 3;
                        ejectEffect = Fx.casing3;
                        bullet = new MissileBulletType(3.2f, 16){{
                            width = 9f;
                            height = 12f;
                            lifetime = 55f;
                            drag = -0.01f;
                            shootEffect = Fx.shootBig;
                            smokeEffect = Fx.shootBigSmoke;
                            hitEffect = Fx.blastExplosion;
                            frontColor = MVPal.frontColorCyan;
                            backColor = trailColor = MVPal.backColorCyan;
                            homingPower = 2;
                            homingRange = 120;
                        }};
                        shootSound = Sounds.missile;
                    }},
                    new Weapon("mechanical-warfare-revisit-viper-lasergun-equip"){{
                        y = 8f;
                        x = 7f;
                        reload = 90f;
                        alternate = false;
                        shootCone = 50;
                        recoil = 2f;
                        ejectEffect = Fx.none;
                        bullet = new LaserBulletType(){{
                            damage = 30f;
                            recoil = 1f;
                            lifetime = 25f;
                            sideAngle = 45f;
                            sideWidth = 1f;
                            sideLength = 55f;
                            collidesTeam = true;
                            length = 100f;
                            colors = new Color[]{MVPal.frontColorCyan.cpy().a(0.4f), MVPal.frontColorCyan, Color.white};
                        }};
                        shootSound = Sounds.shotgun;
                    }});
        }};
        bonker = new UnitType("bonker"){{
            speed = 2.3f;
            drag = 0.08f;
            flying = true;
            health = 580;
            engineOffset = 5.2f;
            engineSize = 0;
            constructor = UnitEntity::create;
            hitSize = 11;
            itemCapacity = 28;
            parts.add(new DrawRotor("rotor-blade-heal", 8f){{
                blur = true;
            }});

            weapons.add(new Weapon("mechanical-warfare-revisit-serpent-gun-equip"){{
                            y = 1f;
                            x = 2f;
                            layerOffset = -1f;
                            reload = 15f;
                            alternate = true;
                            recoil = 1.5f;
                            inaccuracy = 5;
                            ejectEffect = Fx.casing1;
                            bullet = new LaserBoltBulletType(8f, 5){{
                                width = 2f;
                                height = 5.5f;
                                backColor = frontColor = Pal.heal;
                                lifetime = 10f;
                                healPercent = 1f;
                                shootEffect = Fx.shootSmall;
                                smokeEffect = Fx.shootSmallSmoke;
                                hitEffect = Fx.hitBulletSmall;
                                collidesTeam = true;
                            }};
                            shootSound = Sounds.shootAlt;
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
                x = 9f;
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
        nullifier = new UnitType("nullifier"){{
            health = 18000f;
            armor = 10;
            speed = 0.2f;
            hitSize = 27f;
            rotateSpeed = 2f;
            canDrown = false;
            mechFrontSway = 1.9f;
            mechStepParticles = true;
            stepShake = 0.25f;
            mechSideSway = 0.6f;
            constructor = MechUnit::create;

            weapons.add(new Weapon("mechanical-warfare-revisit-null-pointer-equip"){{
                top = false;
                x = 30.25f;
                shootY = 21.5f;
                rotate = false;
                reload = 30f;
                recoil = 5f;
                shake = 2.2f;
                inaccuracy = 2f;
                shootSound = MVSounds.quakeShot;
                bullet = new BasicBulletType(6f, 700f, "shell"){{
                    lifetime = 75f;
                    width = height = 14f;
                    hitSize = 14f;
                    knockback = 3f;
                    backColor = Color.white;
                    frontColor = Color.black;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                }};
            }});
        }};
        mTron  = new UnitType("m-tron"){{
            speed = 0.31f;
            hitSize = 19f;
            rotateSpeed = 2f;
            targetAir = false;
            health = 1280;
            armor = 12f;
            mechFrontSway = 0.6f;
            ammoType = new PowerAmmoType(1200);
            constructor = MechUnit::create;

            weapons.add(new Weapon("mechanical-warfare-revisit-m-rifle-equip"){{
                top = false;
                y = 1f;
                x = 12f;
                reload = 50f;
                recoil = 4f;
                shake = 2f;
                shoot.shots = 3;
                shoot.shotDelay = 2;
                ejectEffect = Fx.casing3;
                shootSound = Sounds.missile;
                bullet = new BasicBulletType(3.5f, 32, "mechanical-warfare-revisit-energywave"){{
                    hitEffect = Fx.blastExplosion;
                    knockback = 0.8f;
                    lifetime = 40f;
                    width = 7f;
                    height = 18f;
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 5;
                    backColor = Color.valueOf("ddeeff");
                    frontColor = Color.valueOf("aabbcc");
                }};
            }});
        }};
        anarchy  = new UnitType("anarchy"){{
            speed = 0.16f;
            hitSize = 24f;
            rotateSpeed = 2f;
            targetAir = false;
            health = 7000;
            armor = 15f;
            mechFrontSway = 0.6f;
            ammoType = new PowerAmmoType(1200);
            constructor = MechUnit::create;

            weapons.add(new Weapon("mechanical-warfare-revisit-anarchy-blaster-equip"){{
                top = false;
                y = 15.1f;
                x = 20f;
                reload = 80f;
                recoil = 6f;
                shootY = 13.25f;
                shake = 3f;
                shoot.shots = 2;
                shoot.shotDelay = 0;
                ejectEffect = Fx.casing3;
                shootSound = Sounds.artillery;
                inaccuracy = 2;
                bullet = new BasicBulletType(8f, 150){{
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                    hitEffect = despawnEffect = MVFx.anarchyShellHit;
                    splashDamage = 100;
                    splashDamageRadius = 16;
                    knockback = 0.8f;
                    lifetime = 50f;
                    trailWidth = 4;
                    trailLength = 8;
                    width = 17f;
                    height = 22f;
                    backColor = MVPal.backColorCyan;
                    frontColor = trailColor = MVPal.frontColorCyan;
                }};
            }});
        }};
    }
}
