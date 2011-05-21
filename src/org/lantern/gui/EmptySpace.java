/*
 *  Copyright (C) 2010 mabe02
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.lantern.gui;

import org.lantern.gui.theme.Theme.Category;
import org.lantern.terminal.TerminalSize;

/**
 *
 * @author mabe02
 */
public class EmptySpace extends AbstractComponent
{
    private final TerminalSize size;

    public EmptySpace()
    {
        this(1, 1);
    }

    public EmptySpace(final int width, final int height)
    {
        this.size = new TerminalSize(width, height);
    }

    public TerminalSize getPreferredSize()
    {
        return size;
    }

    public void repaint(TextGraphics graphics)
    {
        graphics.applyThemeItem(Category.DefaultDialog);
        graphics.fillArea(' ');
    }
}