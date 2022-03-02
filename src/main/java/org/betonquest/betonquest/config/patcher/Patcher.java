package org.betonquest.betonquest.config.patcher;

import org.betonquest.betonquest.utils.versioning.Version;
import org.bukkit.configuration.ConfigurationSection;

public interface Patcher {

    void patch(final Version configVersion, final ConfigurationSection config);
}
