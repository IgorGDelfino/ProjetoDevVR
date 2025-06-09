package util;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class FormUtils {

    public static void abrirFormulario(JDesktopPane desktop, JInternalFrame form) {
        // Adiciona o formulário ao desktop
        desktop.add(form);

        // Centraliza o formulário
        int desktopWidth = desktop.getWidth();
        int desktopHeight = desktop.getHeight();
        int internalFrameWidth = form.getWidth();
        int internalFrameHeight = form.getHeight();
        int x = (desktopWidth - internalFrameWidth) / 2;
        int y = (desktopHeight - internalFrameHeight) / 2;
        form.setLocation(x, y);

        // Torna o formulário visível
        form.setVisible(true);

        // Traz o formulário para frente e tenta selecioná-lo
        form.toFront();
        try {
            form.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }
}


