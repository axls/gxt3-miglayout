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

import java.util.LinkedList;
import java.util.List;

import net.miginfocom.layout.AC;
import net.miginfocom.layout.ConstraintParser;
import net.miginfocom.layout.LC;
import net.miginfocom.layout.LayoutCallback;

import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.widget.core.client.container.InsertResizeContainer;

public class MigLayoutContainer extends InsertResizeContainer {

	private final List<LayoutCallback> layoutCallbacks = new LinkedList<LayoutCallback>();
	private final LC layoutConstraints;
	private final AC colConstraints;
	private final AC rowConstraints;

	public MigLayoutContainer() {
		this("");
	}

	public MigLayoutContainer(LC layoutConstraints) {
		this(layoutConstraints, null);
	}

	public MigLayoutContainer(LC layoutConstraints, AC colConstraints) {
		this(layoutConstraints, colConstraints, null);
	}

	public MigLayoutContainer(LC layoutConstraints, AC colConstraints, AC rowConstraints) {
		this.layoutConstraints = layoutConstraints;
		this.colConstraints = colConstraints;
		this.rowConstraints = rowConstraints;
		setElement(DOM.createDiv());
		getContainerTarget().makePositionable(true);
	}

	public MigLayoutContainer(String layoutConstraints) {
		this(layoutConstraints, null);
	}

	public MigLayoutContainer(String layoutConstraints, String colConstraints) {
		this(layoutConstraints, colConstraints, null);
	}

	public MigLayoutContainer(String layoutConstraints, String colConstraints, String rowConstraints) {
		this(ConstraintParser.parseLayoutConstraint(ConstraintParser.prepare(layoutConstraints)), ConstraintParser.parseColumnConstraints(ConstraintParser
				.prepare(colConstraints)), ConstraintParser.parseRowConstraints(ConstraintParser.prepare(rowConstraints)));
	}

	public void addLayoutCallback(LayoutCallback callback) {
		if (!layoutCallbacks.contains(callback)) {
			layoutCallbacks.add(callback);
		}
	}

	public void removeLayoutCallback(LayoutCallback callback) {
		layoutCallbacks.remove(callback);
	}

	@UiChild(tagname = "child")
	public void add(IsWidget child, String layoutData) {
		if (child != null) {
			child.asWidget().setLayoutData(layoutData);
		}
		super.add(child);
	}

	public void insert(IsWidget w, int beforeIndex, String layoutData) {
		if (w != null) {
			w.asWidget().setLayoutData(layoutData);
		}
		super.insert(w, beforeIndex);
	}

	@Override
	protected void doLayout() {
		// TODO implement
	}

}