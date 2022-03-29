package com.innerbean;

import org.springframework.beans.factory.annotation.*;

public class TextEditor {
	private SpellChecker spellChecker;
	
	public TextEditor() {
		
	}
	
	public TextEditor(SpellChecker spellChecker) {
		System.out.println("Inside TextEditor constructor");
		this.spellChecker = spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("Inside setSpellChecker");
		this.spellChecker = spellChecker;
	}
	
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	
	public void spellCheck() {
		spellChecker.spellChecking();
	}
}
