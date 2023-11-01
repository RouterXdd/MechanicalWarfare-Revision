package mvr.content;

import arc.graphics.*;
import mindustry.type.*;

public class MVItems {
    public static Item scrapPlate, cobblestone, aluminium, uranium, iron, steel,
            apShell, heShell;
    public static void load(){
        scrapPlate = new Item("scrap-plate", Color.valueOf("e0b28d")){{
            hardness = 1;
            cost = 1f;
        }};
        cobblestone = new Item("cobblestone", Color.valueOf("6b6b77")){{
            hardness = 1;
            cost = 1f;
        }};
        aluminium = new Item("aluminum", Color.valueOf("ff7f8a")){{
            hardness = 4;
            cost = 2f;
        }};
        uranium = new Item("uranium", Color.valueOf("309926")){{
            hardness = 6;
            cost = 1.2f;
            explosiveness = 0.3f;
            radioactivity = 1.7f;
        }};
        iron = new Item("iron", Color.valueOf("cce7ff")){{
            hardness = 3;
            cost = 1f;
        }};
        steel = new Item("steel", Color.valueOf("aeaeae")){{
            hardness = 1;
            cost = 3f;
        }};
        apShell = new Item("ap-shell", Color.valueOf("c9e75f")){{
            explosiveness = 0.6f;
        }};
        heShell = new Item("he-shell", Color.valueOf("f3885e")){{
            explosiveness = 1.8f;
        }};
    }
}
