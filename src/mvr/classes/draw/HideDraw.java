package mvr.classes.draw;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import mindustry.entities.part.*;
import mindustry.gen.Unit;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;
import mvr.content.MVStatuses;

public class HideDraw extends DrawPart {
    TextureRegion hideRegion;

    public HideDraw(){
        super();
    }
    @Override
    public void load(String name){
        hideRegion = Core.atlas.find("mechanical-warfare-revisit-" + "apparition" + "-hide");
    }
    @Override
    public void draw(PartParams params){
        if (params.warmup < 0.000000001f){
            Draw.z(Layer.flyingUnit + 0.00021f);
            Draw.rect(hideRegion, params.x, params.y, 0);
            Draw.reset();
        }
    }
}
