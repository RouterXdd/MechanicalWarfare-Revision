package mvr.classes.entities.units;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import mindustry.game.Team;
import mindustry.gen.Unit;
import mindustry.graphics.Layer;
import mindustry.type.*;
import mvr.content.MVStatuses;

public class HideUnitType extends UnitType {
    public HideUnitType(String name) {
        super(name);
    }
    @Override
    public void update(Unit u){
        targetable = u.hasEffect(MVStatuses.detected) || u.isShooting();
    }
}
