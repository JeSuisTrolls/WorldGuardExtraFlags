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

public class ArrowDamageForPlayersFlagHandler extends FlagValueChangeHandler<StateFlag.State> {

    public static ArrowDamageForPlayersFlagHandler.Factory FACTORY() {
        return new ArrowDamageForPlayersFlagHandler.Factory();
    }

    public static class Factory extends Handler.Factory<ArrowDamageForPlayersFlagHandler> {
        @Override
        public ArrowDamageForPlayersFlagHandler create(Session session) {
            return new ArrowDamageForPlayersFlagHandler(session, Flags.ARROW_DAMAGE_FOR_PLAYERS);
        }
    }

    @Nullable
    private StateFlag.State ArrowDamageForPlayersState;

    protected ArrowDamageForPlayersFlagHandler(Session session, Flag<StateFlag.State> flag) {
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
        this.ArrowDamageForPlayersState = state;
    }

    @Nullable
    public StateFlag.State getArrowDamageForPlayersState(LocalPlayer player) {
        return this.ArrowDamageForPlayersState;
    }
}
