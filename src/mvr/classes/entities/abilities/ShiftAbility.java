package mvr.classes.entities.abilities;

import arc.*;
import arc.math.*;
import arc.util.*;
import mindustry.entities.abilities.*;
import mindustry.gen.*;
import mvr.content.MVFx;

import static mindustry.Vars.*;

public class ShiftAbility extends Ability {
        public float reload, chance;
        public float reloading = 0;
        public ShiftAbility( float reload, float chance) {
            this.reload = reload;
            this.chance = chance;
        }
        @Override
        public void update(Unit u){
            //TODO somehow made this doing after take damage
            if (Mathf.chance(chance) && reloading <= 0 && u.damaged()){
                teleport(u);
                reloading = reload;
            } else {
                reloading -= Time.delta;
            }
        }
        void teleport(Unit u){
            float x = Angles.trnsx(u.rotation - 90, Mathf.randomSeed((long)(u.id + Time.time), 64) - 32, -Mathf.randomSeed((long)(u.id + Time.time) + 1, 80));
            float y = Angles.trnsy(u.rotation - 90, Mathf.randomSeed((long)(u.id + Time.time), 64) - 32, -Mathf.randomSeed((long)(u.id + Time.time) + 1, 80));
            MVFx.teleportEffect.at(u.x, u.y, u.rotation, u);
            u.set(u.x + x, u.y + y);
        }
}
