package com.samy.bst.printer.model.printable.html;

import com.samy.bst.printer.model.printable.Printable;

public class RightVertexHtml implements Printable<String> {
    @Override
    public String getPrintableValue() {
        return " <font color=\"red\">\\</font>";    }

    @Override
    public int getPrintableOffset() {
        return 1;
    }
}
