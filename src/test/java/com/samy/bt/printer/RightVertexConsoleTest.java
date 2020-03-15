package com.samy.bt.printer;

import com.samy.bt.printer.model.printable.Printable;

public class RightVertexConsoleTest implements Printable<String> {
    @Override
    public String getPrintableValue() {
        return "\\";
   }

    @Override
    public int getPrintableOffset() {
        return 1;
    }
}
