package org.jabref.gui.theme;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThemeTest {
    @Test
    public void lightThemeUsedWhenPathIsBlank() {
        Theme theme = new Theme("");

        assertEquals(Theme.Type.DEFAULT, theme.getType());
        assertEquals(Optional.empty(), theme.getAdditionalStylesheet(),
                "didn't expect additional stylesheet to be available");
        // Neste método de caso de teste ele verifica se o caminho para o tema Branco ou 'light theme' esta em branco ou se existe.
    }

    @Test
    public void lightThemeUsedWhenPathIsBaseCss() {
        Theme theme = new Theme("Base.css");

        assertEquals(Theme.Type.DEFAULT, theme.getType());
        assertEquals(Optional.empty(), theme.getAdditionalStylesheet(),
                "didn't expect additional stylesheet to be available");
        // Verifica se o tema Branco é usado caso seja o Css Básico.
    }

    @Test
    public void darkThemeUsedWhenPathIsDarkCss() {
        Theme theme = new Theme("Dark.css");

        assertEquals(Theme.Type.EMBEDDED, theme.getType());
        assertTrue(theme.getAdditionalStylesheet().isPresent());
        assertEquals("Dark.css", theme.getAdditionalStylesheet().get().getWatchPath().getFileName().toString(),
                "expected dark theme stylesheet to be available");
        // Verifica se o tema Escuro é usado quando o caminho for DarkCss.
    }

    @Test
    public void customThemeIgnoredIfDirectory() {
        Theme theme = new Theme(".");

        assertEquals(Theme.Type.DEFAULT, theme.getType());
        assertEquals(Optional.empty(), theme.getAdditionalStylesheet(),
                "didn't expect additional stylesheet to be available when location is a directory");
        // Custom theme é ignorado caso seja um diretorio.
    }

    @Test
    public void customThemeIgnoredIfInvalidPath() {
        Theme theme = new Theme("\0\0\0");

        assertEquals(Theme.Type.DEFAULT, theme.getType());
        assertEquals(Optional.empty(), theme.getAdditionalStylesheet(),
                "didn't expect additional stylesheet when CSS location is just some null terminators!");
        // Custom theme é ignorado caso o caminho para o arquivo seja inváido
    }

    @Test
    public void customThemeIfFileNotFound() {
        Theme theme = new Theme("Idonotexist.css");

        assertEquals(Theme.Type.CUSTOM, theme.getType());
        assertTrue(theme.getAdditionalStylesheet().isPresent());
        assertEquals("Idonotexist.css", theme.getAdditionalStylesheet().get().getWatchPath().getFileName().toString());
    // Teste para o caso de não encontrar o arquivo de tema custom.
    }
}
