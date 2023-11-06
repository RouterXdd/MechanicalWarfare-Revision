package mvr.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.type.*;

public class MVRes {
    public static Item scrapPlate, cobblestone, aluminium, uranium, sulfur, iron, steel, insulatorAlloy, coil, mk2module,
            apShell, heShell;
    public static Liquid acid, gas, lava;
    public static void load(){
        scrapPlate = new Item("scrap-plate", Color.valueOf("e0b28d")){{
            hardness = 1;
            cost = 1f;
        }};
        cobblestone = new Item("cobblestone", Color.valueOf("6b6b77")){{
            hardness = 1;
            cost = 1f;
        }};
        aluminium = new Item("aluminum", Color.valueOf("db4555")){{
            hardness = 4;
            cost = 2f;
        }};
        uranium = new Item("uranium", Color.valueOf("309926")){{
            hardness = 6;
            cost = 1.2f;
            explosiveness = 0.3f;
            radioactivity = 1.7f;
        }};
        sulfur = new Item("sulfur", Color.valueOf("cfcc5a")){{
            hardness = 1;
            explosiveness = 0.2f;
            flammability = 1.2f;
        }};
        iron = new Item("iron", Color.valueOf("cce7ff")){{
            hardness = 3;
            cost = 1f;
        }};
        steel = new Item("steel", Color.valueOf("aeaeae")){{
            hardness = 1;
            cost = 3f;
        }};
        insulatorAlloy = new Item("insulator-alloy", Color.valueOf("87ceeb")){{
            hardness = 1;
            cost = 4f;
        }};
        coil = new Item("coil", Color.valueOf("ff9c5a")){{
            hardness = 1;
            cost = 1.3f;
        }};
        mk2module = new Item("mk2-module", Color.valueOf("6cd9b5")){{
            hardness = 1;
            cost = 5f;
        }};
        apShell = new Item("ap-shell", Color.valueOf("c9e75f")){{
            explosiveness = 0.6f;
        }};
        heShell = new Item("he-shell", Color.valueOf("f3885e")){{
            explosiveness = 1.8f;
        }};
        acid = new Liquid("acid", Color.valueOf("c9eb86")){{
            temperature = 0.6f;
            viscosity = 0.8f;
            effect = StatusEffects.corroded;
        }};
        gas = new Liquid("gas", Color.valueOf("b33eb3")){{
            temperature = 1.25f;
            explosiveness = 1f;
            viscosity = 1f;
            gas = true;
        }};
        lava = new Liquid("lava", Color.valueOf("d95f34")){{
            temperature = 1.4f;
            viscosity = 0.9f;
            effect = MVStatuses.ultraMelting;
        }};
    }
}
