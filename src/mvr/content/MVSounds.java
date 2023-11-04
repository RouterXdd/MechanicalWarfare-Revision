package mvr.content;

import arc.audio.*;
import mindustry.*;

public class MVSounds {
    public static Sound
            heatrayActive,
            voltmeterIdle,
            voltmeterActive,
            voltmeterShot;
    public static void load() {
        heatrayActive = Vars.tree.loadSound("heatrayActive");
        voltmeterIdle = Vars.tree.loadSound("voltmeterIdle");
        voltmeterActive = Vars.tree.loadSound("voltmeterActive");
        voltmeterShot = Vars.tree.loadSound("voltmeterShot");
    }
}
