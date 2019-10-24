package com.jstarcraft.nlp.tokenization.corenlp;

import java.util.Iterator;

import com.jstarcraft.nlp.tokenization.Token;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;

public class CoreNlpToken implements Iterable<Token>, Iterator<Token>, Token {

    private Iterator<CoreLabel> iterator;

    private String text;

    private Integer begin;

    private Integer end;

    public CoreNlpToken(Iterator<CoreLabel> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Iterator<Token> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Token next() {
        CoreLabel label = iterator.next();
        text = label.get(CoreAnnotations.TextAnnotation.class);
        begin = label.beginPosition();
        end = label.endPosition();
        return this;
    }

    @Override
    public String getTerm() {
        return text;
    }

    @Override
    public int getBegin() {
        return begin;
    }

    @Override
    public int getEnd() {
        return end;
    }

}
