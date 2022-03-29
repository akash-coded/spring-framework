package com.innerbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringInnerBeanConfig {
	@Bean
	public SpellChecker spellChecker() {
		return new SpellChecker();
	}
	
	@Bean
	public TextEditor textEditor() {
//		TextEditor te = new TextEditor();
//		te.setSpellChecker( spellChecker() );
//		return te;
		
		return new TextEditor( spellChecker() );
	}
}
