package mvr.classes.defence.walls;

import mindustry.world.blocks.defense.Wall;

public class MWWall extends Wall {
    public float repairPower = 0.02f;
    public MWWall(String name) {
        super(name);
        update = true;
        buildType = MWWallBuild::new;
    }
    public class MWWallBuild extends WallBuild {
        @Override
        public void update(){
            if (this.damaged()){
                this.heal(repairPower);
            }
        }
    }
}
