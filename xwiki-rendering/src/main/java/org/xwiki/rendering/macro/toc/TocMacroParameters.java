/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.macro.toc;

import org.xwiki.rendering.macro.descriptor.ParameterDescription;
import org.xwiki.rendering.macro.parameter.ParameterValueTooLowException;

/**
 * Parameters for the {@link org.xwiki.rendering.internal.macro.toc.TocMacro} Macro.
 * 
 * @version $Id: $
 * @since 1.6M1
 */
public class TocMacroParameters
{
    /**
     * @version $Id: TocMacroDescriptor.java 11982 2008-08-22 17:49:14Z tmortagne $
     */
    public enum Scope
    {
        /**
         * List section starting where macro block is located in the XDOM.
         */
        LOCAL,

        /**
         * List the sections of the whole page.
         */
        PAGE;
    };

    private int start = 2;

    private int depth = 6;

    private Scope scope = Scope.PAGE;

    private boolean numbered = false;

    /**
     * @param start the minimum section level. For example if 2 then level 1 sections will not be listed.
     * @throws ParameterValueTooLowException the provided value is too low, it needs to be >= 1.
     */
    @ParameterDescription("the minimum section level. For example if 2 then level 1 sections will not be listed")
    public void setStart(int start) throws ParameterValueTooLowException
    {
        if (start < 1) {
            throw new ParameterValueTooLowException(1);
        }

        this.start = start;
    }

    /**
     * @return the minimum section level. For example if 2 then level 1 sections will not be listed.
     */
    public int getStart()
    {
        return this.start;
    }

    /**
     * @param depth the maximum section level. For example if 3 then all section levels from 4 will not be listed.
     * @throws ParameterValueTooLowException the provided value is too low, it needs to be >= 1.
     */
    @ParameterDescription("the maximum section level. "
        + "For example if 3 then all section levels from 4 will not be listed")
    public void setDepth(int depth) throws ParameterValueTooLowException
    {
        if (depth < 1) {
            throw new ParameterValueTooLowException(1);
        }

        this.depth = depth;
    }

    /**
     * @return the maximum section level. For example if 3 then all section levels from 4 will not be listed.
     */
    public int getDepth()
    {
        return this.depth;
    }

    /**
     * @param scope If local only section in the current scope will be listed. For example if the macro is written in a
     *            section, only subsections of this section will be listed.
     */
    @ParameterDescription("if local only section in the current scope will be listed. "
        + "For example if the macro is written in a section, only subsections of this section will be listed")
    public void setScope(Scope scope)
    {
        this.scope = scope;
    }

    /**
     * @return if {@link Scope#LOCAL} only section in the current scope will be listed. For example if the macro is
     *         written in a section, only subsections of this section will be listed.
     */
    public Scope getScope()
    {
        return this.scope;
    }

    @ParameterDescription("if true the section title number is printed")
    public void setNumbered(boolean numbered)
    {
        this.numbered = numbered;
    }

    /**
     * @return if true the section title number is printed.
     */
    public boolean isNumbered()
    {
        return this.numbered;
    }
}
