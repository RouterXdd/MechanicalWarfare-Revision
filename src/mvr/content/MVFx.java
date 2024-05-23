package mvr.content;

import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.*;
import arc.math.Rand;
import arc.math.geom.Vec2;
import mindustry.entities.Effect;
import mindustry.type.UnitType;
import mvr.classes.draw.MVDraw;
import mvr.graphics.MVPal;


public class MVFx {
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();

    public static final Effect
    teleportEffect = new Effect(48, e ->{
        if(!(e.data instanceof UnitType unit)) return;
        TextureRegion region = unit.region;
        Draw.color(Color.white);
        Draw.alpha(e.fout());
        Draw.rect(region, e.x, e.y, e.rotation - 90);
        Draw.color();
        Draw.blend();
    }),
    anarchyShellHit = new Effect(27, e ->{
        MVDraw.fillCircle(e.x, e.y, MVPal.backColorCyan, 0.2f + e.fin() * 0.8f, e.fout() * 16);

        e.scaled(4, i -> {
                var cThickness = i.fout() * 4;
        var cRadius = i.fin() * 20;
        MVDraw.outlineCircle(e.x, e.y, MVPal.frontColorCyan, cThickness, cRadius);
	});

        var lnThickness = e.fout() * 2;
        var lnDistance = 4 + e.fin() * 24;
        var lnLength = e.fout() * 5;
        MVDraw.splashLines(e.x, e.y, MVPal.frontColorCyan, lnThickness, lnDistance, lnLength, 10, e.id);

        var crRadius = e.fout() * 4;
        var crDistance = e.fin() * 6;
        MVDraw.splashCircles(e.x, e.y, Color.gray, 1, crRadius, crDistance, 4, e.id + 1);
    });
}
