package mvr.classes.draw;

import arc.*;
import arc.graphics.g2d.*;
import arc.math.Mathf;
import arc.util.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.draw.*;

public class BarDraw extends DrawBlock {
    public TextureRegion region;
    public String suffix = "-bar";
    public float mag = 10;
    public float scl = 3;
    public boolean horizontal = false;
    public boolean drawPlan = true;
    public boolean buildingRotate = false;
    public float rotateSpeed, x, y, rotation;
    /** Any number <=0 disables layer changes. */
    public float layer = -1;

    public BarDraw(String suffix){
        this.suffix = suffix;
    }

    public BarDraw(String suffix, float rotateSpeed){
        this.suffix = suffix;
        this.rotateSpeed = rotateSpeed;
    }

    public BarDraw(String suffix, float rotateSpeed, boolean horizontal){
        this.suffix = suffix;
        this.horizontal = horizontal;
        this.rotateSpeed = rotateSpeed;
    }

    public BarDraw(){
    }

    @Override
    public void draw(Building build){
        float z = Draw.z();
        if(layer > 0) Draw.z(layer);
        if(horizontal){
            Draw.rect(region, build.x + x + Mathf.absin(build.totalProgress(), scl, mag) * build.warmup(), build.y + y, rotation);
        }else{
            Draw.rect(region, build.x + x, build.y + y + Mathf.absin(build.totalProgress(), scl, mag) * build.warmup(), rotation);
        }
        Draw.z(z);
    }

    @Override
    public void drawPlan(Block block, BuildPlan plan, Eachable<BuildPlan> list){
        if(!drawPlan) return;
        Draw.rect(region, plan.drawx(), plan.drawy(), (buildingRotate ? plan.rotation * 90f : 0));
    }

    @Override
    public TextureRegion[] icons(Block block){
        return new TextureRegion[]{region};
    }

    @Override
    public void load(Block block){
        region = Core.atlas.find(block.name + suffix);
    }
}
