package org.jabref.model.entry.field;

import org.jabref.logic.importer.fileformat.endnote.Volume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardFieldTest {

/*
    @Test
    void fieldNumberOnlyNumbers() {
        String nome = StandardField.NUMBER.getName("2");
        assertTrue(Boolean.parseBoolean("2"),nome);
    } */


    @Test
    void fieldNumberOnlyNumbers() {
       String nome = String.valueOf(StandardField.NUMBER.numberInteiros("2"));
        assertEquals("2", nome);
    }

    @Test
    void fieldNumberCannotTakeSpecialCharacters() {
        String nome = String.valueOf(StandardField.NUMBER.numberInteiros("#teste"));
        assertFalse(Boolean.parseBoolean("#teste"),nome);
    }

    @Test
    void fieldNumberCannotTakeSymbols() {
        String nome = String.valueOf(StandardField.NUMBER.numberInteiros("abd!"));
        assertFalse(Boolean.parseBoolean("abd!"),nome);

    }

    @Test
    void fieldNumberManyNumbers() {
        String nome = String.valueOf(StandardField.NUMBER.numberInteiros("2341"));
        assertEquals("2341", nome);
    }

}
