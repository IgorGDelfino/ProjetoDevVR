package util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class AtalhoTecladoUtils {

    public static void atalhoTeclado(JComponent component,
                                     String tecla,
                                     String funcao,
                                     final Consumer<ActionEvent> action) {
        component.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
                .put(KeyStroke.getKeyStroke(tecla), funcao);
        component.getActionMap().put(funcao, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.accept(e);
            }
        });
    }

    public static void funcaoTeclado(JComponent component,
                                     boolean utilizaF1, Consumer<ActionEvent> onConsultar,
                                     boolean utilizaEsc, Consumer<ActionEvent> onSair,
                                     boolean utilizaEnter, Consumer<ActionEvent> onEnter,
                                     boolean utilizaF3, Consumer<ActionEvent> onSalvar) {
        if (utilizaF1) atalhoTeclado(component, "F1", "consultar", onConsultar);
        if (utilizaEsc) atalhoTeclado(component, "ESCAPE", "sair", onSair);
        if (utilizaEnter) atalhoTeclado(component, "ENTER", "proximoCampo", onEnter);
        if (utilizaF3) atalhoTeclado(component, "F3", "salvar", onSalvar);

    }

    public static void focusNext(Component jSair, Runnable jSairAction,
                                 Component jSalvar2, Runnable jSalvar2Action,
                                 Component jAdicionar, Runnable jAdicionarAction) {
        Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

        if (focusOwner == jSair && jSairAction != null) {
            jSairAction.run();
        } else if (focusOwner == jSalvar2 && jSalvar2Action != null) {
            jSalvar2Action.run();
        } else if (focusOwner == jAdicionar && jAdicionarAction != null) {
            jAdicionarAction.run();
        } else {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
        }
    }

    public static void funcaoEnterNaTabela(JTable tabela, final Runnable acaoEnter) {
        InputMap inputMap = tabela.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = tabela.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("ENTER"), "customEnter");
        actionMap.put("customEnter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoEnter.run();
            }
        });
    }
}