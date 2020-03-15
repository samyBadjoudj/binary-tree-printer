package com.samy.bst.printer.controller;

import com.samy.bst.printer.BinaryTreeNodeUtils;
import com.samy.bst.printer.model.Position;
import com.samy.bst.printer.model.printable.BinaryTreeNode;
import com.samy.bst.printer.model.printable.Printable;
import com.samy.bst.printer.model.printable.console.LefVertexConsole;
import com.samy.bst.printer.model.printable.console.RightVertexConsole;
import com.samy.bst.printer.model.printable.html.LefVertexHtml;
import com.samy.bst.printer.model.printable.html.RightVertexHtml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.samy.bst.printer.BinaryTreeNodeUtils.getStringByPosition;

@RestController
public class BstPrinterController {

   private static final Logger LOGGER = LoggerFactory.getLogger(BstPrinterController.class);

    public String printBstTest() {
        List<Integer> treeValue = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        BinaryTreeNode root = BinaryTreeNodeUtils.buildTreeFromArray(treeValue, 0);
        BinaryTreeNode root2 = BinaryTreeNodeUtils.buildTreeFromSortedArray(treeValue, 0, treeValue.size()-1, null);
        final Map<Position, Printable<String>> positionBinaryTreeNodeMap = getStringByPosition(root2,new LefVertexHtml(),new RightVertexHtml());
        final Map<Position, Printable<String>> positionBinaryTreeNodeMap2= getStringByPosition(root2,new LefVertexConsole(),new RightVertexConsole());
        String html = BinaryTreeNodeUtils.getStringPrintableFromPrintableByPosition(positionBinaryTreeNodeMap, "<br />","&nbsp;");
        String console = BinaryTreeNodeUtils.getStringPrintableFromPrintableByPosition(positionBinaryTreeNodeMap2, System.lineSeparator()," ");
        LOGGER.info("Display tree generated");
        LOGGER.info(System.lineSeparator() + console);
        return html;
    }


}
