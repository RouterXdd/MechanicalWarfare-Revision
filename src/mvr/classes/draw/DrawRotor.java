package mvr.classes.draw;

import arc.Core;
import arc.graphics.g2d.*;
import arc.util.Time;
import mindustry.Vars;
import mindustry.entities.part.*;
import mindustry.graphics.Drawf;

public class DrawRotor extends DrawPart {
    TextureRegion rotor;
    TextureRegion rotorOutline;
    public String rotorName;
    public float rotateSpeed;
    public float rotation = 0;
    public DrawRotor(String rotorName, float rotateSpeed){
        this.rotorName = rotorName;
        this.rotateSpeed = rotateSpeed;
    }
    @Override
    public void draw(PartParams params) {
        if(!Vars.state.isPaused()) {
            Drawf.spinSprite(rotor, params.x, params.y, rotation += Time.delta * rotateSpeed);
            Draw.rect(rotorOutline, params.x, params.y, rotation += Time.delta * rotateSpeed);
        }else{
            Drawf.spinSprite(rotor, params.x, params.y, rotation);
            Draw.rect(rotorOutline, params.x, params.y, rotation);
        }
    }

    @Override
    public void load(String name) {
        rotor = Core.atlas.find("mechanical-warfare-revisit-" + rotorName);
        rotorOutline = Core.atlas.find("mechanical-warfare-revisit-" + rotorName + "-outline");
    }
}
