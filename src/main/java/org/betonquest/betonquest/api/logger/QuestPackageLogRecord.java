package org.betonquest.betonquest.api.logger;

import lombok.Getter;
import org.betonquest.betonquest.config.ConfigPackage;

import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Custom {@link LogRecord} for BetonQuest that adds a {@link ConfigPackage} name.
 */
public class QuestPackageLogRecord extends LogRecord {

    private static final long serialVersionUID = -7094531905051980356L;
    /**
     * The package name.
     * -- GETTER --
     * Gets the package name.
     *
     * @return Returns the package name.
     */
    @Getter
    private final String pack;

    /**
     * Sets the package and calls the original method {@link LogRecord#LogRecord(Level, String)}.
     *
     * @param pack  The {@link ConfigPackage} this LogRecord came from.
     * @param level A logging level value.
     * @param msg   The raw non-localized logging message (may be null).
     */
    public QuestPackageLogRecord(final ConfigPackage pack, final Level level, final String msg) {
        super(level, msg);
        this.pack = pack == null ? "" : pack.getName();
    }
}
