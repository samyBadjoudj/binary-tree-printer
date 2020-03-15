package com.samy.bt.printer;

import com.samy.bt.printer.model.Position;
import com.samy.bt.printer.model.printable.BinaryTreeNode;
import com.samy.bt.printer.model.printable.Printable;
import com.samy.bt.printer.model.printable.console.LefVertexConsole;
import com.samy.bt.printer.model.printable.console.RightVertexConsole;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
public class BinaryTreeNodeUtilsTest {

    Logger LOGGER = LoggerFactory.getLogger(BinaryTreeNodeUtilsTest.class);

    @Test
    public void testBuildTreeFromSortedArray() {

        List<Integer> from = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
        BinaryTreeNode binaryTreeNode = BinaryTreeNodeUtils.buildTreeFromSortedArray(from, 0, from.size() - 1, null);
        LOGGER.info("{}",binaryTreeNode);
        Assert.assertNotNull(binaryTreeNode);
        Assert.assertEquals(binaryTreeNode.getValue(),String.valueOf(2));
        Assert.assertEquals(binaryTreeNode.getRight().getValue(),String.valueOf(3));
        Assert.assertEquals(binaryTreeNode.getLeft().getValue(),String.valueOf(1));

    }

    @Test
    public void buildTreeFromArray() {
        List<Integer> from = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
        BinaryTreeNode binaryTreeNode = BinaryTreeNodeUtils.buildTreeFromArray(from, 0);
        LOGGER.info("{}",binaryTreeNode);
        Assert.assertNotNull(binaryTreeNode);
        Assert.assertEquals(binaryTreeNode.getValue(),String.valueOf(1));
        Assert.assertEquals(binaryTreeNode.getRight().getValue(),String.valueOf(3));
        Assert.assertEquals(binaryTreeNode.getLeft().getValue(),String.valueOf(2));
    }

    @Test
    public void testGetHeight() {
        List<Integer> from = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
        BinaryTreeNode binaryTreeNode = BinaryTreeNodeUtils.buildTreeFromArray(from, 0);
        Assert.assertEquals(2, (int) BinaryTreeNodeUtils.getHeight(binaryTreeNode));
    }


    @Test
    public void testGetLevel() {
        List<Integer> from = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
        BinaryTreeNode binaryTreeNode = BinaryTreeNodeUtils.buildTreeFromArray(from, 0);
        Assert.assertEquals(1, BinaryTreeNodeUtils.getLevel(binaryTreeNode, binaryTreeNode.getLeft(), 0).intValue());
    }

    @Test
    public void testGetBinaryNodesByLevel() {
        List<Integer> from = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
        BinaryTreeNode binaryTreeNode = BinaryTreeNodeUtils.buildTreeFromArray(from, 0);
        Map<Integer, List<BinaryTreeNode>> binaryNodesByLevel = BinaryTreeNodeUtils.getBinaryNodesByLevel(binaryTreeNode);
        Assert.assertEquals(2, binaryNodesByLevel.size());
    }

    @Test
    public void testGetMaxWidth() {
        List<Integer> from = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
        BinaryTreeNode binaryTreeNode = BinaryTreeNodeUtils.buildTreeFromArray(from, 0);
        Assert.assertEquals(2,  BinaryTreeNodeUtils.getMaxWidth(binaryTreeNode).intValue());

    }

   @Test
   public  void testGetStringPrintableByPosition() {
       List<Integer> from = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
       BinaryTreeNode binaryTreeNode = BinaryTreeNodeUtils.buildTreeFromArray(from, 0);
       Map<Position, Printable<String>> stringByPosition = BinaryTreeNodeUtils.getStringByPosition(binaryTreeNode, new LefVertexConsole(), new RightVertexConsole());
      Assert.assertEquals(5,stringByPosition.keySet().size());

    }

    @Test
    public void testPreparePrinting() {
    }

    @Test
    public void testGetStringPrintableFromPrintableByPosition() {
        List<Integer> from = IntStream.rangeClosed(1, 3).boxed().collect(Collectors.toList());
        BinaryTreeNode binaryTreeNode = BinaryTreeNodeUtils.buildTreeFromArray(from, 0);
        Map<Position, Printable<String>> stringByPosition = BinaryTreeNodeUtils.getStringByPosition(binaryTreeNode, new LefVertexConsoleTest(), new RightVertexConsoleTest());

        Assert.assertEquals("     1\n" +
                "    /\\\n" +
                "  2    3\n", BinaryTreeNodeUtils.getStringPrintableFromPrintableByPosition(stringByPosition, System.lineSeparator(), " "));
    }
}