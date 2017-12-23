/**
 * Copyright 2013 Dennis Ippel
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.rajawali3d.renderer.plugins;


/**
 * Plugin interface for the Renderer for applying scenewide rendering
 * postprocessing effects.
 * @author Andrew Jo
 */
public interface IRendererPlugin {
	public void destroy();

	public void reload();

	/**
	 * Called by the Renderer. You are responsible for settings up all
	 * the necessary GL calls here to achieve your custom effect. You should always call
     * through to the super method to ensure any geometry is handled properly.
	 */
	public void render();
}