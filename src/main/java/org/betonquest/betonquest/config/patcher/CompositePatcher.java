package org.betonquest.betonquest.config.patcher;

import org.betonquest.betonquest.utils.versioning.Version;
import org.bukkit.configuration.ConfigurationSection;

import java.util.Arrays;
import java.util.List;

public class CompositePatcher implements Patcher {

    private final List<Patcher> childPatchers;

    public CompositePatcher(final List<Patcher> childPatchers) {
        this.childPatchers = childPatchers;
    }

    public CompositePatcher(final Patcher... patchers) {
        this(Arrays.asList(patchers));
    }

    @Override
    public void patch(final Version configVersion, final ConfigurationSection config) {
        childPatchers.forEach(patcher -> patcher.patch(configVersion, config));
    }
}
