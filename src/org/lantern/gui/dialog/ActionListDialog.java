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

package org.lantern.gui.dialog;

import org.lantern.LanternException;
import org.lantern.gui.Action;
import org.lantern.gui.ActionListBox;
import org.lantern.gui.Border.Invisible;
import org.lantern.gui.Button;
import org.lantern.gui.GUIScreen;
import org.lantern.gui.Label;
import org.lantern.gui.Panel;
import org.lantern.gui.Window;

/**
 *
 * @author mabe02
 */
public class ActionListDialog extends Window
{
    private final ActionListBox actionListBox;

    private ActionListDialog(String title, String description, int forceWidth)
    {
        super(title);
        addComponent(new Label(description));
        actionListBox = new ActionListBox(forceWidth);
        addComponent(actionListBox);
        Panel cancelPanel = new Panel(new Invisible(), Panel.Orientation.HORISONTAL);
        cancelPanel.addComponent(new Label("                "));
        cancelPanel.addComponent(new Button("Close", new Action() {
            public void doAction()
            {
                close();
            }
        }));
        addComponent(cancelPanel);
    }

    private void addItem(final ActionListBox.Item actionItem)
    {
        actionListBox.addItem(new ActionListBox.Item() {
            public String getTitle()
            {
                return actionItem.getTitle();
            }

            public void doAction() throws LanternException
            {
                actionItem.doAction();
                close();
            }
        });
    }

    public static void showActionListDialog(GUIScreen owner, String title, String description, ActionListBox.Item... items) throws LanternException
    {
        int maxLength = 0;
        for(ActionListBox.Item item: items)
            if(item.getTitle().length() > maxLength)
                maxLength = item.getTitle().length();
        
        showActionListDialog(owner, title, description, maxLength, items);
    }

    public static void showActionListDialog(GUIScreen owner, String title, String description, int itemWidth, ActionListBox.Item... items) throws LanternException
    {
        ActionListDialog actionListDialog = new ActionListDialog(title, description, itemWidth);
        for(ActionListBox.Item item: items)
            actionListDialog.addItem(item);
        owner.showWindow(actionListDialog, GUIScreen.Position.CENTER);
    }
}