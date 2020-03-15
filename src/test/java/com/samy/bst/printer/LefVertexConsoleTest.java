package com.samy.bst.printer;

import com.samy.bst.printer.model.printable.Printable;

public class LefVertexConsoleTest implements Printable<String> {
    @Override
    public String getPrintableValue() {
        return "/";
        }

    @Override
    public int getPrintableOffset() {
        return 1;
    }
}
