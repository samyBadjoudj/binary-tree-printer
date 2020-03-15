package com.samy.bt.printer.model.printable.html;

import com.samy.bt.printer.model.printable.Printable;

public class LefVertexHtml implements Printable<String> {
    @Override
    public String getPrintableValue() {
        return "<font color=\"green\">/</font> ";    }

    @Override
    public int getPrintableOffset() {
        return 1;
    }
}
