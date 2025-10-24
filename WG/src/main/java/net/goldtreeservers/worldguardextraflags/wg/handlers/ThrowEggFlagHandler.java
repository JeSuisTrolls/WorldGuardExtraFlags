package net.goldtreeservers.worldguardextraflags.wg.handlers;

import javax.annotation.Nullable;

import com.sk89q.worldedit.util.Location;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.session.MoveType;
import com.sk89q.worldguard.session.Session;
import com.sk89q.worldguard.session.handler.Handler;
import com.sk89q.worldguard.session.handler.FlagValueChangeHandler;

import net.goldtreeservers.worldguardextraflags.flags.Flags;

public class ThrowEggFlagHandler extends FlagValueChangeHandler<StateFlag.State> {

    public static ThrowEggFlagHandler.Factory FACTORY() {
        return new ThrowEggFlagHandler.Factory();
    }

    public static class Factory extends Handler.Factory<ThrowEggFlagHandler> {
        @Override
        public ThrowEggFlagHandler create(Session session) {
            return new ThrowEggFlagHandler(session, Flags.THROW_EGG);
        }
    }

    @Nullable
    private StateFlag.State throwEggState;

    protected ThrowEggFlagHandler(Session session, Flag<StateFlag.State> flag) {
        super(session, flag);
    }

    @Override
    protected void onInitialValue(LocalPlayer player, ApplicableRegionSet set, StateFlag.State value) {
        this.updateState(value);
    }

    @Override
    protected boolean onSetValue(LocalPlayer player, Location from, Location to, ApplicableRegionSet toSet,
                                 StateFlag.State currentValue, StateFlag.State lastValue, MoveType moveType) {
        this.updateState(currentValue);
        return true;
    }

    @Override
    protected boolean onAbsentValue(LocalPlayer player, Location from, Location to, ApplicableRegionSet toSet,
                                    StateFlag.State lastValue, MoveType moveType) {
        this.updateState(null);
        return true;
    }

    private void updateState(@Nullable StateFlag.State state) {
        this.throwEggState = state;
    }

    @Nullable
    public StateFlag.State getThrowEgg(LocalPlayer player) {
        return this.throwEggState;
    }
}
