package com.samy.bst.printer.model.printable.console;

import com.samy.bst.printer.model.printable.Printable;

public class LefVertexConsole implements Printable<String> {
    @Override
    public String getPrintableValue() {
        return Printable.ANSI_GREEN +"/"+ Printable.ANSI_RESET;
        }

    @Override
    public int getPrintableOffset() {
        return 1;
    }
}
