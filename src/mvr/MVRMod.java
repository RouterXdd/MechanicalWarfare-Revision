package mvr;

import arc.*;
import arc.util.*;
import mindustry.Vars;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import mvr.content.*;

public class MVRMod extends Mod{

    public MVRMod(){
        Events.on(ClientLoadEvent.class, e -> {

            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Warn");
                dialog.cont.add("This mod in development \n Some content may be removed or changed").row();
                dialog.cont.image(Core.atlas.find("mechanical-warfare-revisit-icon")).pad(8f).row();
                dialog.cont.button("Okay", dialog::hide).size(110f, 45f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        MVStatuses.load();
        MVSounds.load();
        MVRes.load();
        MVUnitTypes.load();
        MVBlocks.load();
    }

}
