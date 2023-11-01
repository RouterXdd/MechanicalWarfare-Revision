package mvr.classes.defence.turrets;

import arc.*;
import arc.graphics.g2d.*;
import mindustry.graphics.*;
import mindustry.world.blocks.defense.turrets.*;


public class BunkerTurret extends ItemTurret {
    TextureRegion heatRegion;
    TextureRegion bottomRegion;
    TextureRegion topRegion;
    TextureRegion outlineRegion;
    TextureRegion bottomOutline;
    TextureRegion topOutline;
    TextureRegion baseRegion;
    String postfix = "2";
    String prefix = "";
    public BunkerTurret(String name) {
        super(name);
        buildType = BunkerTurretBuild::new;
    }
    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{baseRegion, Core.atlas.find(this.name + "-icon")};
    }
    @Override
    public void load(){
        super.load();
        heatRegion = Core.atlas.find(this.name + "-heat");
        bottomRegion = Core.atlas.find(this.name + "-bottom");
        topRegion = Core.atlas.find(this.name + "-top2");
        outlineRegion = Core.atlas.find(this.name + "-outline");
        bottomOutline = Core.atlas.find(this.name + "-bottom-outline");
        topOutline = Core.atlas.find(this.name + "-top-outline");
        baseRegion = Core.atlas.find(prefix + "block-" + postfix);
    }
    public class BunkerTurretBuild extends ItemTurretBuild {
        @Override
        public void drawCracks(){}

        public void drawDefaultCracks(){
            super.drawCracks();
        }
        @Override
        public void draw(){
            super.draw();
            Draw.rect(topRegion, tile.drawx(), tile.drawy(), 0);
            Draw.z(Layer.blockAfterCracks);
            Draw.rect(bottomOutline, tile.drawx(), tile.drawy(), 0);
            Draw.rect(bottomRegion, tile.drawx(), tile.drawy(), 0);
            Draw.z(Layer.blockCracks);
            drawDefaultCracks();
        }
    }
}
