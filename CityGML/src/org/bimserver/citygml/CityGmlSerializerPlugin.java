package org.bimserver.citygml;

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

import org.bimserver.emf.Schema;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.schema.SchemaException;
import org.bimserver.plugins.serializers.AbstractSerializerPlugin;
import org.bimserver.plugins.serializers.Serializer;

public class CityGmlSerializerPlugin extends AbstractSerializerPlugin {

	private boolean initialized = false;

	@Override
	public String getDescription() {
		return "CityGmlSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean needsGeometry() {
		return true;
	}
	
	@Override
	public void init(PluginManager pluginManager) throws SchemaException, PluginException, RenderEngineException {
		initialized = true;
	}
	
	public Serializer createSerializer(PluginConfiguration pluginConfiguration) {
		return new CityGmlSerializer();
	}

	@Override
	public String getDefaultName() {
		return "CityGML1.0.0";
	}

	@Override
	public String getDefaultContentType() {
		return "application/gml";
	}

	@Override
	public String getDefaultExtension() {
		return "gml";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return super.getSettingsDefinition();
	}
	
	@Override
	public Set<Schema> getSupportedSchemas() {
		return Schema.IFC2X3TC1.toSet();
	}
}