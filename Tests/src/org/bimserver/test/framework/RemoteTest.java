package org.bimserver.test.framework;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;

import org.bimserver.plugins.OptionsParser;
import org.bimserver.test.framework.RandomBimServerClientFactory.Type;
import org.bimserver.test.framework.actions.AllActionsFactory;

public class RemoteTest {
	public static void main(String[] args) {
		TestConfiguration testConfiguration = new TestConfiguration();
		TestFramework testFramework = new TestFramework(testConfiguration, new OptionsParser(args).getPluginDirectories());

		testConfiguration.setHomeDir(new File("/opt/bimservertest"));
		testConfiguration.setActionFactory(new AllActionsFactory(testFramework));
		testConfiguration.setBimServerClientFactory(new RandomBimServerClientFactory(testFramework, Type.values()));
		testConfiguration.setTestFileProvider(new FolderWalker(new File("/mnt/sata1/ifcselected"), testFramework));
		testConfiguration.setOutputFolder(new File("/opt/output"));
		testConfiguration.setNrVirtualUsers(4);
		
		testFramework.start();
	}
}
