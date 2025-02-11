package org.bimserver.charting;

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

import java.util.Set;

import org.bimserver.charting.ColorScales.LinearColorScale;
import org.bimserver.emf.Schema;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;

public class IfcClassificationPackingChartSerializerPlugin extends AbstractSerializerPlugin {

	private boolean initialized = false;

	@Override
	public Serializer createSerializer(PluginConfiguration plugin) {
		ClassificationPackingChartSerializer serializer = new ClassificationPackingChartSerializer();
		serializer.title = getDefaultName();
		serializer.addOption("Padding", 3);
		serializer.addOption("Color Scale", new LinearColorScale());
		serializer.addOption("Include Classification System", true);
		return serializer;
	}

	@Override
	public boolean needsGeometry() {
		return false;
	}

	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC2X3TC1.toSet();
	}

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "IFC Classification Circle Packing by Count Chart (SVG)";
	}

	@Override
	public String getDefaultName() {
		return "IFC Classification Circle Packing Chart";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getDefaultExtension() {
		return "svg";
	}

	@Override
	public String getDefaultContentType() {
		return "application/svg";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return super.getSettingsDefinition();
	}
}
