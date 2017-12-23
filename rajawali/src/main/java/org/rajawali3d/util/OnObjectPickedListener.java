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
package org.rajawali3d.util;
import android.support.annotation.NonNull;
import org.rajawali3d.Object3D;

public interface OnObjectPickedListener {

	/**
	 * Called when an object has been picked successfully.
	 *
	 * @param object {@link Object3D} The picked object.
     */
	void onObjectPicked(@NonNull Object3D object);

	/**
	 * Called when no object was detected during picking.
	 */
	void onNoObjectPicked();
}
