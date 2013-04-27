/*
 * Copyright (c) 2013, Harald Westphal
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * * Neither the name of the author nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
 * DAMAGE.
 */
package net.miginfocom.layout.gxt3;

import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.ContainerWrapper;
import net.miginfocom.layout.LayoutUtil;
import net.miginfocom.layout.PlatformDefaults;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.dom.XDOM;
import com.sencha.gxt.widget.core.client.container.Container;

class GxtComponentWrapper implements ComponentWrapper {

	private final Widget widget;
	private final GxtContainerWrapper container;
	private final int preferredWidth;
	private final int preferredHeight;

	GxtComponentWrapper(Widget widget, GxtContainerWrapper container, int preferredWidth, int preferredHeight) {
		this.widget = widget;
		this.container = container;
		this.preferredWidth = preferredWidth;
		this.preferredHeight = preferredHeight;
	}

	GxtComponentWrapper(Widget widget) {
		this(widget, null, -1, -1);
	}

	@Override
	public Object getComponent() {
		return widget;
	}

	@Override
	public int getX() {
		return widget.getElement().getOffsetLeft();
	}

	@Override
	public int getY() {
		return widget.getElement().getOffsetTop();
	}

	@Override
	public int getWidth() {
		return widget.getOffsetWidth();
	}

	@Override
	public int getHeight() {
		return widget.getOffsetHeight();
	}

	@Override
	public int getScreenLocationX() {
		return widget.getAbsoluteLeft();
	}

	@Override
	public int getScreenLocationY() {
		return widget.getAbsoluteTop();
	}

	@Override
	public int getMinimumWidth(int hHint) {
		return 1;
	}

	@Override
	public int getMinimumHeight(int wHint) {
		return 1;
	}

	@Override
	public int getPreferredWidth(int hHint) {
		return preferredWidth;
	}

	@Override
	public int getPreferredHeight(int wHint) {
		return preferredHeight;
	}

	@Override
	public int getMaximumWidth(int hHint) {
		return LayoutUtil.INF;
	}

	@Override
	public int getMaximumHeight(int wHint) {
		return LayoutUtil.INF;
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		if (container != null) {
			container.applyLayout(widget, x, y, width, height);
		}
	}

	@Override
	public boolean isVisible() {
		return widget.isVisible();
	}

	@Override
	public int getBaseline(int width, int height) {
		return -1;
	}

	@Override
	public boolean hasBaseline() {
		return false;
	}

	@Override
	public ContainerWrapper getParent() {
		return container;
	}

	@Override
	public float getPixelUnitFactor(boolean isHor) {
		// TODO determine pixel unit factor
		return 1.0f;
	}

	@Override
	public int getHorizontalScreenDPI() {
		// TODO determine screen resolution
		return PlatformDefaults.getDefaultDPI();
	}

	@Override
	public int getVerticalScreenDPI() {
		// TODO determine screen resolution
		return PlatformDefaults.getDefaultDPI();
	}

	@Override
	public int getScreenWidth() {
		return XDOM.getViewportWidth();
	}

	@Override
	public int getScreenHeight() {
		return XDOM.getViewportHeight();
	}

	@Override
	public String getLinkId() {
		return widget.getElement().getId();
	}

	@Override
	public int getLayoutHashCode() {
		String id = getLinkId();
		int idHash = id == null ? 0 : id.hashCode();
		return (widget.isVisible() ? 1 : 0) + 2 * idHash;
	}

	@Override
	public int[] getVisualPadding() {
		return null;
	}

	@Override
	public void paintDebugOutline() {
		// TODO support debug mode
	}

	@Override
	public int getComponetType(boolean disregardScrollPane) {
		if (widget instanceof Container) {
			return TYPE_CONTAINER;
		}
		return TYPE_UNKNOWN;
	}

}
