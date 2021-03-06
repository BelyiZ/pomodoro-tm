/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pomodoro;

import com.intellij.CommonBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.ResourceBundle;

/**
 * Copied from {@link com.intellij.ui.UIBundle}.
 */
public class UIBundle {
	private static Reference<ResourceBundle> ourBundle;
	@NonNls
	protected static final String PATH_TO_BUNDLE = "resources.messages";

	public static String message(@PropertyKey(resourceBundle = "resources.messages") String key, Object... params) {
		return CommonBundle.message(getBundle(), key, params);
	}

	private static ResourceBundle getBundle() {
		ResourceBundle bundle = null;
		if (ourBundle != null) bundle = ourBundle.get();
		if (bundle == null) {
			bundle = ResourceBundle.getBundle(PATH_TO_BUNDLE);
			ourBundle = new SoftReference<ResourceBundle>(bundle);
		}
		return bundle;
	}

}
