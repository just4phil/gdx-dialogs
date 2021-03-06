/*******************************************************************************
 * Copyright 2015 See AUTHORS file.
 *
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
 ******************************************************************************/

package de.tomgrill.gdxdialogs.core;

import de.tomgrill.gdxdialogs.core.dialogs.ButtonDialog;
import de.tomgrill.gdxdialogs.core.dialogs.ButtonDialogAdapter;
import de.tomgrill.gdxdialogs.core.dialogs.ProgressDialog;
import de.tomgrill.gdxdialogs.core.dialogs.ProgressDialogAdapter;
import de.tomgrill.gdxdialogs.core.dialogs.TextPrompt;
import de.tomgrill.gdxdialogs.core.dialogs.TextPromptAdapter;

public class NullDialogManager extends DialogManager {

	private final String TAG = "gdx-dialogs";

	@Override
	public ButtonDialog newButtonDialog() {
		return new ButtonDialogAdapter();
	}

	@Override
	public ProgressDialog newProgressDialog() {
		return new ProgressDialogAdapter();
	}

	@Override
	public TextPrompt newTextPrompt() {
		return new TextPromptAdapter();
	}

}
