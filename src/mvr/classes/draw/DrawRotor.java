package mvr.classes.draw;

import arc.Core;
import arc.graphics.g2d.*;
import arc.math.Mathf;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.entities.part.*;
import mindustry.graphics.Drawf;
import mindustry.type.UnitType;
import mvr.classes.MVAnnotations;

public class DrawRotor extends DrawPart {
    TextureRegion rotor;
    TextureRegion blurRotor;
    TextureRegion rotorOutline;
    TextureRegion rotorTop;
    public String rotorName;
    public float rotateSpeed;
    public float rotation = 0;
    public boolean blur;
    public int x, y = 0;
    public DrawRotor(String rotorName, float rotateSpeed){
        this.rotorName = rotorName;
        this.rotateSpeed = rotateSpeed;
    }
    @Override
    public void draw(PartParams params) {
        int i = params.sideOverride == -1 ? 0 : params.sideOverride;
        float sign = (i == 0 ? 1 : -1) * params.sideMultiplier;
        Tmp.v1.set(x * sign, y).rotateRadExact((params.rotation - 90) * Mathf.degRad);
        float
                tx = params.x + Tmp.v1.x,
                ty = params.y + Tmp.v1.y;
        if (!blur) {
            if (!Vars.state.isPaused()) {
                rotation = Time.time * rotateSpeed;
                Drawf.spinSprite(rotor, tx, ty, Time.time * rotateSpeed);
                Draw.rect(rotorOutline, tx, ty, Time.time * rotateSpeed);
            } else {
                Drawf.spinSprite(rotor, tx, ty, rotation);
                Draw.rect(rotorOutline, tx, ty, rotation);
            }
        } else {
            if (!Vars.state.isPaused()) {
                rotation = Time.time * rotateSpeed;
                Drawf.spinSprite(blurRotor, tx, ty, Time.time * rotateSpeed);
            } else {
                Drawf.spinSprite(blurRotor, tx, ty, rotation);
            }
        }
        Draw.rect(rotorTop, tx, ty, params.rotation - 90);
    }

    @Override
    public void load(String name) {
        rotor = Core.atlas.find("mechanical-warfare-revisit-" + rotorName);
        rotorTop = Core.atlas.find("mechanical-warfare-revisit-" + rotorName + "-top");
        blurRotor = Core.atlas.find("mechanical-warfare-revisit-" + rotorName + "-blur");
        rotorOutline = Core.atlas.find("mechanical-warfare-revisit-" + rotorName + "-outline");
    }
}
