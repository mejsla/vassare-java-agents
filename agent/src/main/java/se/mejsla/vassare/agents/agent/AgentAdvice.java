/*
 * Copyright (C) 2020 Johan Dykstrom
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package se.mejsla.vassare.agents.agent;

import net.bytebuddy.asm.Advice;

@SuppressWarnings("unused")
public class AgentAdvice {

    public static long start;

    @Advice.OnMethodEnter
    static void onEnter() {
        System.out.println("-->");
        start = System.currentTimeMillis();
    }

    @Advice.OnMethodExit
    static void onExit() {
        long stop = System.currentTimeMillis();
        System.out.println("<-- execution time: " + (stop - start) + " ms");
    }
}
