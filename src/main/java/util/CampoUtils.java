package util;

import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter;

public class CampoUtils {

    public static void aceitaInteiro(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracteres = e.getKeyChar();
                // Bloqueia '-' e tudo que não for dígito
                if (!Character.isDigit(caracteres) || caracteres == '-') {
                    e.consume();
                }
            }
        });
    }

    public static void aceitaDecimal(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracteres = e.getKeyChar();
                // Bloqueia '-'
                if (caracteres == '-') {
                    e.consume();
                    return;
                }
                // Permite apenas dígitos e uma única vírgula
                if (!Character.isDigit(caracteres) && caracteres != ',') {
                    e.consume();
                } else if (caracteres == ',' && campo.getText().contains(",")) {
                    e.consume(); // já tem uma vírgula
                }
            }
        });
    }

    public static void setTamanhoMaximo(JTextField textField, int max) {
        DocumentFilter filter = new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= max) {
                    super.insertString(fb, offset, string, attr);
                }
            }
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                int newLength = fb.getDocument().getLength() - length + (text == null ? 0 : text.length());
                if (newLength <= max) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        };
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(filter);
    }
}
