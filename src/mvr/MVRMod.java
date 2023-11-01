package mvr;

import arc.*;
import arc.util.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import mvr.content.*;

public class MVRMod extends Mod{

    public MVRMod(){
        Log.info("Loaded ExampleJavaMod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Warn");
                dialog.cont.add("This mod in development \n Some content may be removed or changed").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("mechanical-warfare-revisit-icon")).pad(10f).row();
                dialog.cont.button("Okay", dialog::hide).size(70f, 30f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        MVStatuses.load();
        MVSounds.load();
        MVItems.load();
        MVUnitTypes.load();
        MVBlocks.load();
    }

}
