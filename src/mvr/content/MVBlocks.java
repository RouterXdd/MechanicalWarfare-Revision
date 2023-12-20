package mvr.content;

import arc.graphics.Color;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.units.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mvr.classes.defence.walls.InsulatorWall;
import mvr.classes.defence.walls.MWWall;
import mvr.classes.draw.BarDraw;
import mvr.graphics.*;
import mvr.classes.defence.turrets.*;

import static mindustry.type.ItemStack.*;
public class MVBlocks {
    public static Block
            //environment
            hillBlock, soil, obsidianRocks, obsidian, aluminumOre, ironOre, uraniumOre,
            //crafting
            scrapCompactor, steelCrucible, oilRefinery, chemicalStation,
            insulatingCompound, APShellAssembler, HEShellAssembler,
            //drills
            chemicalDrill,
            //defence
            steelWall, steelWallLarge, reinforcedWall, reinforcedWallLarge, insulatorWall, insulatorWallLarge,
            //turrets
            heatLasor, lobber, aegis, ghost, nighthawk, voltmeter, quake,
            //units
            airAlter, heliPlatform;
    public static void load(){
        soil = new Floor("soil"){{
            variants = 3;
        }};
        hillBlock = new StaticWall("hills"){{
            variants = 2;
        }};
        obsidian = new Floor("obsidian"){{
            variants = 3;
        }};
        obsidianRocks = new StaticWall("obsidian-rocks"){{
            variants = 2;
        }};
        ironOre = new OreBlock(MVRes.iron){{
            oreDefault = true;
            oreThreshold = 0.864f;
            oreScale = 24.904762f;
        }};
        aluminumOre = new OreBlock(MVRes.aluminium){{
            oreDefault = true;
            oreThreshold = 0.882f;
            oreScale = 25.380953f;
        }};
        uraniumOre = new OreBlock(MVRes.uranium){{
            oreDefault = true;
            oreThreshold = 0.9f;
            oreScale = 25.380953f;
        }};
        scrapCompactor = new GenericCrafter("scrap-compactor"){{
            requirements(Category.crafting, with(Items.copper, 75, Items.lead, 40,Items.silicon, 25));
            liquidCapacity = 60f;
            craftTime = 20f;
            outputItem = new ItemStack(MVRes.scrapPlate, 1);
            size = 2;
            health = 210;
            hasPower = true;
            craftEffect = Fx.producesmoke;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawPistons(){{
                        sinMag = 1f;
                    }}
            );

            consumeItem(Items.scrap, 2);
            consumePower(0.2f);
            //research spore-press
        }};
        steelCrucible = new GenericCrafter("steel-crucible"){{
            requirements(Category.crafting, with(Items.copper, 80, Items.lead, 60, Items.silicon, 40, MVRes.iron, 20));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(MVRes.steel, 2);
            craftTime = 60f;
            size = 2;
            hasPower = true;
            hasLiquids = false;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ececec")));
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(MVRes.iron, 3, Items.coal, 1));
            consumePower(1.25f);
            //research scrap-compactor
        }};
        oilRefinery = new GenericCrafter("oil-refinery"){{
            requirements(Category.crafting, with(Items.titanium, 80, Items.silicon, 70, Items.metaglass, 70, MVRes.steel, 60));

            outputItem = new ItemStack(MVRes.sulfur, 1);
            outputLiquid = new LiquidStack(MVRes.gas, 0.1f);
            craftTime = 60f;
            size = 2;
            hasPower = true;
            hasItems = true;

            consumeLiquid(Liquids.oil, 0.2f);
            consumePower(1.5f);
            //research coal-centrifuge
        }};
        chemicalStation = new GenericCrafter("chemical-station"){{
            requirements(Category.crafting, with(MVRes.iron, 80, MVRes.steel, 50, Items.silicon, 60, Items.metaglass, 60));
            outputLiquid = new LiquidStack(MVRes.acid, 15f / 60f);
            size = 4;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            rotate = false;
            solid = true;
            outputsLiquid = true;
            envEnabled = Env.any;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.water), new DrawLiquidTile(MVRes.acid){{drawLiquidLight = true;}}, new DrawDefault(), new DrawRegion("-top"));
            liquidCapacity = 60f;
            craftTime = 60;
            lightLiquid = MVRes.acid;

            consumePower(1f);
            consumeItem(MVRes.sulfur, 1);
            consumeLiquid(Liquids.water, 15f / 60f);
            //research oil-refinery
        }};
        insulatingCompound = new GenericCrafter("insulating-compound") {{
            requirements(Category.crafting, with(
                    Items.lead, 75,
                    Items.titanium, 50,
                    MVRes.uranium, 25,
                    Items.surgeAlloy, 50,
                    Items.plastanium, 30
            ));
            scaledHealth = 40;
            craftEffect = Fx.smoke;
            outputItems = with(MVRes.insulatorAlloy, 1);
            craftTime = 85f;
            size = 2;
            itemCapacity = 10;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawFrames(){{
                        frames = 4;
                        interval = 3f;
                        sine = false;
                    }},
                    new DrawFlame(){{
                        flameColor = MVPal.midColorCyan;
                        flameRadius = 4f;
                    }});

            consumePower(4.5f);
            consumeItems(with(Items.plastanium, 2, Items.surgeAlloy, 1));
            //research steel-crucible
        }};
        APShellAssembler = new GenericCrafter("ap-shell-assembler"){{
            requirements(Category.crafting, with(MVRes.iron, 120, Items.silicon, 75, Items.titanium, 80, MVRes.uranium, 40, Items.plastanium, 80));
            craftEffect = Fx.producesmoke;
            outputItem = new ItemStack(MVRes.apShell, 1);
            craftTime = 60f;
            size = 3;
            hasPower = true;
            itemCapacity = 20;
            drawer = new DrawMulti(new DrawDefault(), new BarDraw(){{
                y = -5;
            }}, new DrawRegion("-top"));

            consumePower(5f);
            consumeItems(with(Items.blastCompound, 2, MVRes.uranium, 5, Items.coal, 4));
            //research blast-mixer
        }};
        HEShellAssembler = new GenericCrafter("he-shell-assembler"){{
            requirements(Category.crafting, with(MVRes.iron, 120, Items.silicon, 75, Items.titanium, 80, MVRes.uranium, 40, Items.plastanium, 80));
            craftEffect = Fx.producesmoke;
            outputItem = new ItemStack(MVRes.heShell, 1);
            craftTime = 60f;
            size = 3;
            hasPower = true;
            itemCapacity = 20;
            drawer = new DrawMulti(new DrawDefault(), new BarDraw(){{
                x = -5;
                horizontal = true;
            }}, new DrawRegion("-top"));

            consumePower(5f);
            consumeItems(with(Items.blastCompound, 5, MVRes.steel, 2, Items.coal, 4));
            //research blast-mixer
        }};
        chemicalDrill = new Drill("chemical-drill"){{
            requirements(Category.production, with(MVRes.iron, 50, MVRes.steel, 70, Items.silicon, 60, Items.metaglass, 50, Items.titanium, 80));
            drillTime = 270;
            size = 3;
            drawRim = true;
            hasPower = true;
            tier = 6;
            updateEffect = Fx.pulverizeMedium;
            updateEffectChance = 0.03f;
            drillEffect = Fx.mineBig;
            rotateSpeed = 6f;
            warmupSpeed = 0.01f;
            itemCapacity = 14;
            heatColor =  Color.valueOf("b5d772");

            liquidBoostIntensity = 1.8f;

            consumePower(2f);
            consumeLiquid(MVRes.acid, 0.1f);
            consumeLiquid(Liquids.cryofluid, 0.2f).boost();
            //research blast-drill
        }};
        steelWall = new Wall("steel-wall"){{
            requirements(Category.defense, with(MVRes.steel, 6));
            health = 560;
            envDisabled |= Env.scorching;
            //research titanium-wall
        }};
        steelWallLarge = new Wall("steel-wall-large"){{
            requirements(Category.defense, with(MVRes.steel, 24));
            health = 560 * 4;
            size = 2;
            envDisabled |= Env.scorching;
        }};
        reinforcedWall = new MWWall("reinforced-wall"){{
            requirements(Category.defense, with(MVRes.iron, 6, Items.surgeAlloy, 4, MVRes.uranium, 3, Items.phaseFabric, 1));
            health = 1280;
            envDisabled |= Env.scorching;
            repairPower = 0.4f;
            //research surge-wall
        }};
        reinforcedWallLarge = new MWWall("reinforced-wall-large"){{
            requirements(Category.defense, with(MVRes.iron, 24, Items.surgeAlloy, 16, MVRes.uranium, 12, Items.phaseFabric, 4));
            health = 1280 * 4;
            envDisabled |= Env.scorching;
            repairPower = 0.4f * 4;
            size = 2;
        }};
        insulatorWall = new InsulatorWall("insulator-wall"){{
            requirements(Category.defense, with(MVRes.insulatorAlloy, 6));
            health = 1000;
            absorbLasers = true;
            envDisabled |= Env.scorching;
            //research plastanium-wall
        }};
        insulatorWallLarge = new InsulatorWall("insulator-wall-large"){{
            requirements(Category.defense, with(MVRes.insulatorAlloy, 6));
            health = 1000 * 4;
            size = 2;
            absorbLasers = true;
            envDisabled |= Env.scorching;
            powerProduction = 4;
            lightningMultiplier = 30;
        }};
        heatLasor = new TractorBeamTurret("incandescence"){{
            requirements(Category.turret, with(Items.lead, 160, Items.titanium, 120, Items.silicon, 120, MVRes.steel, 100));

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
        lobber = new ItemTurret("lobber"){{
            requirements(Category.turret, with(MVRes.scrapPlate, 35, Items.graphite, 20, Items.silicon, 20));
            ammo(
                    Items.scrap,  new ArtilleryBulletType(4f, 0){{
                        width = height = 12f;
                        lifetime = 60f;
                        ammoMultiplier = 2;
                        reloadMultiplier = 0.8f;
                        sprite = "shell";
                        hitSound = Sounds.explosion;
                        shrinkX = shrinkY = 0.3f;
                        splashDamage = 25;
                        splashDamageRadius = 16;
                        fragBullets = 3;
                        fragBullet = new BasicBulletType(4,12){{
                            width = height = 9f;
                            lifetime  = 20;
                            shrinkX = shrinkY = 1f;
                            drag = 0.1f;
                        }};
                    }},
                    Items.copper,  new ArtilleryBulletType(3f, 0){{
                        width = height = 13f;
                        lifetime = 80f;
                        ammoMultiplier = 2;
                        sprite = "shell";
                        hitSound = Sounds.explosion;
                        shrinkX = shrinkY = 0.3f;
                        splashDamage = 50;
                        splashDamageRadius = 16;
                    }},
                    Items.coal, new ArtilleryBulletType(2.6f, 0){{
                        width = height = 13f;
                        lifetime = 90f;
                        ammoMultiplier = 2;
                        reloadMultiplier = 0.8f;
                        sprite = "shell";
                        hitSound = Sounds.explosion;
                        shrinkX = shrinkY = 0.3f;
                        splashDamage = 50;
                        splashDamageRadius = 16;
                        status = StatusEffects.burning;
                        frontColor = Pal.lightishOrange;
                        backColor = Pal.lightOrange;
                        incendChance = 1;
                        incendAmount = 3;
                        incendSpread = 10;
                    }},
                    Items.silicon, new ArtilleryBulletType(3f, 0){{
                        width = height = 14f;
                        lifetime = 80f;
                        ammoMultiplier = 2;
                        sprite = "shell";
                        hitSound = Sounds.explosion;
                        shrinkX = shrinkY = 0.3f;
                        splashDamage = 50;
                        splashDamageRadius = 16;
                        homingPower = 2f;
                        homingRange = 50f;
                        reloadMultiplier = 1.2f;
                    }}
            );

            shoot = new ShootAlternate(3.5f);

            recoil = 0.5f;
            shootY = 6f;
            reload = 50f;
            range = 215;
            shootCone = 12f;
            ammoUseEffect = Fx.casing1;
            shootEffect = Fx.shootBig;
            smokeEffect = Fx.shootBigSmoke;
            shootSound = Sounds.artillery;
            health = 600;
            inaccuracy = 3f;
            rotateSpeed = 4.5f;
            coolant = consumeCoolant(0.2f);
            size = 2;

            limitRange();
            //research hail
        }};
        aegis = new BunkerTurret("aegis"){{
            requirements(Category.turret, with(Items.copper, 50, Items.lead, 50, MVRes.steel, 40));
            ammo(
                    MVRes.cobblestone,  new BasicBulletType(3.3f, 4){{
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
                    MVRes.iron,  new BasicBulletType(3.9f, 10){{
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
                    MVRes.uranium,  new BasicBulletType(4.8f, 20){{
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
            requirements(Category.turret, with(Items.plastanium, 75, MVRes.steel, 100, Items.surgeAlloy, 50, Items.graphite, 150, Items.thorium, 125));
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
                            shrinkX = shrinkY = 1;
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
                            shrinkX = shrinkY = 1;
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
                    MVRes.heShell, new FlakBulletType(13f, 125){{
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
            requirements(Category.turret, with(Items.copper, 180, Items.graphite, 100, Items.titanium, 125, MVRes.iron, 150));
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
                    MVRes.apShell, new BasicBulletType(14f, 140){{
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
        voltmeter = new TeslaTurret("voltmeter"){{
            requirements(Category.turret, with(Items.copper, 250, Items.lead, 225, MVRes.iron, 200, Items.silicon, 225, Items.surgeAlloy, 175));
            shootType = new LightningBulletType(){{
                damage = 50;
                lightningLength = 25;
                collidesAir = false;
                ammoMultiplier = 1f;

                //for visual stats only.
                buildingDamageMultiplier = 0.25f;

                lightningType = new BulletType(0.0001f, 0f){{
                    lifetime = Fx.lightning.lifetime;
                    hitEffect = Fx.hitLancer;
                    despawnEffect = Fx.none;
                    status = StatusEffects.shocked;
                    statusDuration = 10f;
                    hittable = false;
                    lightColor = Color.white;
                    buildingDamageMultiplier = 0.25f;
                }};
            }};
            shootY = 0;
            shoot.shots = 5;
            reload = 20f;
            shootCone = 360f;
            rotateSpeed = 10f;
            range = 140f;
            shootEffect = Fx.producesmoke;
            heatColor = Color.valueOf("a9d8ff");
            recoil = 0f;
            size = 3;
            health = 260;
            shootSound = MVSounds.voltmeterShot;
            smokeEffect = Fx.none;
            idleSound = MVSounds.voltmeterIdle;
            idleSoundVolume = 0.5f;
            activeSound = MVSounds.voltmeterActive;
            activeSoundVolume = 1;
            consumePower(10f);
            coolant = consumeCoolant(0.4f);
            //research incandescence / heatLasor
        }};
        quake = new ItemTurret("quake"){{
            requirements(Category.turret, with(MVRes.iron, 200, Items.graphite, 450, Items.plastanium, 250, Items.surgeAlloy, 250, MVRes.uranium, 300));
            ammo(
                    MVRes.heShell, new BasicBulletType(10f, 240){{
                        lifetime = 40f;
                        width = 17;
                        height = 22f;
                        ammoMultiplier = 2;
                        backColor = MVPal.backColorHE;
                        frontColor = MVPal.frontColorHE;
                        //TODO effects
                        hitEffect = despawnEffect = Fx.hitLancer;
                        splashDamage = 500;
                        splashDamageRadius = 40;
                        knockback = 3;
                        trailLength = 15;
                        trailWidth = 3;
                        trailColor = frontColor;
                        hitSound = Sounds.boom;
                    }},
                    MVRes.apShell, new BasicBulletType(10f, 2210){{
                        lifetime = 40f;
                        width = 17;
                        height = 22f;
                        ammoMultiplier = 2;
                        reloadMultiplier = 1.2f;
                        backColor = MVPal.backColorAP;
                        frontColor = MVPal.frontColorAP;
                        //TODO effects
                        hitEffect = despawnEffect = Fx.hitLancer;
                        splashDamage = 120;
                        splashDamageRadius = 10;
                        pierce = true;
                        pierceCap = 4;
                        knockback = 6;
                        trailLength = 15;
                        trailWidth = 3;
                        trailColor = frontColor;
                        hitSound = Sounds.boom;
                    }}
            );
            size = 4;
            reload = 420f;
            recoil = 6f;
            range = 360f;
            inaccuracy = 2f;
            shootCone = 5f;
            health = 2400;
            rotateSpeed = 3;
            shootSound = MVSounds.quakeShot;
            coolant = consumeCoolant(0.8f);
            //research ripple
        }};
        airAlter = new Reconstructor("fly-alter"){{
            requirements(Category.units, with(Items.copper, 260, Items.lead, 170, Items.silicon, 120, MVRes.iron, 95, MVRes.aluminium, 70));

            size = 3;
            consumePower(4f);
            consumeItems(with(Items.silicon, 52, MVRes.iron, 36, MVRes.steel, 20));

            constructTime = 60f * 20f;

            upgrades.addAll(
                    new UnitType[]{UnitTypes.mono, MVUnitTypes.bullhead},
                    new UnitType[]{UnitTypes.flare, MVUnitTypes.apparition},
                    new UnitType[]{UnitTypes.dagger, MVUnitTypes.serpent}
            );
            //research air-factlory
        }};
        heliPlatform = new Reconstructor("heli-platform"){{
            requirements(Category.units, with(Items.surgeAlloy, 175, Items.lead, 175, Items.titanium, 325, Items.silicon, 300, MVRes.iron, 200));

            size = 4;
            consumePower(5.5f);
            consumeItems(with(Items.silicon, 70, Items.titanium, 40, MVRes.steel, 35, Items.plastanium, 10));

            constructTime = 60f * 60f;
            squareSprite = false;

            upgrades.addAll(
                    new UnitType[]{MVUnitTypes.serpent, MVUnitTypes.viper}
            );
            //research air-alter
        }};
    }
}
