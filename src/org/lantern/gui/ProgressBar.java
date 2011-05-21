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
import org.lantern.terminal.ACS;
import org.lantern.terminal.TerminalPosition;
import org.lantern.terminal.TerminalSize;

/**
 *
 * @author mabe02
 */
public class ProgressBar extends AbstractComponent
{
    private final int preferredWidth;
    private double progress;

    public ProgressBar(int preferredWidth)
    {
        this.preferredWidth = preferredWidth;
        this.progress = 0.0;
    }

    public TerminalSize getPreferredSize()
    {
        return new TerminalSize(preferredWidth, 1);
    }

    public void repaint(TextGraphics graphics)
    {
        int totalWidth = graphics.getWidth();
        int highlightedBlocks = (int)(totalWidth * progress);
        graphics.applyThemeItem(Category.ItemSelected);
        graphics.fillRectangle(ACS.BLOCK_SOLID, new TerminalPosition(0, 0), new TerminalSize(highlightedBlocks, 1));
        graphics.applyThemeItem(Category.Item);
        graphics.fillRectangle(ACS.BLOCK_SOLID, new TerminalPosition(highlightedBlocks, 0), new TerminalSize(totalWidth - highlightedBlocks, 1));
    }

    public double getProgress()
    {
        return progress;
    }

    public void setProgress(double progress)
    {
        this.progress = progress;
    }
}