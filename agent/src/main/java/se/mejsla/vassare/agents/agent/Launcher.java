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

import com.sun.tools.attach.VirtualMachine;

import java.io.File;

public class Launcher {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.err.println("Usage: java -jar <jar-file> <agent jar-file> <pid> [message]");
            System.exit(1);
        }
        String agentJarFile = args[0];
        String jvmPid = args[1];
        String message = (args.length > 2) ? args[2] : "Hello!";

        File agentFile = new File(agentJarFile);

        System.out.println("Attaching agent to pid: " + jvmPid);
        VirtualMachine jvm = VirtualMachine.attach(jvmPid);
        jvm.loadAgent(agentFile.getAbsolutePath(), message);
        jvm.detach();
    }
}
