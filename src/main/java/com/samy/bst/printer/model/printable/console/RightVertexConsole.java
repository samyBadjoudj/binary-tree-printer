package com.samy.bst.printer.model.printable.console;

import com.samy.bst.printer.model.printable.Printable;

public class RightVertexConsole implements Printable<String> {
    @Override
    public String getPrintableValue() {
        return Printable.ANSI_RED +"\\"+ Printable.ANSI_RESET;
   }

    @Override
    public int getPrintableOffset() {
        return 1;
    }
}
