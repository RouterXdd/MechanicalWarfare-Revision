package mvr.classes.defence.turrets;

import arc.*;
import arc.audio.Sound;
import arc.graphics.g2d.*;
import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.world.Tile;
import mindustry.world.blocks.defense.turrets.*;

public class TeslaTurret extends PowerTurret {
    public TextureRegion flameRegion;
    public TextureRegion bottomRegion;
    public TextureRegion bottomHeatRegion;
    public TextureRegion[] boltRegion;
    public TextureRegion[] lampRegion;
    TextureRegion baseRegion;
    String postfix = "3";
    String prefix = "";
    public int boltFrames = 6;
    public int lampFrames = 3;
    public float idleSoundVolume = 1;
    public float activeSoundVolume = 1;
    public Sound idleSound;
    public Sound activeSound;
    public boolean sine = false;

    public TeslaTurret(String name) {
        super(name);
    }
    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{baseRegion,bottomRegion};
    }
    public void load(){
        super.load();
        boltRegion = new TextureRegion[boltFrames];
        for(int i = 0; i < boltFrames; i++){
            boltRegion[i] = Core.atlas.find(this.name + "-bolt" + i);
        }
        lampRegion = new TextureRegion[lampFrames];
        for(int i = 0; i < lampFrames; i++){
            lampRegion[i] = Core.atlas.find(this.name + "-lamp" + i);
        }
        flameRegion = Core.atlas.find(this.name + "-flame");
        bottomRegion = Core.atlas.find(this.name + "-bottom");
        bottomHeatRegion = Core.atlas.find(this.name + "-heat-bottom");
        baseRegion = Core.atlas.find(prefix + "block-" + postfix);
    }
    public class TeslaTurretBuild extends PowerTurretBuild {
        @Override
        public void drawCracks(){}

        public void drawDefaultCracks(){
            super.drawCracks();
        }
        /*@Override
        public void updateTile(){
            if (heat >= 0.5f){
                activeSound.at(this.x, this.y, 0, activeSoundVolume);
            } else {
                idleSound.at(this.x, this.y, 0, idleSoundVolume);
            }
        }*/

        @Override
        public void draw(){
            super.draw();
            Draw.z(Layer.blockAfterCracks);
            Draw.rect(bottomRegion, tile.drawx(), tile.drawy(), 0);
            if (efficiency() > 0 && lampRegion != null){
                Draw.mixcol(Pal.lancerLaser, 1);
                Draw.rect(
                        sine ?
                                lampRegion[(int)Mathf.absin(totalProgress(), 15, lampFrames - 0.001f)] :
                                lampRegion[(int)((totalProgress() / 15) % lampFrames)],
                        tile.drawx(), tile.drawy());
                Draw.mixcol();
                Draw.reset();
            }
            if (heat >= 0.11){
                Draw.alpha(heat);
                Draw.mixcol(Pal.lancerLaser, 0.7f);
                Draw.rect(flameRegion, tile.drawx(), tile.drawy(), 0);
                Draw.mixcol();
                Draw.reset();
            }
            if (heat >= 0.000001){
                Draw.alpha(heat);
                Draw.mixcol(heatColor, 0.8f);
                Draw.rect(bottomHeatRegion, tile.drawx(), tile.drawy(), 0);
                Draw.reset();
            }
            if (isShooting()){
                Draw.rect(
                        sine ?
                                boltRegion[(int)Mathf.absin(totalProgress(), 4, boltFrames - 0.001f)] :
                                boltRegion[(int)((totalProgress() / 4) % boltFrames)],
                        tile.drawx(), tile.drawy(), Mathf.random(0, 360));
                Draw.reset();
            }

            Draw.z(Layer.blockCracks);
            drawDefaultCracks();
        }
    }
}
