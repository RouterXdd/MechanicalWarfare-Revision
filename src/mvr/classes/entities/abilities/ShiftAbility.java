package mvr.classes.entities.abilities;

import arc.*;
import arc.math.*;
import arc.util.*;
import mindustry.entities.abilities.*;
import mindustry.gen.*;

import static mindustry.Vars.*;

public class ShiftAbility extends Ability {
        public float reload, chance;
        public float minShift = -10;
        public float maxShift = 10;
        public float reloading = 0;
        public float shiftX;
        public float shiftY;
        public ShiftAbility( float reload, float chance) {
            this.reload = reload;
            this.chance = chance;
        }

        @Override
        public String localized() {
            return Core.bundle.format("ability.shiftAbility", reload, chance);
        }
        @Override
        public void update(Unit u){
            if (reloading >= 0){
                reloading = reload - Time.delta;
            }
            if (Mathf.chance(chance) && reloading <= 0 && u.damaged()){
                shiftX = Mathf.random(minShift, maxShift);
                shiftY = Mathf.random(minShift, maxShift);
                u.move(shiftX, shiftY);
                reloading = reload;
            }
        }
}
