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

package de.tomgrill.gdxdialogs.ios.dialogs;

import org.robovm.apple.uikit.UIAlertView;
import org.robovm.apple.uikit.UIAlertViewDelegateAdapter;
import org.robovm.apple.uikit.UIAlertViewStyle;
import org.robovm.apple.uikit.UITextField;

import de.tomgrill.gdxdialogs.core.dialogs.TextPrompt;
import de.tomgrill.gdxdialogs.core.listener.TextPromptListener;

public class IOSTextPrompt implements TextPrompt {

	private final String TAG = "gdx-dialogs";

	private String message = "";
	private String title = "";
	private String cancelLabel = "";
	private String confirmLabel = "";

	private TextPromptListener listener;

	private String inputValue = "";

	private UIAlertView alertView;

	@Override
	public TextPrompt show() {

		if (alertView == null) {
			throw new RuntimeException("TextPrompt has not been build. Use build() before show().");
		}
		alertView.show();
		return this;
	}

	@Override
	public TextPrompt build() {

		if (alertView != null) {
			alertView.dispose();
		}

		UIAlertViewDelegateAdapter delegate = new UIAlertViewDelegateAdapter() {

			@Override
			public void didDismiss(UIAlertView alertView, long buttonIndex) {
				if (listener != null) {
					if (buttonIndex == 0) {
						listener.cancel();
					}

					if (buttonIndex == 1) {
						UITextField textFiel = alertView.getTextField(0);
						listener.confirm(textFiel.getText());
					}
				}
			}

			@Override
			public void clicked(UIAlertView alertView, long buttonIndex) {

			}

			@Override
			public void cancel(UIAlertView alertView) {

			}

			@Override
			public void willPresent(UIAlertView alertView) {

			}

			@Override
			public void didPresent(UIAlertView alertView) {

			}

			@Override
			public void willDismiss(UIAlertView alertView, long buttonIndex) {

			}

			@Override
			public boolean shouldEnableFirstOtherButton(UIAlertView alertView) {
				return false;
			}

		};

		String[] otherButtons = new String[1];
		otherButtons[0] = confirmLabel;

		alertView = new UIAlertView(title, message, delegate, cancelLabel, otherButtons);

		alertView.setAlertViewStyle(UIAlertViewStyle.PlainTextInput);

		return this;
	}

	@Override
	public TextPrompt setTitle(CharSequence title) {
		this.title = (String) title;
		return this;
	}

	@Override
	public TextPrompt setMessage(CharSequence message) {
		this.message = (String) message;
		return this;
	}

	@Override
	public TextPrompt setValue(CharSequence value) {
		this.inputValue = (String) value;
		return this;
	}

	@Override
	public TextPrompt setCancelButtonLabel(CharSequence label) {
		this.cancelLabel = (String) label;
		return this;
	}

	@Override
	public TextPrompt setConfirmButtonLabel(CharSequence label) {
		this.confirmLabel = (String) label;
		return this;
	}

	@Override
	public TextPrompt setTextPromptListener(TextPromptListener listener) {
		this.listener = listener;
		return this;
	}

	@Override
	public TextPrompt dismiss() {
		if (alertView == null) {
			throw new RuntimeException("TextPrompt has not been build. Use build() before dismiss().");
		}
		alertView.dismiss(0, false);
		return this;
	}

}
