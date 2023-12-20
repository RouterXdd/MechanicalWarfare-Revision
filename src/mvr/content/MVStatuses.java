package mvr.content;

import arc.graphics.*;
import arc.math.*;
import mindustry.Vars;
import mindustry.content.*;
import mindustry.type.*;

import static mindustry.content.StatusEffects.*;

public class MVStatuses {
    public static StatusEffect
            ultraMelting, detected;
    public static void load() {
        ultraMelting = new StatusEffect("meltingPlus"){{
            color = Color.valueOf("ffa166");
            speedMultiplier = 0.25f;
            reloadMultiplier = 0.25f;
            healthMultiplier = 0.8f;
            damage = 0.5f;
            effect = Fx.melting;

            init(() -> {
                opposite(wet, freezing);
                affinity(tarred, (unit, result, time) -> {
                    unit.damagePierce(8f);
                    Fx.burning.at(unit.x + Mathf.range(unit.bounds() / 2f), unit.y + Mathf.range(unit.bounds() / 2f));
                    result.set(melting, Math.min(time + result.time, 200f));
                });
            });
        }};
        detected = new StatusEffect("detected"){{
            color = Color.gray;
        }};
    }
}
