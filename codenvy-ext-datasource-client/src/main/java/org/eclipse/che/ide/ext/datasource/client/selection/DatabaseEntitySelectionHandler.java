/*******************************************************************************
 * Copyright (c) 2012-2015 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.ext.datasource.client.selection;

import com.google.gwt.event.shared.EventHandler;

/**
 * Handler interface for database entity selection events.
 * 
 * @author "Mickaël Leduque"
 */
public interface DatabaseEntitySelectionHandler extends EventHandler {

    /**
     * Called when {@link DatabaseEntitySelectionEvent} is fired.
     * 
     * @param event the {@link DatabaseEntitySelectionEvent} that was fired
     */
    void onDatabaseEntitySelection(DatabaseEntitySelectionEvent event);
}
