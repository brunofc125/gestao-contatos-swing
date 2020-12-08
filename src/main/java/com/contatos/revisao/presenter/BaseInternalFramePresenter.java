package com.contatos.revisao.presenter;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class BaseInternalFramePresenter<T extends JInternalFrame> {

    private T view;

    public BaseInternalFramePresenter(JDesktopPane container, T view) {
        if (container == null || view == null) {
            throw new RuntimeException("Passagem nula para construção da presenter");
        }
        for (JInternalFrame frame : container.getAllFrames()) {
            if (frame.getClass().equals(view.getClass())) {
                container.moveToFront(frame);
                frame.dispose();
                break;
            }
        }
        this.view = view;
        Dimension desktopSize = container.getSize();
        Dimension jInternalFrameSize = this.view.getSize();
        this.view.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
        container.add(view);
    }

    public T getView() {
        return view;
    }
}
