/*
 * Copyright (c) 2007-2018 Siemens AG
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 */

package com.siemens.ct.exi.core.grammars.grammar;

import com.siemens.ct.exi.core.grammars.event.Event;
import com.siemens.ct.exi.core.grammars.event.EventType;

/**
 * 
 * @author Daniel.Peintner.EXT@siemens.com
 * @author Joerg.Heuer@siemens.com
 * 
 * @version 1.0.1-SNAPSHOT
 */

/*
 * <Built-in Document Grammar>
 * 
 * DocContent : SE () DocEnd 0 DT DocContent 1.0 CM DocContent 1.1.0 PI
 * DocContent 1.1.1
 */

public class BuiltInDocContent extends AbstractBuiltInGrammar {

	protected Grammar docEnd;

	public BuiltInDocContent(Grammar docEnd) {
		super();
		this.docEnd = docEnd;
		// SE(*) --> DocEnd
		this.addProduction(START_ELEMENT_GENERIC, docEnd);
	}

	public BuiltInDocContent(Grammar docEnd, String label) {
		this(docEnd);
		this.setLabel(label);
	}
	
	public GrammarType getGrammarType() {
		return GrammarType.BUILT_IN_DOC_CONTENT;
	}
	
	@Override
	public final void addProduction(Event event, Grammar grammar) {
		if(!event.isEventType(EventType.START_ELEMENT_GENERIC) || this.getNumberOfEvents() > 0) {
			throw new RuntimeException("Mis-use of BuiltInDocContent grammar");
		}
		super.addProduction(event, grammar);
	}
	
}
