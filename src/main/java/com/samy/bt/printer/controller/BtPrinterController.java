package com.samy.bt.printer.controller;

import com.samy.bt.printer.BinaryTreeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class BtPrinterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BtPrinterController.class);

    private BinaryTreeService binaryTreeService;

    public BtPrinterController(@Autowired BinaryTreeService binaryTreeService) {
        this.binaryTreeService = binaryTreeService;
    }

    @GetMapping("printBt")
    @CrossOrigin(origins = "*")
    public String printBtTest() {
        List<String> strings = Arrays.asList("allo", "huile", "cheval", "marabou");
        LOGGER.info("Display tree generated");
        LOGGER.info(System.lineSeparator() + binaryTreeService.getStringBinaryTreeRepresentationFromIntegerList(strings));
        return binaryTreeService.getHtmlStringBinaryTreeRepresentationFromIntegerList(strings);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("printBtFromString")
    public String printBtFromParsable(@RequestParam("content") String content) {
        LOGGER.info("Generate tree from pattern {}",content);
        LOGGER.info(System.lineSeparator() + binaryTreeService.getStringBinaryRepresentationFromParsableContent(content));
        return binaryTreeService.getHtmlStringBinaryRepresentationFromParsableContent(content);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("printBstFromArrayString")
    public String printBstFromArrayString(@RequestParam("content") String content) {
        LOGGER.info("Generate tree from array unsorted {}",content);
        List<String> values = Arrays.stream(content.split(",")).sorted().collect(Collectors.toList());
        LOGGER.info(System.lineSeparator() + binaryTreeService.getStringBinaryTreeRepresentationFromIntegerList(values));
        return binaryTreeService.getHtmlStringBinaryTreeRepresentationFromIntegerList(values);

    }

}
